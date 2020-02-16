package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve;

import com.jayway.jsonpath.DocumentContext;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryNumberTest extends LotteryNumberBaseTest {

    @Test
    void testWithLotteryTypeOfFiveOutOfNinetyWithoutGeneratorType() throws Exception {
        // GIVEN
        setUpLotteryServiceStub(LotteryType.FIVE_OUT_OF_NINETY, "five_out_of_ninety", HttpStatus.OK, DEFAULT_RESPONSE_HEADERS);
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceRetrieveLotteryNumberUrl(LotteryType.FIVE_OUT_OF_NINETY));
        DEFAULT_REQUEST_HEADERS.forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfSixOutOfFortyFiveWithoutGeneratorType() throws Exception {
        // GIVEN
        setUpLotteryServiceStub(LotteryType.SIX_OUT_OF_FORTY_FIVE, "six_out_of_forty_five", HttpStatus.OK, DEFAULT_RESPONSE_HEADERS);
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceRetrieveLotteryNumberUrl(LotteryType.SIX_OUT_OF_FORTY_FIVE));
        DEFAULT_REQUEST_HEADERS.forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfScandinavianWithoutGeneratorType() throws Exception {
        // GIVEN
        setUpLotteryServiceStub(LotteryType.SCANDINAVIAN, "scandinavian", HttpStatus.OK, DEFAULT_RESPONSE_HEADERS);
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceRetrieveLotteryNumberUrl(LotteryType.SCANDINAVIAN));
        DEFAULT_REQUEST_HEADERS.forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithQuantityAndPoolSizeWithoutGeneratorType() throws Exception {
        // GIVEN
        setUpLotteryServiceStub(5 ,90, "five_out_of_ninety", HttpStatus.OK, DEFAULT_RESPONSE_HEADERS);
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(getEdgeServiceRetrieveLotteryNumberUrl(5, 90));
        DEFAULT_REQUEST_HEADERS.forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = getResponseAsJsonParser(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }
}
