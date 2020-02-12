package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.component;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import feign.Response;

@Component
public class ResponseHeaderSetter {

    private final HttpServletResponse httpServletResponse;
    private final Logger logger;

    ResponseHeaderSetter(HttpServletResponse httpServletResponse, Logger logger) {
        this.httpServletResponse = httpServletResponse;
        this.logger = logger;
    }

    public void setResponseHeaders(Response response) {
        setLocaleHeader(response);
        setGeneratorTypeHeader(response);
    }

    private void setLocaleHeader(Response response) {
        if (response.headers().get(HeaderParameterName.LOCALE.getHeaderName()) != null) {
            String localeHeader = response.headers().get(HeaderParameterName.LOCALE.getHeaderName()).stream().collect(Collectors.joining(","));
            httpServletResponse.addHeader(HeaderParameterName.LOCALE.getHeaderName(), localeHeader);
            logger.debug("Locale header has been set to: " + localeHeader);
        } else {
            logger.debug("Local header could not be set.");
        }
    }

    private void setGeneratorTypeHeader(Response response) {
        if (response.headers().get(HeaderParameterName.GENERATOR_TYPE.getHeaderName()) != null) {
            String generatorTypeHeader = response.headers().get(HeaderParameterName.GENERATOR_TYPE.getHeaderName()).stream().collect(Collectors.joining(","));
            httpServletResponse.addHeader(HeaderParameterName.GENERATOR_TYPE.getHeaderName(), generatorTypeHeader);
            logger.debug("GeneratorType header has been set to: " + generatorTypeHeader);
        } else {
            logger.debug("GeneratorType header could not be set.");
        }
    }
}
