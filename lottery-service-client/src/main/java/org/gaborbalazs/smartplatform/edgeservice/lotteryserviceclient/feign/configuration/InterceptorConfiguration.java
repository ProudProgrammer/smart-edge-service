package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.configuration;

import org.gaborbalazs.smartplatform.edgeservice.service.context.RequestContext;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
class InterceptorConfiguration {

    private static final String CONSUMER_NAME = "edge-service";

    private final RequestContext requestContext;

    InterceptorConfiguration(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Bean
    RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HeaderParameterName.CONSUMER_NAME.getHeaderName(), CONSUMER_NAME);
            requestTemplate.header(HeaderParameterName.REQUEST_ID.getHeaderName(), requestContext.getRequestId());
            requestTemplate.header(HeaderParameterName.LOCALE.getHeaderName(), requestContext.getLocale().toString());
        };
    }
}
