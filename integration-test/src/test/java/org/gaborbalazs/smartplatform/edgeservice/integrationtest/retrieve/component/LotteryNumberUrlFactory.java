package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve.component;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.stereotype.Component;

@Component
public class LotteryNumberUrlFactory {

    public String create(LotteryType lotteryType) {
        return "/retrieve/lottery/" + lotteryType.getPathVariableName() + "/numbers";
    }

    public String create(LotteryType lotteryType, GeneratorType generatorType) {
        return "/retrieve/lottery/" + lotteryType.getPathVariableName() + "/numbers?generatorType=" + generatorType.getValue();
    }

    public String create(int quantity, int poolSize) {
        return "/retrieve/lottery/numbers?quantity=" + quantity + "&poolSize=" + poolSize;
    }

    public String create(int quantity, int poolSize, GeneratorType generatorType) {
        return "/retrieve/lottery/numbers?quantity=" + quantity + "&poolSize=" + poolSize + "?generatorType=" + generatorType;
    }
}
