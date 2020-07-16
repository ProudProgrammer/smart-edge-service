package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.decoder;

import feign.Response;
import feign.jackson.JacksonDecoder;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.component.ResponseHeaderSetter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
class ResponseDecoder extends JacksonDecoder {

    private final ResponseHeaderSetter responseHeaderSetter;

    ResponseDecoder(ResponseHeaderSetter responseHeaderSetter) {
        this.responseHeaderSetter = responseHeaderSetter;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException {
        responseHeaderSetter.setResponseHeaders(response);
        return super.decode(response, type);
    }
}
