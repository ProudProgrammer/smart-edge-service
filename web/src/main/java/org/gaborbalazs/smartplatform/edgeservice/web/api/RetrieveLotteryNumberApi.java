package org.gaborbalazs.smartplatform.edgeservice.web.api;

import org.gaborbalazs.smartplatform.edgeservice.service.domain.Draw;
import org.gaborbalazs.smartplatform.edgeservice.service.domain.GeneratedNumbers;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/retrieve/lottery")
public interface RetrieveLotteryNumberApi {

    @RequestMapping(value = "/{lotteryType}/numbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    GeneratedNumbers retrieveGenerated(@PathVariable("lotteryType") LotteryType lotteryType, @RequestParam(defaultValue = "default") GeneratorType generatorType);

    @RequestMapping(value = "/numbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    GeneratedNumbers retrieveGenerated(@RequestParam int quantity, @RequestParam int poolSize, @RequestParam(defaultValue = "default") GeneratorType generatorType);

    @RequestMapping(value = "/{lotteryType}/drawnNumbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Draw> retrieveDrawn(@PathVariable("lotteryType") LotteryType lotteryType);
}
