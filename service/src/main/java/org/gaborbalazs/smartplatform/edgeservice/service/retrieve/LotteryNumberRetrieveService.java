package org.gaborbalazs.smartplatform.edgeservice.service.retrieve;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client.LotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.edgeservice.service.converter.LotteryTypeConverter;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.stereotype.Service;

@Service
public class LotteryNumberRetrieveService {

    private LotteryNumberGeneratorClient lotteryNumberGeneratorClient;
    private LotteryTypeConverter lotteryTypeConverter;

    LotteryNumberRetrieveService(LotteryNumberGeneratorClient lotteryNumberGeneratorClient, LotteryTypeConverter lotteryTypeConverter) {
        this.lotteryNumberGeneratorClient = lotteryNumberGeneratorClient;
        this.lotteryTypeConverter = lotteryTypeConverter;
    }

    public SortedSet<Integer> retrieveRandom(LotteryType lotteryType) {
        return lotteryNumberGeneratorClient.generateRandom(convertLotteryType(lotteryType));
    }

    private org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType convertLotteryType(LotteryType lotteryType) {
        return lotteryTypeConverter.convert(lotteryType);
    }
}
