package org.gaborbalazs.smartplatform.edgeservice.web.controller;

import java.util.Objects;

import org.gaborbalazs.smartplatform.edgeservice.service.context.RequestContext;
import org.gaborbalazs.smartplatform.edgeservice.service.enums.HeaderParameterName;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = {"org.gaborbalazs.smartplatform.edgeservice"})
public class ResponseHeaderAdvice implements ResponseBodyAdvice<Object> {

    private static final String UNIDENTIFIED = "unidentified";

    private final RequestContext requestContext;

    ResponseHeaderAdvice(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (!response.getHeaders().containsKey(HeaderParameterName.REQUEST_ID.getHeaderName())) {
            response.getHeaders().add(HeaderParameterName.REQUEST_ID.getHeaderName(), Objects.isNull(requestContext.getRequestId()) ? UNIDENTIFIED : requestContext.getRequestId());
        }
        if (!response.getHeaders().containsKey(HeaderParameterName.CONSUMER_NAME.getHeaderName())) {
            response.getHeaders().add(HeaderParameterName.CONSUMER_NAME.getHeaderName(), Objects.isNull(requestContext.getConsumerName()) ? UNIDENTIFIED : requestContext.getConsumerName());
        }
        if (!response.getHeaders().containsKey(HeaderParameterName.LOCALE.getHeaderName())) {
            response.getHeaders().add(HeaderParameterName.LOCALE.getHeaderName(), Objects.isNull(requestContext.getLocale()) ? UNIDENTIFIED : requestContext.getLocale().toString());
        }
        return body;
    }
}
