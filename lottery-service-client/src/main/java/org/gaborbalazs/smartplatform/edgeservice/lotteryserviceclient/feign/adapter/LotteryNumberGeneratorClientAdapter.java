package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.adapter;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client.FeignLotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter.LotteryTypeConverter;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.iface.LotteryNumberGeneratorClient;
import org.springframework.stereotype.Component;

@Component
public class LotteryNumberGeneratorClientAdapter implements LotteryNumberGeneratorClient {

    private final FeignLotteryNumberGeneratorClient feignLotteryNumberGeneratorClient;
    private final LotteryTypeConverter lotteryTypeConverter;

    LotteryNumberGeneratorClientAdapter(FeignLotteryNumberGeneratorClient feignLotteryNumberGeneratorClient, LotteryTypeConverter lotteryTypeConverter) {
        this.feignLotteryNumberGeneratorClient = feignLotteryNumberGeneratorClient;
        this.lotteryTypeConverter = lotteryTypeConverter;
    }

    @Override
    public SortedSet<Integer> generateRandom(LotteryType lotteryType) {
        return feignLotteryNumberGeneratorClient.generateRandom(lotteryTypeConverter.convert(lotteryType));
    }
}
