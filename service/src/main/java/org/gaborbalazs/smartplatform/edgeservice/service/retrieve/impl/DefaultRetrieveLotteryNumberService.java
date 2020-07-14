package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.impl;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.LotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.RetrieveLotteryNumberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultRetrieveLotteryNumberService implements RetrieveLotteryNumberService {

    private final LotteryNumberGeneratorClient lotteryNumberGeneratorClient;

    DefaultRetrieveLotteryNumberService(LotteryNumberGeneratorClient lotteryNumberGeneratorClient) {
        this.lotteryNumberGeneratorClient = lotteryNumberGeneratorClient;
    }

    @Override
    public GeneratedNumbers retrieveGenerated(LotteryType lotteryType, GeneratorType generatorType) {
        return lotteryNumberGeneratorClient.generate(lotteryType, generatorType);
    }

    @Override
    public GeneratedNumbers retrieveGenerated(int quantity, int poolSize, GeneratorType generatorType) {
        return lotteryNumberGeneratorClient.generate(quantity, poolSize, generatorType);
    }

    @Override
    public List<Draw> retrieveDrawn(LotteryType lotteryType) {
        return lotteryNumberGeneratorClient.retrieve(lotteryType);
    }
}
