package org.gaborbalazs.smartplatform.edgeservice.integrationtest.test;

import com.jayway.jsonpath.DocumentContext;
import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

class LotteryNumberRetrieveTest extends TestBase {

    private final static String EDGE_SERVICE_LOTTERY_NUMBER_RETRIEVE_FIVE_OUT_OF_NINETY_ENDPOINT =
            "/retrieve/lottery/" + LotteryType.FIVE_OUT_OF_NINETY.getPathVariableName() + "/numbers/random";

    @Test
    void testRetrieveRandom() throws Exception {
        // GIVEN
        wireMockService.setUpLotteryServiceStub("five_out_of_ninety_random", HttpStatus.OK);
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EDGE_SERVICE_LOTTERY_NUMBER_RETRIEVE_FIVE_OUT_OF_NINETY_ENDPOINT);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<Integer> response = documentContext.read("$", List.class);

        // THEN
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expectedResponse, response);
    }
}
