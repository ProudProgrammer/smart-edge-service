package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.contract;

import java.util.Collections;
import java.util.List;

import org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.lang.NonNull;

import feign.Contract;
import feign.MethodMetadata;

class LotteryTypeContract implements Contract {

    private final Contract contract;

    LotteryTypeContract() {
        contract = new SpringMvcContract(Collections.emptyList(), createConversionService());
    }

    @Override
    public List<MethodMetadata> parseAndValidatateMetadata(Class<?> targetType) {
        return contract.parseAndValidatateMetadata(targetType);
    }

    private ConversionService createConversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(createLotteryTypeToStringConverter());
        return conversionService;
    }

    private Converter<LotteryType, String> createLotteryTypeToStringConverter() {
        return new Converter<LotteryType, String>() {
            @Override
            public String convert(@NonNull LotteryType lotteryType) {
                return lotteryType.getPathVariableName();
            }
        };
    }
}
