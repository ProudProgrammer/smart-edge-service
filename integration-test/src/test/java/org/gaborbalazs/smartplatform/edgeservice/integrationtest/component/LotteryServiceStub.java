package org.gaborbalazs.smartplatform.edgeservice.integrationtest.component;

import java.util.Map;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class LotteryServiceStub {

    private static final String LOTTERY_SERVICE_RESOURCE_PATH = "lotteryService/";

    @Autowired
    private WireMockService wireMockService;

    public void setUp(LotteryType lotteryType, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        setUp(lotteryType, GeneratorType.DEFAULT, responseFile, httpStatus, headers);
    }

    public void setUp(LotteryType lotteryType, GeneratorType generatorType, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        wireMockService.setUpStub(getUrl(lotteryType.getPathVariableName(), generatorType.getValue()), LOTTERY_SERVICE_RESOURCE_PATH + responseFile, httpStatus, headers);
    }

    public void setUp(int quantity, int poolSize, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        setUp(quantity, poolSize, GeneratorType.DEFAULT, responseFile, httpStatus, headers);
    }

    public void setUp(int quantity, int poolSize, GeneratorType generatorType, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        wireMockService.setUpStub(getUrl(quantity, poolSize, generatorType), LOTTERY_SERVICE_RESOURCE_PATH + responseFile, httpStatus, headers);
    }

    public void setUp(String lotteryType, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        setUp(lotteryType, GeneratorType.DEFAULT.getValue(), responseFile, httpStatus, headers);
    }

    public void setUp(String lotteryType, String generatorType, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        wireMockService.setUpStub(getUrl(lotteryType, generatorType), LOTTERY_SERVICE_RESOURCE_PATH + responseFile, httpStatus, headers);
    }

    private String getUrl(String lotteryType, String generatorType) {
        return "/lottery/" + lotteryType + "/numbers?generatorType=" + generatorType;
    }

    private String getUrl(int quantity, int poolSize, GeneratorType generatorType) {
        return "/lottery/numbers?quantity=" + quantity + "&poolSize=" + poolSize + "&generatorType=" + generatorType.getValue();
    }
}
