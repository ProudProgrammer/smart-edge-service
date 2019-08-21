package org.gaborbalazs.smartplatform.edgeservice.service.retrieve;

import java.util.Collections;
import java.util.Set;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.stereotype.Service;

@Service
public class LotteryNumberRetrieveService {

    public Set<Integer> retrieveRandom(LotteryType lotteryType) {
        return Collections.emptySet();
    }
}
