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
    private static final String FILE_EXTENSION = ".json";

    @Autowired
    private WireMockService wireMockService;

    public void setUp(LotteryType lotteryType, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        wireMockService.setUpStub(getUrl(lotteryType), LOTTERY_SERVICE_RESOURCE_PATH + responseFile + FILE_EXTENSION, httpStatus, headers);
    }

    public void setUp(int quantity, int poolSize, String responseFile, HttpStatus httpStatus, Map<String, String> headers) {
        wireMockService.setUpStub(getUrl(quantity, poolSize), LOTTERY_SERVICE_RESOURCE_PATH + responseFile + FILE_EXTENSION, httpStatus, headers);
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
