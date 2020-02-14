package org.gaborbalazs.smartplatform.edgeservice.integrationtest.framework;

import org.springframework.stereotype.Component;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@Component
public class WireMockService {

    private WireMockServer wireMockServer;

    public void start() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8345));
        wireMockServer.start();
        WireMock.configureFor(wireMockServer.port());
    }

    public void stop() {
        if (wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }
}