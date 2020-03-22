package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.component;

import feign.Response;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ResponseHeaderSetter {

    private static final String UNIDENTIFIED = "unidentified";

    private final HttpServletResponse httpServletResponse;
    private final Logger logger;

    ResponseHeaderSetter(HttpServletResponse httpServletResponse, Logger logger) {
        this.httpServletResponse = httpServletResponse;
        this.logger = logger;
    }

    public void setResponseHeaders(Response response) {
        setConsumerNameHeader(response);
        setRequestIdHeader(response);
        setLocaleHeader(response);
    }

    private void setConsumerNameHeader(Response response) {
        if (response.headers().get(HeaderParameterName.CONSUMER_NAME.getHeaderName()) != null) {
            String consumerNameHeader = String.join(",", response.headers().get(HeaderParameterName.CONSUMER_NAME.getHeaderName()));
            httpServletResponse.addHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName(), consumerNameHeader);
            logger.debug("Consumer-Name header has been set to: " + consumerNameHeader);
        } else {
            httpServletResponse.addHeader(HeaderParameterName.CONSUMER_NAME.getHeaderName(), UNIDENTIFIED);
            logger.debug("Consumer-Name header could not be set.");
        }
    }

    private void setRequestIdHeader(Response response) {
        if (response.headers().get(HeaderParameterName.REQUEST_ID.getHeaderName()) != null) {
            String requestIdHeader = String.join(",", response.headers().get(HeaderParameterName.REQUEST_ID.getHeaderName()));
            httpServletResponse.addHeader(HeaderParameterName.REQUEST_ID.getHeaderName(), requestIdHeader);
            logger.debug("Request-Id header has been set to: " + requestIdHeader);
        } else {
            httpServletResponse.addHeader(HeaderParameterName.REQUEST_ID.getHeaderName(), UNIDENTIFIED);
            logger.debug("Request-Id header could not be set.");
        }
    }

    private void setLocaleHeader(Response response) {
        if (response.headers().get(HeaderParameterName.LOCALE.getHeaderName()) != null) {
            String localeHeader = String.join(",", response.headers().get(HeaderParameterName.LOCALE.getHeaderName()));
            httpServletResponse.addHeader(HeaderParameterName.LOCALE.getHeaderName(), localeHeader);
            logger.debug("Locale header has been set to: " + localeHeader);
        } else {
            httpServletResponse.addHeader(HeaderParameterName.LOCALE.getHeaderName(), UNIDENTIFIED);
            logger.debug("Local header could not be set.");
        }
    }
}
