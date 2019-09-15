package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.configuration;

import java.util.UUID;

import org.gaborbalazs.smartplatform.edgeservice.common.context.RequestContext;
import org.gaborbalazs.smartplatform.edgeservice.common.enums.HeaderParameterName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import feign.RequestInterceptor;

@Configuration
class InterceptorConfiguration {

    private static final String CONSUMER_NAME = "edge-service";

    @Autowired
    private RequestContext requestContext;

    @Bean
    RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HeaderParameterName.CONSUMER_NAME.getHeaderName(), CONSUMER_NAME);
            requestTemplate.header(HeaderParameterName.REQUEST_ID.getHeaderName(), getRequestId());
        };
    }

    private String getRequestId() {
        return StringUtils.isEmpty(requestContext.getRequestId()) ? UUID.randomUUID().toString() : requestContext.getRequestId();
    }
}
