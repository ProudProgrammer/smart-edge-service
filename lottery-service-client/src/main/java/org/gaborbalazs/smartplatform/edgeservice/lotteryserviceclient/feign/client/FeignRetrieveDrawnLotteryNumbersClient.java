package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client;

import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.configuration.LotteryServiceConfiguration;
import org.gaborbalazs.smartplatform.lotteryservice.client.api.RetrieveDrawnLotteryNumbersApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "retrieveDrawnLotteryNumbersClient", url = "${lottery.service.base.url}", configuration = LotteryServiceConfiguration.class)
public interface FeignRetrieveDrawnLotteryNumbersClient extends RetrieveDrawnLotteryNumbersApi {
}
