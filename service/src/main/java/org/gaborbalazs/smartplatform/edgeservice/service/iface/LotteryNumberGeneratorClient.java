package org.gaborbalazs.smartplatform.edgeservice.service.iface;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

public interface LotteryNumberGeneratorClient {

    SortedSet<Integer> generate(LotteryType lotteryType, GeneratorType generatorType);

    SortedSet<Integer> generate(int quantity, int poolSize, GeneratorType generatorType);
}
