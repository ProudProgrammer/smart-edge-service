package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;

import java.util.List;

/**
 * Interface for retrieving lottery numbers.
 */
public interface RetrieveLotteryNumberService {

    GeneratedNumbers retrieveGenerated(LotteryType lotteryType, GeneratorType generatorType);

    GeneratedNumbers retrieveGenerated(int quantity, int poolSize, GeneratorType generatorType);

    List<Draw> retrieveDrawn(LotteryType lotteryType);
}
