package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.impl;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.LotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.RetrieveLotteryNumberService;
import org.springframework.stereotype.Service;

@Service
public class DefaultRetrieveLotteryNumberService implements RetrieveLotteryNumberService {

    private final LotteryNumberGeneratorClient lotteryNumberGeneratorClient;

    DefaultRetrieveLotteryNumberService(LotteryNumberGeneratorClient lotteryNumberGeneratorClientAdapter) {
        this.lotteryNumberGeneratorClient = lotteryNumberGeneratorClientAdapter;
    }

    public SortedSet<Integer> retrieve(LotteryType lotteryType, GeneratorType generatorType) {
        return lotteryNumberGeneratorClient.generate(lotteryType, generatorType);
    }

    public SortedSet<Integer> retrieve(int quantity, int poolSize, GeneratorType generatorType) {
        return lotteryNumberGeneratorClient.generate(quantity, poolSize, generatorType);
    }
}
