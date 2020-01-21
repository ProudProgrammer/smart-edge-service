package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class GeneratorTypeConverter implements Converter<GeneratorType, org.gaborbalazs.smartplatform.lotteryservice.client.enums.GeneratorType> {

    @Override
    public org.gaborbalazs.smartplatform.lotteryservice.client.enums.GeneratorType convert(@NonNull GeneratorType generatorTypeSource) {
        return org.gaborbalazs.smartplatform.lotteryservice.client.enums.GeneratorType.valueOf(generatorTypeSource.name());
    }
}
