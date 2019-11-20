package org.gaborbalazs.smartplatform.edgeservice.integrationtest.framework;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class WireMockService {

    private static final String WIREMOCK_DEFAULT_STUB_PATH = "response/mock/";
    private static final String LOTTERY_SERVICE_GENERATE_RANDOM_FIVE_OUT_OF_NINETY_ENDPOINT =
            "/lottery/" + LotteryType.FIVE_OUT_OF_NINETY.getPathVariableName() + "/numbers/random";

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

    public void setUpLotteryServiceStub(String responseFile, HttpStatus httpStatus) {
        setUpStub(LOTTERY_SERVICE_GENERATE_RANDOM_FIVE_OUT_OF_NINETY_ENDPOINT, "lotteryService/" + responseFile + ".json", httpStatus);
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