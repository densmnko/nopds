package org.densmnko.nopds.nima;

import io.helidon.common.http.Http;
import io.helidon.nima.webserver.WebServer;
import io.helidon.nima.webserver.http.HttpRouting;

public class Main {
    private static final Http.HeaderValue SERVER = Http.Header.create(Http.Header.SERVER, "Nima");

    private static OpdsService opdsService;

    public static void main(String[] args) {

        opdsService = new OpdsService();

        WebServer ws = WebServer.builder()
                .routing(Main::routing)
                .start();

/*
        BlockingService.client(Http1Client.builder()
                                       .baseUri("http://localhost:" + ws.port())
                                       .build());
*/
    }

    static void routing(HttpRouting.Builder rules) {

        rules.addFilter((chain, req, res) -> {
                    res.header(SERVER);
                    chain.proceed();
                })
                //.get("/remote", Main::remote)
                .register("/", opdsService);
    }

}
