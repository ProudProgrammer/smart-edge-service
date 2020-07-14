package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

import java.util.List;

public interface LotteryNumberGeneratorClient {

    GeneratedNumbers generate(LotteryType lotteryType, GeneratorType generatorType);

    GeneratedNumbers generate(int quantity, int poolSize, GeneratorType generatorType);

    List<Draw> retrieve(LotteryType lotteryType);
}
