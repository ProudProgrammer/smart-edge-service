package org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve.test;

import org.gaborbalazs.smartplatform.edgeservice.integrationtest.base.TestBase;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.component.LotteryServiceStub;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve.component.LotteryNumberHeaderFactory;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.retrieve.component.LotteryNumberUrlFactory;
import org.springframework.beans.factory.annotation.Autowired;

class LotteryNumberBaseTest extends TestBase {

    @Autowired
    LotteryNumberHeaderFactory lotteryNumberHeaderFactory;

    @Autowired
    LotteryNumberUrlFactory lotteryNumberUrlFactory;

    @Autowired
    LotteryServiceStub lotteryServiceStub;
}
