package org.gaborbalazs.smartplatform.edgeservice.service.retrieve;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.iface.LotteryNumberGeneratorClient;
import org.springframework.stereotype.Service;

@Service
public class LotteryNumberRetrieveService {

    private LotteryNumberGeneratorClient lotteryNumberGeneratorClient;

    LotteryNumberRetrieveService(LotteryNumberGeneratorClient lotteryNumberGeneratorClientAdapter) {
        this.lotteryNumberGeneratorClient = lotteryNumberGeneratorClientAdapter;
    }

    public SortedSet<Integer> retrieveRandom(LotteryType lotteryType) {
        return lotteryNumberGeneratorClient.generateRandom(lotteryType);
    }
}
