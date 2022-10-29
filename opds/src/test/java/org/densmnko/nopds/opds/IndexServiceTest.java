package org.densmnko.nopds.opds;

import com.ctc.wstx.osgi.InputFactoryProviderImpl;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.osgi.Stax2InputFactoryProvider;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class IndexServiceTest {

    @Test
    public void index() throws IOException, XMLStreamException, ExecutionException, InterruptedException {


        final List<String> files = Arrays.asList("f.fb2-510526-513033.zip", "f.fb2-634745-637734.zip");

        final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();


        final List<Future> futures = new ArrayList<>();
        Stax2InputFactoryProvider provider = new InputFactoryProviderImpl();
        final XMLInputFactory2 inputFactory = provider.createInputFactory();

        for (var fileName : files) {
            futures.add(executorService.submit(() -> {
                        ZipFile file = null;
                        try {
                            file = new ZipFile("Y:\\Books\\fb2.Flibusta.Net\\" + fileName);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        var entries = file.entries();
                        while (entries.hasMoreElements()) {
                            // get the zip entry
                            ZipEntry entry = entries.nextElement();
                            // display the entry
                            System.out.println(entry.getName());
                            try (final InputStream inputStream = file.getInputStream(entry)) {
                                final XMLEventReader reader = inputFactory.createXMLEventReader(inputStream);
                                while (reader.hasNext()) {
                                    XMLEvent event = reader.nextEvent();
                                    if (event.isStartElement()) {
                                        final StartElement element = event.asStartElement();
                                        final QName name = element.getName();
                                        if ("book-title".equals(name.getLocalPart())) {
                                            event = reader.nextEvent();
                                            System.out.println(event.asCharacters().getData());
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        return null;
                    }
            ));
        }

        for ( var f : futures ) {
            f.get();
        }


    }


}
