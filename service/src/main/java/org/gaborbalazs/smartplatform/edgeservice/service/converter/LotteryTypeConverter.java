package org.gaborbalazs.smartplatform.edgeservice.service.converter;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LotteryTypeConverter implements Converter<LotteryType, org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType> {

    @Override
    public org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType convert(LotteryType source) {
        return org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType.valueOf(source.name());
    }
}
