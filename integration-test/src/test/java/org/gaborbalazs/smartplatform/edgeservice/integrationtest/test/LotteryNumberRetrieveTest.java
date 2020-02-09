package org.gaborbalazs.smartplatform.edgeservice.integrationtest.test;

import java.util.List;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jayway.jsonpath.DocumentContext;

class LotteryNumberRetrieveTest extends TestBase {

    @Test
    void testFiveOutOfNinetyShouldReturnFiveNumbersWhenCalled() throws Exception {
        // GIVEN
        wireMockService.setUpLotteryServiceGenerateRandomStub(LotteryType.FIVE_OUT_OF_NINETY, "five_out_of_ninety_random", HttpStatus.OK);
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceLotteryNumberRetrieveUrl(LotteryType.FIVE_OUT_OF_NINETY));
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<Integer> response = documentContext.read("$", List.class);

        // THEN
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    void testSixOutOfFortyFiveShouldReturnSixNumbersWhenCalled() throws Exception {
        // GIVEN
        wireMockService.setUpLotteryServiceGenerateRandomStub(LotteryType.SIX_OUT_OF_FORTY_FIVE, "six_out_of_forty_five_random", HttpStatus.OK);
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceLotteryNumberRetrieveUrl(LotteryType.SIX_OUT_OF_FORTY_FIVE));
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<Integer> response = documentContext.read("$", List.class);

        // THEN
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    void testScandinavianShouldReturnSevenNumbersWhenCalled() throws Exception {
        // GIVEN
        wireMockService.setUpLotteryServiceGenerateRandomStub(LotteryType.SCANDINAVIAN, "scandinavian", HttpStatus.OK);
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceLotteryNumberRetrieveUrl(LotteryType.SCANDINAVIAN));
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<Integer> response = documentContext.read("$", List.class);

        // THEN
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        Assertions.assertEquals(expectedResponse, response);
    }

    private String getEdgeServiceLotteryNumberRetrieveUrl(LotteryType lotteryType) {
        return "/retrieve/lottery/" + lotteryType.getPathVariableName() + "/numbers";
    }
}
