package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.client;

import org.gaborbalazs.smartplatform.lotteryservice.client.api.LotteryNumberGeneratorApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "lotteryNumberGeneratorClient", url = "${lottery.service.base.url}")
public interface FeignLotteryNumberGeneratorClient extends LotteryNumberGeneratorApi {
}
