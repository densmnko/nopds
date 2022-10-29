package org.densmnko.nopds.nima;

import io.helidon.common.http.Http;
import io.helidon.nima.testing.junit5.webserver.SetUpRoute;
import io.helidon.nima.webclient.http1.Http1Client;
import io.helidon.nima.webclient.http1.Http1ClientResponse;
import io.helidon.nima.webserver.http.HttpRouting;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
public abstract class OpdsServiceTest {

    private final Http1Client client;

    protected OpdsServiceTest(Http1Client client) {
        this.client = client;
    }

    @SetUpRoute
    static void routing(HttpRouting.Builder builder) {
        //Main.routing(builder);
        builder.register("/", new OpdsService());
    }

    @Test
    void opds() {
        try (Http1ClientResponse response = client.get("/opds")
                .request()) {
            assertThat(response.status(), is(Http.Status.OK_200));
            String entity = response.as(String.class);
            assertThat(entity, startsWith("catalog is here"));
        }
    }


}
