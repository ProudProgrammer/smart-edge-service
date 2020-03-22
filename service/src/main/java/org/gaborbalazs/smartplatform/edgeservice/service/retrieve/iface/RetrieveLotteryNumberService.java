package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

/**
 * Interface for retrieving lottery numbers.
 */
public interface RetrieveLotteryNumberService {

    DrawnNumbers retrieve(LotteryType lotteryType, GeneratorType generatorType);

    DrawnNumbers retrieve(int quantity, int poolSize, GeneratorType generatorType);
}
