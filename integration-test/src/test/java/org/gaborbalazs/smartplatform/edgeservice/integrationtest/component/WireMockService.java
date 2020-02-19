package org.gaborbalazs.smartplatform.edgeservice.integrationtest.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@Component
public class WireMockService {

    private static final String BASE_RESOURCE_PATH = "response/mock/";

    @Autowired
    private JsonResourceFactory jsonResourceFactory;

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

    void setUpStub(String url, String responseFilePath, HttpStatus httpStatus, Map<String, String> headers) {
        ResponseDefinitionBuilder responseDefinitionBuilder = WireMock.aResponse()
                .withStatus(httpStatus.value())
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .withBody(jsonResourceFactory.create(BASE_RESOURCE_PATH + responseFilePath));
        headers.forEach(responseDefinitionBuilder::withHeader);
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url)).willReturn(responseDefinitionBuilder));
    }
}