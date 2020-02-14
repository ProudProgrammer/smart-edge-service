package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve;

import java.util.HashMap;
import java.util.Map;

import org.gaborbalazs.smartplatform.edgeservice.integrationtest.base.TestBase;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

class LotteryNumberBaseTest extends TestBase {

    private static final String LOTTERY_SERVICE_RESOURCE_PATH = "lotteryService/";
    private static final Map<String, String> EDGE_SERVICE_REQUEST_HEADERS;
    private static final Map<String, String> LOTTERY_SERVICE_RESPONSE_HEADERS;

    static {
        EDGE_SERVICE_REQUEST_HEADERS = new HashMap<>();
        EDGE_SERVICE_REQUEST_HEADERS.put("Consumer-Name", "test");
        EDGE_SERVICE_REQUEST_HEADERS.put("Request-Id", "test0000-0000-0000-0000-test00000000");
        EDGE_SERVICE_REQUEST_HEADERS.put("Locale", "hu-HU");

        LOTTERY_SERVICE_RESPONSE_HEADERS = new HashMap<>();
        LOTTERY_SERVICE_RESPONSE_HEADERS.put("Generator-Type", "default");
        LOTTERY_SERVICE_RESPONSE_HEADERS.put("Locale", "hu-HU");
    }

    String getEdgeServiceRetrieveLotteryNumberUrl(LotteryType lotteryType) {
        return "/retrieve/lottery/" + lotteryType.getPathVariableName() + "/numbers";
    }

    void setUpLotteryServiceStub(LotteryType lotteryType, String responseFile, HttpStatus httpStatus) {
        setUpStub("/lottery/" + lotteryType.getPathVariableName() + "/numbers", LOTTERY_SERVICE_RESOURCE_PATH + responseFile + ".json", httpStatus,
                LOTTERY_SERVICE_RESPONSE_HEADERS);
    }

    void addEdgeServiceRequestHeaders(MockHttpServletRequestBuilder mockHttpServletRequestBuilder) {
        EDGE_SERVICE_REQUEST_HEADERS.forEach(mockHttpServletRequestBuilder::header);
    }
}
