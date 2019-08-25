package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.contract;

import java.util.Collections;
import java.util.List;

import org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import feign.Contract;
import feign.MethodMetadata;

public class LotteryTypeContract implements Contract {

    private Contract contract;

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
            public String convert(LotteryType lotteryType) {
                return lotteryType.getPathVariableName();
            }
        };
    }
}
