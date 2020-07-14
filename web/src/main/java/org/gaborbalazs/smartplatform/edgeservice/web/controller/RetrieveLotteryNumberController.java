package org.gaborbalazs.smartplatform.edgeservice.web.controller;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers;
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

    private final RetrieveLotteryNumberService retrieveLotteryNumberService;

    RetrieveLotteryNumberController(RetrieveLotteryNumberService retrieveLotteryNumberService) {
        this.retrieveLotteryNumberService = retrieveLotteryNumberService;
    }

    @Override
    public GeneratedNumbers retrieveGenerated(LotteryType lotteryType, GeneratorType generatorType) {
        return retrieveLotteryNumberService.retrieveGenerated(lotteryType, generatorType);
    }

    @Override
    public GeneratedNumbers retrieveGenerated(int quantity, int poolSize, GeneratorType generatorType) {
        return retrieveLotteryNumberService.retrieveGenerated(quantity, poolSize, generatorType);
    }

    @Override
    public List<Draw> retrieveDrawn(LotteryType lotteryType) {
        return retrieveLotteryNumberService.retrieveDrawn(lotteryType);
    }

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LotteryType.class, new LotteryTypeEditor());
        webDataBinder.registerCustomEditor(GeneratorType.class, new GeneratorTypeEditor());
    }
}
