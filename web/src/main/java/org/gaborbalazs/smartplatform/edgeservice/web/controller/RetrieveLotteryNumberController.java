package org.gaborbalazs.smartplatform.edgeservice.web.controller;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.RetrieveLotteryNumberService;
import org.gaborbalazs.smartplatform.edgeservice.web.api.RetrieveLotteryNumberApi;
import org.gaborbalazs.smartplatform.edgeservice.web.api.RetrieveLotteryNumberSwaggerApi;
import org.gaborbalazs.smartplatform.edgeservice.web.editor.GeneratorTypeEditor;
import org.gaborbalazs.smartplatform.edgeservice.web.editor.LotteryTypeEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.util.SortedSet;

@RestController
class RetrieveLotteryNumberController implements RetrieveLotteryNumberApi, RetrieveLotteryNumberSwaggerApi {

    private final RetrieveLotteryNumberService defaultRetrieveLotteryNumberService;

    RetrieveLotteryNumberController(RetrieveLotteryNumberService defaultRetrieveLotteryNumberService) {
        this.defaultRetrieveLotteryNumberService = defaultRetrieveLotteryNumberService;
    }

    @Override
    public SortedSet<Integer> retrieve(LotteryType lotteryType, GeneratorType generatorType) {
        return defaultRetrieveLotteryNumberService.retrieve(lotteryType, generatorType);
    }

    @Override
    public SortedSet<Integer> retrieve(int quantity, int poolSize, GeneratorType generatorType) {
        return defaultRetrieveLotteryNumberService.retrieve(quantity, poolSize, generatorType);
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LotteryType.class, new LotteryTypeEditor());
        webDataBinder.registerCustomEditor(GeneratorType.class, new GeneratorTypeEditor());
    }
}