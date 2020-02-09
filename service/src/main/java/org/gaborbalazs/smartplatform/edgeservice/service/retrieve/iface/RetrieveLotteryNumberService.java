package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

import java.util.SortedSet;

/**
 * Interface for retrieving lottery numbers.
 */
public interface RetrieveLotteryNumberService {

    SortedSet<Integer> retrieve(LotteryType lotteryType, GeneratorType generatorType);

    SortedSet<Integer> retrieve(int quantity, int poolSize, GeneratorType generatorType);
}
