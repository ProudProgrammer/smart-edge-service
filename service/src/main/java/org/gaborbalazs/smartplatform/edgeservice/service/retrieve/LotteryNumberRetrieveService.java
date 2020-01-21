package org.gaborbalazs.smartplatform.edgeservice.service.retrieve;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.iface.LotteryNumberGeneratorClient;
import org.springframework.stereotype.Service;

@Service
public class LotteryNumberRetrieveService {

    private final LotteryNumberGeneratorClient lotteryNumberGeneratorClient;

    LotteryNumberRetrieveService(LotteryNumberGeneratorClient lotteryNumberGeneratorClientAdapter) {
        this.lotteryNumberGeneratorClient = lotteryNumberGeneratorClientAdapter;
    }

    public SortedSet<Integer> retrieve(LotteryType lotteryType) {
        return lotteryNumberGeneratorClient.generate(lotteryType);
    }
}
