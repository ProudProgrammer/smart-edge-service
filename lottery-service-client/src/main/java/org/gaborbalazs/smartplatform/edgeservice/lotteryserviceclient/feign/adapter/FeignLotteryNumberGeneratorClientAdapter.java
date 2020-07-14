package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.adapter;

import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client.FeignLotteryNumberGeneratorClient;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client.FeignRetrieveDrawnLotteryNumbersClient;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter.GeneratedNumbersConverter;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter.GeneratorTypeConverter;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter.LotteryTypeConverter;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.LotteryNumberGeneratorClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignLotteryNumberGeneratorClientAdapter implements LotteryNumberGeneratorClient {

    private final FeignLotteryNumberGeneratorClient feignLotteryNumberGeneratorClient;
    private final FeignRetrieveDrawnLotteryNumbersClient feignRetrieveDrawnLotteryNumbersClient;
    private final LotteryTypeConverter lotteryTypeConverter;
    private final GeneratorTypeConverter generatorTypeConverter;
    private final GeneratedNumbersConverter generatedNumbersConverter;

    FeignLotteryNumberGeneratorClientAdapter(FeignLotteryNumberGeneratorClient feignLotteryNumberGeneratorClient, FeignRetrieveDrawnLotteryNumbersClient feignRetrieveDrawnLotteryNumbersClient,
                                             LotteryTypeConverter lotteryTypeConverter, GeneratorTypeConverter generatorTypeConverter, GeneratedNumbersConverter generatedNumbersConverter) {
        this.feignLotteryNumberGeneratorClient = feignLotteryNumberGeneratorClient;
        this.feignRetrieveDrawnLotteryNumbersClient = feignRetrieveDrawnLotteryNumbersClient;
        this.lotteryTypeConverter = lotteryTypeConverter;
        this.generatorTypeConverter = generatorTypeConverter;
        this.generatedNumbersConverter = generatedNumbersConverter;
    }

    @Override
    public GeneratedNumbers generate(LotteryType lotteryType, GeneratorType generatorType) {
        return generatedNumbersConverter.convert(feignLotteryNumberGeneratorClient.generate(lotteryTypeConverter.convert(lotteryType), generatorTypeConverter.convert(generatorType)));
    }

    @Override
    public GeneratedNumbers generate(int quantity, int poolSize, GeneratorType generatorType) {
        return generatedNumbersConverter.convert(feignLotteryNumberGeneratorClient.generate(quantity, poolSize, generatorTypeConverter.convert(generatorType)));
    }

    @Override
    public List<Draw> retrieve(LotteryType lotteryType) {
        return null;
    }
}
