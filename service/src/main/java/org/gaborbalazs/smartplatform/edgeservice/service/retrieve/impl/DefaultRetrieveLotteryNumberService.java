package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.impl;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.LotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.RetrieveLotteryNumberService;
import org.springframework.stereotype.Service;

@Service
public class DefaultRetrieveLotteryNumberService implements RetrieveLotteryNumberService {

    private final LotteryNumberGeneratorClient lotteryNumberGeneratorClient;

    DefaultRetrieveLotteryNumberService(LotteryNumberGeneratorClient lotteryNumberGeneratorClient) {
        this.lotteryNumberGeneratorClient = lotteryNumberGeneratorClient;
    }

    public DrawnNumbers retrieve(LotteryType lotteryType, GeneratorType generatorType) {
        return lotteryNumberGeneratorClient.generate(lotteryType, generatorType);
    }

    public DrawnNumbers retrieve(int quantity, int poolSize, GeneratorType generatorType) {
        return lotteryNumberGeneratorClient.generate(quantity, poolSize, generatorType);
    }
}
