package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve.component;

import java.util.Map;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.springframework.stereotype.Component;

@Component
public class LotteryNumberHeaderFactory {

    private static final Map<String, String> DEFAULT_REQUEST_HEADERS = Map.of(
            HeaderParameterName.REQUEST_ID.getHeaderName(), "test0000-0000-0000-0000-test00000000",
            HeaderParameterName.CONSUMER_NAME.getHeaderName(), "test",
            HeaderParameterName.LOCALE.getHeaderName(), "hu_HU");
    private static final Map<String, String> LOTTERY_SERVICE_DEFAULT_GENERATOR_RESPONSE_HEADERS = Map.of(
            HeaderParameterName.GENERATOR_TYPE.getHeaderName(), GeneratorType.DEFAULT.getValue(),
            HeaderParameterName.REQUEST_ID.getHeaderName(), "test0000-0000-0000-0000-test00000000",
            HeaderParameterName.CONSUMER_NAME.getHeaderName(), "test",
            HeaderParameterName.LOCALE.getHeaderName(), "hu_HU");
    private static final Map<String, String> LOTTERY_SERVICE_EXPERIMENTAL_GENERATOR_RESPONSE_HEADERS = Map.of(
            HeaderParameterName.GENERATOR_TYPE.getHeaderName(), GeneratorType.EXPERIMENTAL.getValue(),
            HeaderParameterName.REQUEST_ID.getHeaderName(), "test0000-0000-0000-0000-test00000000",
            HeaderParameterName.CONSUMER_NAME.getHeaderName(), "test",
            HeaderParameterName.LOCALE.getHeaderName(), "hu_HU");

    public Map<String, String> getDefaultRequestHeaders() {
        return DEFAULT_REQUEST_HEADERS;
    }

    public Map<String, String> getLotteryServiceDefaultGeneratorResponseHeaders() {
        return LOTTERY_SERVICE_DEFAULT_GENERATOR_RESPONSE_HEADERS;
    }

    public Map<String, String> getLotteryServiceExperimentalGeneratorResponseHeaders() {
        return LOTTERY_SERVICE_EXPERIMENTAL_GENERATOR_RESPONSE_HEADERS;
    }

    public String getDefaultRequestIdHeader() {
        return DEFAULT_REQUEST_HEADERS.get(HeaderParameterName.REQUEST_ID.getHeaderName());
    }

    public String getDefaultConsumerNameHeader() {
        return DEFAULT_REQUEST_HEADERS.get(HeaderParameterName.CONSUMER_NAME.getHeaderName());
    }

    public String getDefaultLocaleHeader() {
        return DEFAULT_REQUEST_HEADERS.get(HeaderParameterName.LOCALE.getHeaderName());
    }
}
