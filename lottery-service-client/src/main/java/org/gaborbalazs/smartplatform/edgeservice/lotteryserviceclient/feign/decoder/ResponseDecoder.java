package org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.decoder;

import com.google.gson.GsonBuilder;
import feign.Response;
import feign.gson.GsonDecoder;
import org.gaborbalazs.smartplatform.edgeservice.lotteryserviceclient.feign.component.ResponseHeaderSetter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
class ResponseDecoder extends GsonDecoder {

    private final ResponseHeaderSetter responseHeaderSetter;

    ResponseDecoder(ResponseHeaderSetter responseHeaderSetter) {
        super(new GsonBuilder().serializeNulls().create());
        this.responseHeaderSetter = responseHeaderSetter;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException {
        responseHeaderSetter.setResponseHeaders(response);
        return super.decode(response, type);
    }
}
