package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve;

import org.gaborbalazs.smartplatform.edgeservice.integrationtest.base.TestBase;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.http.HttpStatus;

import java.util.Map;

class LotteryNumberBaseTest extends TestBase {

    private static final String LOTTERY_SERVICE_RESOURCE_PATH = "lotteryService/";
    protected static Map<String, String> DEFAULT_REQUEST_HEADERS = Map.of(
            HeaderParameterName.REQUEST_ID.getHeaderName(), "test0000-0000-0000-0000-test00000000",
            HeaderParameterName.CONSUMER_NAME.getHeaderName(), "test",
            HeaderParameterName.LOCALE.getHeaderName(), "hu_HU");
    protected static Map<String, String> DEFAULT_RESPONSE_HEADERS = Map.of(
            HeaderParameterName.GENERATOR_TYPE.getHeaderName(), GeneratorType.DEFAULT.getValue(),
            HeaderParameterName.REQUEST_ID.getHeaderName(), "test0000-0000-0000-0000-test00000000",
            HeaderParameterName.CONSUMER_NAME.getHeaderName(), "test",
            HeaderParameterName.LOCALE.getHeaderName(), "hu_HU");
    protected static Map<String, String> EXPERIMENTAL_RESPONSE_HEADERS = Map.of(
            HeaderParameterName.GENERATOR_TYPE.getHeaderName(), GeneratorType.EXPERIMENTAL.getValue(),
            HeaderParameterName.REQUEST_ID.getHeaderName(), "test0000-0000-0000-0000-test00000000",
            HeaderParameterName.CONSUMER_NAME.getHeaderName(), "test",
            HeaderParameterName.LOCALE.getHeaderName(), "hu_HU");

    String getDefaultRequestIdHeader() {
        return DEFAULT_REQUEST_HEADERS.get(HeaderParameterName.REQUEST_ID.getHeaderName());
    }

    String getDefaultConsumerNameHeader() {
        return DEFAULT_REQUEST_HEADERS.get(HeaderParameterName.CONSUMER_NAME.getHeaderName());
    }

    String getDefaultLocaleHeader() {
        return DEFAULT_REQUEST_HEADERS.get(HeaderParameterName.LOCALE.getHeaderName());
    }

    String getEdgeServiceRetrieveLotteryNumberUrl(LotteryType lotteryType) {
        return "/retrieve/lottery/" + lotteryType.getPathVariableName() + "/numbers";
    }

    String getEdgeServiceRetrieveLotteryNumberUrl(int quantity, int poolSize) {
        return "/retrieve/lottery/numbers?quantity=" + quantity + "&poolSize=" + poolSize;
    }

    void setUpLotteryServiceStub(LotteryType lotteryType, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        setUpStub(getUrl(lotteryType), LOTTERY_SERVICE_RESOURCE_PATH + responseFile + ".json", httpStatus, headers);
    }

    void setUpLotteryServiceStub(int quantity, int poolSize, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        setUpStub(getUrl(quantity, poolSize), LOTTERY_SERVICE_RESOURCE_PATH + responseFile + ".json", httpStatus, headers);
    }

    private String getUrl(LotteryType lotteryType) {
        return getUrl(lotteryType, GeneratorType.DEFAULT);
    }

    private String getUrl(LotteryType lotteryType, GeneratorType generatorType) {
        return "/lottery/" + lotteryType.getPathVariableName() + "/numbers?generatorType=" + generatorType.getValue();
    }

    private String getUrl(int quantity, int poolSize) {
        return getUrl(quantity, poolSize, GeneratorType.DEFAULT);
    }

    private String getUrl(int quantity, int poolSize, GeneratorType generatorType) {
        return "/lottery/numbers?quantity=" + quantity + "&poolSize=" + poolSize + "&generatorType=" + generatorType.getValue();
    }
}
