package org.gaborbalazs.smartplatform.edgeservice.web.controller;

import java.util.SortedSet;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.LotteryNumberRetrieveService;
import org.gaborbalazs.smartplatform.edgeservice.web.api.LotteryNumberRetrieveApi;
import org.gaborbalazs.smartplatform.edgeservice.web.api.LotteryNumberRetrieveSwaggerApi;
import org.gaborbalazs.smartplatform.edgeservice.web.editor.GeneratorTypeEditor;
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
    public SortedSet<Integer> retrieve(LotteryType lotteryType, GeneratorType generatorType) {
        return lotteryNumberRetrieveService.retrieve(lotteryType, generatorType);
    }

    @Override
    public SortedSet<Integer> retrieve(int quantity, int poolSize, GeneratorType generatorType) {
        return lotteryNumberRetrieveService.retrieve(quantity, poolSize, generatorType);
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LotteryType.class, new LotteryTypeEditor());
        webDataBinder.registerCustomEditor(GeneratorType.class, new GeneratorTypeEditor());
    }
}
