package org.gaborbalazs.smartplatform.edgeservice.web.controller;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.DrawnNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.iface.RetrieveLotteryNumberService;
import org.gaborbalazs.smartplatform.edgeservice.web.api.RetrieveLotteryNumberApi;
import org.gaborbalazs.smartplatform.edgeservice.web.api.RetrieveLotteryNumberSwaggerApi;
import org.gaborbalazs.smartplatform.edgeservice.web.editor.GeneratorTypeEditor;
import org.gaborbalazs.smartplatform.edgeservice.web.editor.LotteryTypeEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
class RetrieveLotteryNumberController implements RetrieveLotteryNumberApi, RetrieveLotteryNumberSwaggerApi {

    private final RetrieveLotteryNumberService defaultRetrieveLotteryNumberService;

    RetrieveLotteryNumberController(RetrieveLotteryNumberService defaultRetrieveLotteryNumberService) {
        this.defaultRetrieveLotteryNumberService = defaultRetrieveLotteryNumberService;
    }

    @Override
    public DrawnNumbers retrieve(LotteryType lotteryType, GeneratorType generatorType) {
        return defaultRetrieveLotteryNumberService.retrieve(lotteryType, generatorType);
    }

    @Override
    public DrawnNumbers retrieve(int quantity, int poolSize, GeneratorType generatorType) {
        return defaultRetrieveLotteryNumberService.retrieve(quantity, poolSize, generatorType);
    }

    @Override
    public List<? extends Draw> retrieve(LotteryType lotteryType) {
        return null;
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LotteryType.class, new LotteryTypeEditor());
        webDataBinder.registerCustomEditor(GeneratorType.class, new GeneratorTypeEditor());
    }
}
