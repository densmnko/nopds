package org.densmnko.nopds.nima;

import io.helidon.nima.testing.junit5.webserver.ServerTest;
import io.helidon.nima.webclient.http1.Http1Client;
import org.junit.jupiter.api.Disabled;

@Disabled
@ServerTest
public class OpdsServiceServerTest extends OpdsServiceTest {
    protected OpdsServiceServerTest(Http1Client client) {
        super(client);
    }
}
