package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.contract;

import java.util.Collections;
import java.util.List;

import org.gaborbalazs.smartplatform.lotteryservice.client.enums.GeneratorType;
import org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import feign.Contract;
import feign.MethodMetadata;

public class LotteryServiceContract implements Contract {

    private final Contract contract;

    public LotteryServiceContract() {
        contract = new SpringMvcContract(Collections.emptyList(), createConversionService());
    }

    @Override
    public List<MethodMetadata> parseAndValidateMetadata(Class<?> targetType) {
        return contract.parseAndValidateMetadata(targetType);
    }

    private ConversionService createConversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(createLotteryTypeToStringConverter());
        conversionService.addConverter(createGeneratorTypeToStringConverter());
        return conversionService;
    }

    private Converter<LotteryType, String> createLotteryTypeToStringConverter() {
        return new Converter<>() {
            @Override
            public String convert(LotteryType lotteryType) {
                return lotteryType.getValue();
            }
        };
    }

    private Converter<GeneratorType, String> createGeneratorTypeToStringConverter() {
        return new Converter<>() {
            @Override
            public String convert(GeneratorType generatorType) {
                return generatorType.getValue();
            }
        };
    }
}
