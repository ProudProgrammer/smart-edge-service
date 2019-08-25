package org.gaborbalazs.smartplatform.edgeservice.web.api;

import java.util.Set;

import org.gaborbalazs.smartplatform.lotteryservice.client.enums.LotteryType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/retrieve/lottery")
public interface LotteryNumberRetrieveApi {

    @RequestMapping(value = "/{lotteryType}/numbers/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Integer> retrieveRandom(@PathVariable("lotteryType") LotteryType lotteryType);
}
