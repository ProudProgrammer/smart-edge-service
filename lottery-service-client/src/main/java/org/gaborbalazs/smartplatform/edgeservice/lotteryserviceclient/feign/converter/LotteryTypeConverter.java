package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter;

import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class LotteryTypeConverter implements Converter<LotteryType, org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType> {

    @Override
    public org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType convert(@NonNull LotteryType source) {
        return org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType.valueOf(source.name());
    }
}
