package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jayway.jsonpath.DocumentContext;

class LotteryNumberTest extends LotteryNumberBaseTest {

    @Test
    void testFiveOutOfNinetyShouldReturnFiveNumbersWhenCalled() throws Exception {
        // GIVEN
        setUpLotteryServiceStub(LotteryType.FIVE_OUT_OF_NINETY, "five_out_of_ninety", HttpStatus.OK);
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceRetrieveLotteryNumberUrl(LotteryType.FIVE_OUT_OF_NINETY));
        addEdgeServiceRequestHeaders(requestBuilder);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedResponse, response);
    }

    @Test
    void testSixOutOfFortyFiveShouldReturnSixNumbersWhenCalled() throws Exception {
        // GIVEN
        setUpLotteryServiceStub(LotteryType.SIX_OUT_OF_FORTY_FIVE, "six_out_of_forty_five", HttpStatus.OK);
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceRetrieveLotteryNumberUrl(LotteryType.SIX_OUT_OF_FORTY_FIVE));
        addEdgeServiceRequestHeaders(requestBuilder);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedResponse, response);
    }

    @Test
    void testScandinavianShouldReturnSevenNumbersWhenCalled() throws Exception {
        // GIVEN
        setUpLotteryServiceStub(LotteryType.SCANDINAVIAN, "scandinavian", HttpStatus.OK);
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceRetrieveLotteryNumberUrl(LotteryType.SCANDINAVIAN));
        addEdgeServiceRequestHeaders(requestBuilder);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedResponse, response);
    }
}
