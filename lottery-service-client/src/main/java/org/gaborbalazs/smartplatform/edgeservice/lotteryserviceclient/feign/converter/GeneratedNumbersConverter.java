package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.lotteryservice.client.domain.GeneratedNumbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class GeneratedNumbersConverter implements Converter<GeneratedNumbers, org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers> {

    @Override
    public org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers convert(@NonNull GeneratedNumbers source) {
        return org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers.newGeneratedNumbers()
                .lotteryType(source.getLotteryType())
                .generatorType(GeneratorType.valueOf(source.getGeneratorType().name()))
                .generatedNumbers(source.getGeneratedNumbers())
                .build();
    }
}
