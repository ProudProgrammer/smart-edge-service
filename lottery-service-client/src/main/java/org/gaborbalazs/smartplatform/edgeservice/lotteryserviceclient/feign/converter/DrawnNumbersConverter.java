package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.lotteryservice.client.domain.DrawnNumbers;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DrawnNumbersConverter implements Converter<DrawnNumbers, org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers> {

    @Override
    public org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers convert(@NonNull DrawnNumbers source) {
        return new org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers(GeneratorType.valueOf(source.getGeneratorType().name()), source.getDrawnNumbers());
    }
}
