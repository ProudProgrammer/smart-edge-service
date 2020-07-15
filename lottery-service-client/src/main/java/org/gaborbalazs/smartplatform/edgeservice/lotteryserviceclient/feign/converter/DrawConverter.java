package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.converter;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.Hit;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.DrawType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.lotteryservice.client.domain.Draw;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class DrawConverter implements Converter<Draw, org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw> {

    @Override
    public org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw convert(Draw source) {
        return org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw.newDraw()
                .lotteryType(LotteryType.valueOf(source.getLotteryType().name()))
                .year(source.getYear())
                .week(source.getWeek())
                .date(source.getDate())
                .hits(source.getHits().stream().map(hit -> Hit.newHit()
                        .hits(hit.getHits())
                        .tickets(hit.getTickets())
                        .prize(hit.getPrize())
                        .currency(hit.getCurrency())
                        .build()).collect(Collectors.toList()))
                .drawnNumbers(source.getDrawnNumbers().stream().map(drawnNumber -> DrawnNumbers.newDrawnNumbers()
                        .drawType(DrawType.valueOf(drawnNumber.getDrawType().name()))
                        .numbers(new ArrayList<>(drawnNumber.getNumbers()))
                        .build()).collect(Collectors.toList()))
                .build();
    }
}
