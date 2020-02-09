package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.exception;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.exception.LotteryNumberGeneratorClientException;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

@Component
public class LotteryServiceErrorDecoder implements ErrorDecoder {

    private Logger logger;

    LotteryServiceErrorDecoder(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception;
        if (response.status() == 400) {
            try {
                exception = getException(response, IllegalArgumentException.class);
            } catch (Exception e) {
                exception = getLotteryNumberGeneratorClientException(e);
            }
        } else if (response.status() == 501) {
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

    private Exception getException(Response response, Class<? extends Exception> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        InputStream responseBodyAsInputStream = response.body().asInputStream();
        String responseBodyAsString = IOUtils.toString(responseBodyAsInputStream, Charset.defaultCharset().name());
        return clazz.getConstructor(String.class).newInstance(responseBodyAsString);
    }

    private LotteryNumberGeneratorClientException getLotteryNumberGeneratorClientException(Exception exception) {
        String msg = "Cannot parse Lottery Service response body: " + exception.getMessage() + ".";
        logger.error(msg, exception);
        return new LotteryNumberGeneratorClientException(msg);
    }
}
