package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.adapter;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client.FeignLotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter.GeneratorTypeConverter;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter.LotteryTypeConverter;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.LotteryNumberGeneratorClient;
import org.springframework.stereotype.Component;

@Component
public class LotteryNumberGeneratorClientAdapter implements LotteryNumberGeneratorClient {

    private final FeignLotteryNumberGeneratorClient feignLotteryNumberGeneratorClient;
    private final LotteryTypeConverter lotteryTypeConverter;
    private final GeneratorTypeConverter generatorTypeConverter;

    LotteryNumberGeneratorClientAdapter(FeignLotteryNumberGeneratorClient feignLotteryNumberGeneratorClient, LotteryTypeConverter lotteryTypeConverter,
            GeneratorTypeConverter generatorTypeConverter) {
        this.feignLotteryNumberGeneratorClient = feignLotteryNumberGeneratorClient;
        this.lotteryTypeConverter = lotteryTypeConverter;
        this.generatorTypeConverter = generatorTypeConverter;
    }

    @Override
    public SortedSet<Integer> generate(LotteryType lotteryType, GeneratorType generatorType) {
        return feignLotteryNumberGeneratorClient.generate(lotteryTypeConverter.convert(lotteryType), generatorTypeConverter.convert(generatorType));
    }

    @Override
    public SortedSet<Integer> generate(int quantity, int poolSize, GeneratorType generatorType) {
        return feignLotteryNumberGeneratorClient.generate(quantity, poolSize, generatorTypeConverter.convert(generatorType));
    }
}
