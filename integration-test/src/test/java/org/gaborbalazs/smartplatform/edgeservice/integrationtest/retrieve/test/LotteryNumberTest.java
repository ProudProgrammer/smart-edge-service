package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve.test;

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
        lotteryServiceStub.setUp(LotteryType.FIVE_OUT_OF_NINETY, "five_out_of_ninety.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.FIVE_OUT_OF_NINETY));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfFiveOutOfNinetyWitGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.DEFAULT, "five_out_of_ninety.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfFiveOutOfNinetyWitGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.EXPERIMENTAL, "five_out_of_ninety.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.EXPERIMENTAL.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfSixOutOfFortyFiveWithoutGeneratorType() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SIX_OUT_OF_FORTY_FIVE, "six_out_of_forty_five.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SIX_OUT_OF_FORTY_FIVE));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfSixOutOfFortyFiveWithGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.DEFAULT, "six_out_of_forty_five.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfSixOutOfFortyFiveWithGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.EXPERIMENTAL, "six_out_of_forty_five.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.EXPERIMENTAL.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfScandinavianWithoutGeneratorType() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SCANDINAVIAN, "scandinavian.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SCANDINAVIAN));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfScandinavianWitGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SCANDINAVIAN, GeneratorType.DEFAULT, "scandinavian.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SCANDINAVIAN, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithLotteryTypeOfScandinavianWitGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SCANDINAVIAN, GeneratorType.EXPERIMENTAL, "scandinavian.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.EXPERIMENTAL.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SCANDINAVIAN, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithQuantityAndPoolSizeWithoutGeneratorType() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(5, 90, "five_out_of_ninety.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(5, 90));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithQuantityAndPoolSizeWithGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(5, 90, GeneratorType.DEFAULT, "five_out_of_ninety.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.DEFAULT.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(5, 90, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }

    @Test
    void testWithQuantityAndPoolSizeWithGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(5, 90, GeneratorType.EXPERIMENTAL, "five_out_of_ninety.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        String expectedGeneratorTypeHeader = GeneratorType.EXPERIMENTAL.getValue();
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(5, 90, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        List<?> response = documentContext.read("$", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(expectedGeneratorTypeHeader, mvcResult.getResponse().getHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedResponse, response);
    }
}
