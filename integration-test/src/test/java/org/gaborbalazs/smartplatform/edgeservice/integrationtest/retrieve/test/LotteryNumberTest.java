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
        lotteryServiceStub.setUp(LotteryType.FIVE_OUT_OF_NINETY, "five_out_of_ninety_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.FIVE_OUT_OF_NINETY));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfFiveOutOfNinetyWitGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.DEFAULT, "five_out_of_ninety_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfFiveOutOfNinetyWitGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.EXPERIMENTAL, "five_out_of_ninety_experimental.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.EXPERIMENTAL;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.FIVE_OUT_OF_NINETY, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfSixOutOfFortyFiveWithoutGeneratorType() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SIX_OUT_OF_FORTY_FIVE, "six_out_of_forty_five_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SIX_OUT_OF_FORTY_FIVE));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfSixOutOfFortyFiveWithGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.DEFAULT, "six_out_of_forty_five_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfSixOutOfFortyFiveWithGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.EXPERIMENTAL, "six_out_of_forty_five_experimental.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.EXPERIMENTAL;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SIX_OUT_OF_FORTY_FIVE, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfScandinavianWithoutGeneratorType() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SCANDINAVIAN, "scandinavian_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SCANDINAVIAN));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfScandinavianWitGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SCANDINAVIAN, GeneratorType.DEFAULT, "scandinavian_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SCANDINAVIAN, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithLotteryTypeOfScandinavianWitGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(LotteryType.SCANDINAVIAN, GeneratorType.EXPERIMENTAL, "scandinavian_experimental.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.EXPERIMENTAL;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5, 6, 7);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(LotteryType.SCANDINAVIAN, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithQuantityAndPoolSizeWithoutGeneratorType() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(5, 90, "five_out_of_ninety_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(5, 90));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithQuantityAndPoolSizeWithGeneratorTypeDefault() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(5, 90, GeneratorType.DEFAULT, "five_out_of_ninety_default.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.DEFAULT;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(5, 90, GeneratorType.DEFAULT));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }

    @Test
    void testWithQuantityAndPoolSizeWithGeneratorTypeExperimental() throws Exception {
        // GIVEN
        lotteryServiceStub.setUp(5, 90, GeneratorType.EXPERIMENTAL, "five_out_of_ninety_experimental.json", HttpStatus.OK, lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());
        GeneratorType expectedGeneratorType = GeneratorType.EXPERIMENTAL;
        List<Integer> expectedResponse = List.of(1, 2, 3, 4, 5);

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(5, 90, GeneratorType.EXPERIMENTAL));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        GeneratorType generatorTypeResponse = GeneratorType.valueOf(documentContext.read("$.generatorType", String.class));
        List<?> drawnNumbersResponse = documentContext.read("$.drawnNumbers", List.class);

        // THEN
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertEquals(expectedGeneratorType, generatorTypeResponse);
        assertEquals(expectedResponse, drawnNumbersResponse);
    }
}
