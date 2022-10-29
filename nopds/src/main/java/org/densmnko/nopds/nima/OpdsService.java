package org.densmnko.nopds.nima;

import io.helidon.common.http.Http;
import io.helidon.nima.webserver.http.HttpRules;
import io.helidon.nima.webserver.http.HttpService;
import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OpdsService implements HttpService {

    static final Http.HeaderValue CONTENT_TYPE_TEXT_XML = Http.Header.createCached(Http.Header.CONTENT_TYPE, "text/xml;charset=UTF-8");

    @Override
    public void routing(HttpRules httpRules) {
        httpRules.get("/opds", this::opds);
    }

    private void opds(ServerRequest serverRequest, ServerResponse serverResponse) throws IOException {
        serverResponse.header(CONTENT_TYPE_TEXT_XML);

        final OutputStream outputStream = serverResponse.outputStream();
        outputStream.write(("<feed xmlns=\"http://www.w3.org/2005/Atom\"\n" +
                "      xmlns:dc=\"http://purl.org/dc/terms/\"\n" +
                "      xmlns:opds=\"http://opds-spec.org/2010/catalog\">\n" +
                "  <id>urn:uuid:433a5d6a-0b8c-4933-af65-4ca4f02763eb</id>\n" +
                "\n" +
                "  <link rel=\"related\"\n" +
                "        href=\"/opds-catalogs/vampire.farming.xml\"\n" +
                "        type=\"application/atom+xml;profile=opds-catalog;kind=acquisition\"/>\n" +
                "  <link rel=\"self\"    \n" +
                "        href=\"/opds-catalogs/unpopular.xml\"\n" +
                "        type=\"application/atom+xml;profile=opds-catalog;kind=acquisition\"/>\n" +
                "  <link rel=\"start\"  \n" +
                "        href=\"/opds-catalogs/root.xml\"\n" +
                "        type=\"application/atom+xml;profile=opds-catalog;kind=navigation\"/>\n" +
                "  <link rel=\"up\"      \n" +
                "        href=\"/opds-catalogs/root.xml\"\n" +
                "        type=\"application/atom+xml;profile=opds-catalog;kind=navigation\"/>\n" +
                "\n" +
                "  <title>Unpopular Publications</title>\n" +
                "  <updated>2010-01-10T10:01:11Z</updated>\n" +
                "  <author>\n" +
                "    <name>Spec Writer</name>\n" +
                "    <uri>http://opds-spec.org</uri>\n" +
                "  </author>\n" +
                "\n" +
                "  <entry>\n" +
                "    <title>Bob, Son of Bob</title>\n" +
                "    <id>urn:uuid:6409a00b-7bf2-405e-826c-3fdff0fd0734</id>\n" +
                "    <updated>2010-01-10T10:01:11Z</updated>\n" +
                "    <author>\n" +
                "      <name>Bob the Recursive</name>\n" +
                "      <uri>http://opds-spec.org/authors/1285</uri>\n" +
                "    </author>\n" +
                "    <dc:language>en</dc:language>\n" +
                "    <dc:issued>1917</dc:issued>\n" +
                "    <category scheme=\"http://www.bisg.org/standards/bisac_subject/index.html\"\n" +
                "              term=\"FIC020000\"\n" +
                "              label=\"FICTION / Men's Adventure\"/>\n" +
                "    <summary>The story of the son of the Bob and the gallant part he played in\n" +
                "      the lives of a man and a woman.</summary>\n" +
                "    <link rel=\"http://opds-spec.org/image\"    \n" +
                "          href=\"/covers/4561.lrg.png\"\n" +
                "          type=\"image/png\"/>\n" +
                "    <link rel=\"http://opds-spec.org/image/thumbnail\"\n" +
                "          href=\"/covers/4561.thmb.gif\"\n" +
                "          type=\"image/gif\"/>\n" +
                "\n" +
                "    <link rel=\"alternate\"\n" +
                "          href=\"/opds-catalogs/entries/4571.complete.xml\"\n" +
                "          type=\"application/atom+xml;type=entry;profile=opds-catalog\"\n" +
                "          title=\"Complete Catalog Entry for Bob, Son of Bob\"/>\n" +
                "\n" +
                "    <link rel=\"http://opds-spec.org/acquisition\"\n" +
                "          href=\"/content/free/4561.epub\"\n" +
                "          type=\"application/epub+zip\"/>\n" +
                "    <link rel=\"http://opds-spec.org/acquisition\"\n" +
                "          href=\"/content/free/4561.mobi\"\n" +
                "          type=\"application/x-mobipocket-ebook\"/>\n" +
                " </entry>\n" +
                "\n" +
                " <entry>\n" +
                "    <title>Modern Online Philately</title>\n" +
                "    <id>urn:uuid:7b595b0c-e15c-4755-bf9a-b7019f5c1dab</id>\n" +
                "    <author>\n" +
                "      <name>Stampy McGee</name>\n" +
                "      <uri>http://opds-spec.org/authors/21285</uri>\n" +
                "    </author>\n" +
                "    <author>\n" +
                "      <name>Alice McGee</name>\n" +
                "      <uri>http://opds-spec.org/authors/21284</uri>\n" +
                "    </author>\n" +
                "    <author>\n" +
                "      <name>Harold McGee</name>\n" +
                "      <uri>http://opds-spec.org/authors/21283</uri>\n" +
                "    </author>\n" +
                "    <updated>2010-01-10T10:01:10Z</updated>\n" +
                "    <rights>Copyright (c) 2009, Stampy McGee</rights>\n" +
                "    <dc:identifier>urn:isbn:978029536341X</dc:identifier>\n" +
                "    <dc:publisher>StampMeOnline, Inc.</dc:publisher>\n" +
                "    <dc:language>en</dc:language>\n" +
                "    <dc:issued>2009-10-01</dc:issued>\n" +
                "    <content type=\"text\">The definitive reference for the web-curious\n" +
                "      philatelist.</content>\n" +
                "    <link rel=\"http://opds-spec.org/image\"    \n" +
                "          href=\"/covers/11241.lrg.jpg\"\n" +
                "          type=\"image/jpeg\"/>\n" +
                "\n" +
                "    <link rel=\"http://opds-spec.org/acquisition/buy\"\n" +
                "          href=\"/content/buy/11241.epub\"\n" +
                "          type=\"application/epub+zip\">\n" +
                "      <opds:price currencycode=\"USD\">18.99</opds:price>\n" +
                "      <opds:price currencycode=\"GBP\">11.99</opds:price>\n" +
                "    </link>\n" +
                " </entry>\n" +
                "</feed>").getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

}
