package org.gaborbalazs.smartplatform.edgeservice.web.configuration;

import org.apache.commons.lang3.StringUtils;
import org.gaborbalazs.smartplatform.edgeservice.service.context.RequestContext;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.UUID;

/**
 * {@link RequestContext} configuration.
 * When RequestId header is blank UUID.randomUUID().toString() is used.
 * When Locale header is blank Locale.getDefault() is used.
 */
@Configuration
class RequestContextConfiguration {

    private static final String CONSUMER_NAME = "edge-service";

    private final HttpServletRequest httpServletRequest;
    private final Logger logger;

    RequestContextConfiguration(HttpServletRequest httpServletRequest, Logger logger) {
        this.httpServletRequest = httpServletRequest;
        this.logger = logger;
    }

    @Bean
    @RequestScope
    RequestContext requestContext() {
        String consumerName = getConsumerName();
        String requestId = getRequestId();
        Locale locale = getLocal();
        return RequestContext.newBuilder()
                .withConsumerName(consumerName)
                .withRequestId(requestId)
                .withRequestURI(httpServletRequest.getRequestURI())
                .withRequestQuery(httpServletRequest.getQueryString())
                .withLocale(locale)
                .build();
    }

    private String getRequestId() {
        String requestIdHeader = httpServletRequest.getHeader(HeaderParameterName.REQUEST_ID.getHeaderName());
        String requestId;
        if (StringUtils.isBlank(requestIdHeader)) {
            requestId = UUID.randomUUID().toString();
            logger.debug("Request-Id header is blank. Request id has been generated: " + requestId);
        } else {
            requestId = requestIdHeader;
            logger.debug("Request-Id header is specified. Incoming request id: " + requestId);
        }
        return requestId;
    }

    private String getConsumerName() {
        String consumerNameHeader = httpServletRequest.getHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName());
        String consumerName;
        if (StringUtils.isBlank(consumerNameHeader)) {
            consumerName = CONSUMER_NAME;
            logger.debug("Consumer-Name header is blank. Consumer will be: " + CONSUMER_NAME);
        } else {
            consumerName = consumerNameHeader;
            logger.debug("Consumer-Name header is specified. Incoming consumer name: " + consumerNameHeader);
        }
        return consumerName;
    }

    private Locale getLocal() {
        String localeAsString = httpServletRequest.getHeader(HeaderParameterName.LOCALE.getHeaderName());
        Locale locale;
        if (StringUtils.isNotBlank(localeAsString)) {
            String[] localeParts = localeAsString.split("[-_]");
            Locale.Builder localeBuilder = new Locale.Builder().setLanguage(localeParts[0]);
            if (localeParts.length > 1) {
                localeBuilder.setRegion(localeParts[1]);
            }
            locale = localeBuilder.build();
            logger.debug("Locale header is specified. Incoming locale: " + locale.toString());
        } else {
            locale = Locale.getDefault();
            logger.debug("Locale header is blank. Default locale will be used: " + locale.toString());
        }
        return locale;
    }
}
