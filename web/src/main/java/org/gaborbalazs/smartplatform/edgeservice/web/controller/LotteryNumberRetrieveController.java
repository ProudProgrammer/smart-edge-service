package org.gaborbalazs.smartplatform.edgeservice.web.controller;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.LotteryNumberRetrieveService;
import org.gaborbalazs.smartplatform.edgeservice.web.api.LotteryNumberRetrieveApi;
import org.gaborbalazs.smartplatform.edgeservice.web.api.LotteryNumberRetrieveSwaggerApi;
import org.gaborbalazs.smartplatform.edgeservice.web.editor.LotteryTypeEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LotteryNumberRetrieveController implements LotteryNumberRetrieveApi, LotteryNumberRetrieveSwaggerApi {

    private final LotteryNumberRetrieveService lotteryNumberRetrieveService;

    LotteryNumberRetrieveController(LotteryNumberRetrieveService lotteryNumberRetrieveService) {
        this.lotteryNumberRetrieveService = lotteryNumberRetrieveService;
    }

    @Override
    public SortedSet<Integer> retrieveRandom(LotteryType lotteryType) {
        return lotteryNumberRetrieveService.retrieveRandom(lotteryType);
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LotteryType.class, new LotteryTypeEditor());
    }
}
