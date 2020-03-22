package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

public interface LotteryNumberGeneratorClient {

    DrawnNumbers generate(LotteryType lotteryType, GeneratorType generatorType);

    DrawnNumbers generate(int quantity, int poolSize, GeneratorType generatorType);
}
