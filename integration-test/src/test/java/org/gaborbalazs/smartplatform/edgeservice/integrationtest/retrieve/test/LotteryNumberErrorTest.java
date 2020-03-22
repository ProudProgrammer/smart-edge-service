package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve.test;

import com.jayway.jsonpath.DocumentContext;
import org.apache.commons.lang3.StringUtils;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LotteryNumberErrorTest extends LotteryNumberBaseTest {

    @Test
    void testShouldRespond501WhenLotteryTypeAndGeneratorTypeTogetherUnsupported() throws Exception {
        // GIVEN
        HttpStatus expectedHttpStatus = HttpStatus.NOT_IMPLEMENTED;
        LotteryType expectedLotteryType = LotteryType.SCANDINAVIAN;
        GeneratorType expectedGeneratorTye = GeneratorType.EXPERIMENTAL;
        lotteryServiceStub.setUp(expectedLotteryType, expectedGeneratorTye, "not_implemented_501.json", expectedHttpStatus,
                lotteryNumberHeaderFactory.getLotteryServiceExperimentalGeneratorResponseHeaders());

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(expectedLotteryType, expectedGeneratorTye));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        String responseTime = documentContext.read("$.timestamp", String.class);
        String responseStatus = documentContext.read("$.status", String.class);
        String responseError = documentContext.read("$.error", String.class);
        String responseMessage = documentContext.read("$.message", String.class);
        String responsePath = documentContext.read("$.path", String.class);
        String responseQuery = documentContext.read("$.query", String.class);

        // THEN
        assertEquals(expectedHttpStatus.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertNotNull(ZonedDateTime.parse(responseTime));
        assertEquals(Integer.toString(expectedHttpStatus.value()), responseStatus);
        assertEquals(expectedHttpStatus.getReasonPhrase(), responseError);
        assertTrue(StringUtils.isNotBlank(responseMessage));
        assertEquals("/retrieve/lottery/" + expectedLotteryType.getPathVariableName() + "/numbers", responsePath);
        assertEquals("generatorType=" + expectedGeneratorTye.getValue(), responseQuery);
    }

    @Test
    void testShouldRespond400WhenPoolSizeLargerThan1000() throws Exception {
        // GIVEN
        int quantity = 6;
        int poolSize = 1001;
        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        lotteryServiceStub.setUp(quantity, poolSize, "pool_size_bad_request_400.json", expectedHttpStatus, lotteryNumberHeaderFactory.getLotteryServiceDefaultGeneratorResponseHeaders());

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(quantity, poolSize));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        String responseTime = documentContext.read("$.timestamp", String.class);
        String responseStatus = documentContext.read("$.status", String.class);
        String responseError = documentContext.read("$.error", String.class);
        String responseMessage = documentContext.read("$.message", String.class);
        String responsePath = documentContext.read("$.path", String.class);
        String responseQuery = documentContext.read("$.query", String.class);

        // THEN
        assertEquals(expectedHttpStatus.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertNotNull(ZonedDateTime.parse(responseTime));
        assertEquals(Integer.toString(expectedHttpStatus.value()), responseStatus);
        assertEquals(expectedHttpStatus.getReasonPhrase(), responseError);
        assertTrue(StringUtils.isNotBlank(responseMessage));
        assertEquals("/retrieve/lottery/numbers", responsePath);
        assertEquals("quantity=" + quantity + "&poolSize=" + poolSize, responseQuery);
    }

    @Test
    void testShouldRespond400WhenLotteryTypePathWrong() throws Exception {
        // GIVEN
        String wrongLotteryType = "wrong_lottery_type";
        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;

        // WHEN
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(lotteryNumberUrlFactory.create(wrongLotteryType));
        lotteryNumberHeaderFactory.getDefaultRequestHeaders().forEach(requestBuilder::header);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        DocumentContext documentContext = documentContextFactory.create(mvcResult);
        String responseTime = documentContext.read("$.timestamp", String.class);
        String responseStatus = documentContext.read("$.status", String.class);
        String responseError = documentContext.read("$.error", String.class);
        String responseMessage = documentContext.read("$.message", String.class);
        String responsePath = documentContext.read("$.path", String.class);
        String responseQuery = documentContext.read("$.query", String.class);

        // THEN
        assertEquals(expectedHttpStatus.value(), mvcResult.getResponse().getStatus());
        assertEquals(lotteryNumberHeaderFactory.getDefaultRequestIdHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.REQUEST_ID.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultConsumerNameHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
        assertEquals(lotteryNumberHeaderFactory.getDefaultLocaleHeader(), mvcResult.getResponse().getHeader(HeaderParameterName.LOCALE.getHeaderName()));
        assertNotNull(ZonedDateTime.parse(responseTime));
        assertEquals(Integer.toString(expectedHttpStatus.value()), responseStatus);
        assertEquals(expectedHttpStatus.getReasonPhrase(), responseError);
        assertTrue(StringUtils.isNotBlank(responseMessage));
        assertEquals("/retrieve/lottery/" + wrongLotteryType + "/numbers", responsePath);
        assertNull(responseQuery);
    }
}
