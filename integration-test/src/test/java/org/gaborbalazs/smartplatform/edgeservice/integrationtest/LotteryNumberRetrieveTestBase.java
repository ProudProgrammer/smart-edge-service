package org.gaborbalazs.smartplatform.edgeservice.integrationtest;

import org.gaborbalazs.smartplatform.edgeservice.application.EdgeServiceApplication;
import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EdgeServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
public class LotteryNumberRetrieveTestBase {

    protected final static String EDGE_SERVICE_LOTTERY_NUMBER_RETRIEVE_FIVE_OUT_OF_NINETY_ENDPOINT =
            "/retrieve/lottery/" + LotteryType.FIVE_OUT_OF_NINETY.getPathVariableName() + "/numbers/random";
    protected final static String LOTTERY_SERVICE_GENERATE_RANDOM_FIVE_OUT_OF_NINETY_ENDPOINT =
            "/lottery/" + LotteryType.FIVE_OUT_OF_NINETY.getPathVariableName() + "/numbers/random";

    @Autowired
    protected MockMvc mockMvc;

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8345));
        wireMockServer.start();
        WireMock.configureFor(wireMockServer.port());
        WireMock.stubFor(WireMock.get(WireMock.urlMatching(LOTTERY_SERVICE_GENERATE_RANDOM_FIVE_OUT_OF_NINETY_ENDPOINT))
                .willReturn(WireMock
                        .aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                        .withBody("[1,2,3,4,5]"))
        );
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }
}
