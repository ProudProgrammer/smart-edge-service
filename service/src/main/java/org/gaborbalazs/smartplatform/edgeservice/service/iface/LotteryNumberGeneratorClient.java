package org.gaborbalazs.smartplatform.edgeservice.service.iface;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;

public interface LotteryNumberGeneratorClient {

    SortedSet<Integer> generateRandom(LotteryType lotteryType);
}
