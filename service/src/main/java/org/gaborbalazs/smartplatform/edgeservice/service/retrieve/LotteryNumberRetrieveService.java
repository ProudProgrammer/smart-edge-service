package org.gaborbalazs.smartplatform.edgeservice.service.retrieve;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client.LotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType;
import org.springframework.stereotype.Service;

@Service
public class LotteryNumberRetrieveService {

    private LotteryNumberGeneratorClient lotteryNumberGeneratorClient;

    LotteryNumberRetrieveService(LotteryNumberGeneratorClient lotteryNumberGeneratorClient) {
        this.lotteryNumberGeneratorClient = lotteryNumberGeneratorClient;
    }

    public SortedSet<Integer> retrieveRandom(LotteryType lotteryType) {
        return lotteryNumberGeneratorClient.generateRandom(lotteryType);
    }
}
