package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.configuration;

import feign.Contract;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.component.ResponseHeaderSetter;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.contract.LotteryServiceContract;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.decoder.ResponseDecoder;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.decoder.ResponseErrorDecoder;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LotteryServiceConfiguration {

    @Bean
    Contract lotteryServiceContract() {
        return new LotteryServiceContract();
    }

    @Bean
    ResponseDecoder responseDecoder(ResponseHeaderSetter responseHeaderSetter) {
        return new ResponseDecoder(responseHeaderSetter);
    }

    @Bean
    ResponseErrorDecoder responseErrorDecoder(ResponseHeaderSetter responseHeaderSetter, Logger logger) {
        return new ResponseErrorDecoder(responseHeaderSetter, logger);
    }
}
