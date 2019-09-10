package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.configuration;

import java.util.UUID;

import org.gaborbalazs.smartplatform.edgeservice.common.enums.HeaderParameterName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class InterceptorConfiguration {

    private static final String CONSUMER_NAME = "edge-service";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HeaderParameterName.CONSUMER_NAME.getHeaderName(), CONSUMER_NAME);
            requestTemplate.header(HeaderParameterName.REQUEST_ID.getHeaderName(), UUID.randomUUID().toString());
        };
    }
}
