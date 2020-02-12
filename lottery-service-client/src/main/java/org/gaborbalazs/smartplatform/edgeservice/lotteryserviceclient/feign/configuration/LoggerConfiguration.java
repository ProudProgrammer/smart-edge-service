package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import feign.Logger;

@Profile("!prod & !integration-test")
@Configuration
class LoggerConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
