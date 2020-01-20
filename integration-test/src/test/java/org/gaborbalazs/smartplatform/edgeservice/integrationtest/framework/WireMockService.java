package org.gaborbalazs.smartplatform.edgeservice.integrationtest.framework;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@Component
public class WireMockService {

    private static final String WIREMOCK_DEFAULT_STUB_PATH = "response/mock/";

    @Autowired
    private JsonResourceProvider jsonResourceProvider;

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

    public void setUpLotteryServiceGenerateRandomStub(LotteryType lotteryType, String responseFile, HttpStatus httpStatus) {
        setUpStub("/lottery/" + lotteryType.getPathVariableName() + "/numbers/random", "lotteryService/" + responseFile + ".json", httpStatus);
    }

    private void setUpStub(String urlPattern, String responseFilePath, HttpStatus httpStatus) {
        WireMock.stubFor(WireMock.get(WireMock.urlPathMatching(urlPattern))
                .willReturn(WireMock.aResponse()
                        .withStatus(httpStatus.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                        .withBody(jsonResourceProvider.getJsonContent(WIREMOCK_DEFAULT_STUB_PATH + responseFilePath))
                ));
    }
}