package org.gaborbalazs.smartplatform.edgeservice.web.api;

import java.util.Set;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.GeneratorType;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.LotteryType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/retrieve/lottery")
public interface LotteryNumberRetrieveApi {

    @RequestMapping(value = "/{lotteryType}/numbers/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Integer> retrieve(@PathVariable("lotteryType") LotteryType lotteryType, @RequestParam(defaultValue = "default") GeneratorType generatorType);
}
