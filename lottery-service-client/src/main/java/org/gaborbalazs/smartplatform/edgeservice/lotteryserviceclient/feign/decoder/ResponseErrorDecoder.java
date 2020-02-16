package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.decoder;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.component.ResponseHeaderSetter;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.exception.LotteryNumberGeneratorClientException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

@Component
class ResponseErrorDecoder implements ErrorDecoder {

    private ResponseHeaderSetter responseHeaderSetter;
    private Logger logger;

    ResponseErrorDecoder(ResponseHeaderSetter responseHeaderSetter, Logger logger) {
        this.responseHeaderSetter = responseHeaderSetter;
        this.logger = logger;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        responseHeaderSetter.setResponseHeaders(response);
        Exception exception;
        if (response.status() == HttpStatus.BAD_REQUEST.value()) {
            try {
                exception = getException(response, IllegalArgumentException.class);
            } catch (Exception e) {
                exception = getLotteryNumberGeneratorClientException(e);
            }
        } else if (response.status() == HttpStatus.NOT_IMPLEMENTED.value()) {
            try {
                exception = getException(response, UnsupportedOperationException.class);
            } catch (Exception e) {
                exception = getLotteryNumberGeneratorClientException(e);
            }
        } else {
            exception = FeignException.errorStatus(methodKey, response);
        }
        return exception;
    }

    private <T extends Exception> Exception getException(Response response, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        InputStream responseBodyAsInputStream = response.body().asInputStream();
        String responseBodyAsString = IOUtils.toString(responseBodyAsInputStream, Charset.defaultCharset().name());
        String responseMessage = extractMessageFromResponseBody(responseBodyAsString);
        return clazz.getConstructor(String.class).newInstance(responseMessage);
    }

    private String extractMessageFromResponseBody(String responseBodyAsString) {
        DocumentContext documentContext = JsonPath
                .using(Configuration
                        .defaultConfiguration()
                        .addOptions(Option.SUPPRESS_EXCEPTIONS)
                        .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL))
                .parse(responseBodyAsString);
        String responseMessage = documentContext.read("$.message", String.class);
        logger.debug("Extract message from Lottery Service response body. Response body: {}. Response message: {}" + responseBodyAsString, responseMessage);
        return responseMessage;
    }

    private LotteryNumberGeneratorClientException getLotteryNumberGeneratorClientException(Exception exception) {
        String msg = "Cannot parse Lottery Service response body: " + exception.getMessage() + ".";
        logger.error(msg, exception);
        return new LotteryNumberGeneratorClientException(msg);
    }
}
