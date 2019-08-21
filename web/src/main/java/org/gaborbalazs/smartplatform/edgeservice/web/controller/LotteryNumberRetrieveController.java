package org.gaborbalazs.smartplatform.edgeservice.web.controller;

import java.util.Collections;
import java.util.Set;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.LotteryNumberRetrieveService;
import org.gaborbalazs.smartplatform.edgeservice.web.api.LotteryNumberRetrieveApi;
import org.gaborbalazs.smartplatform.edgeservice.web.converter.LotteryTypeConverter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LotteryNumberRetrieveController implements LotteryNumberRetrieveApi {

    private LotteryNumberRetrieveService lotteryNumberRetrieveService;

    LotteryNumberRetrieveController(LotteryNumberRetrieveService lotteryNumberRetrieveService) {
        this.lotteryNumberRetrieveService = lotteryNumberRetrieveService;
    }

    public Set<Integer> retrieveRandom(LotteryType lotteryType) {
        return lotteryNumberRetrieveService.retrieveRandom(lotteryType);
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LotteryType.class, new LotteryTypeConverter());
    }
}
