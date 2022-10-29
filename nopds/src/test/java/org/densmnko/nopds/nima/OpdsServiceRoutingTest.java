package org.densmnko.nopds.nima;

import io.helidon.nima.testing.junit5.webserver.DirectClient;
import io.helidon.nima.testing.junit5.webserver.RoutingTest;


@RoutingTest
public class OpdsServiceRoutingTest extends OpdsServiceTest {
    protected OpdsServiceRoutingTest(DirectClient client) {
        super(client);
    }
}
