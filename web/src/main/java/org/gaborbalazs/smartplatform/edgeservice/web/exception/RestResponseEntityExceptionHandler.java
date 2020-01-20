package org.gaborbalazs.smartplatform.edgeservice.web.exception;

import org.gaborbalazs.smartplatform.edgeservice.service.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;

@RestControllerAdvice(basePackages = {"org.gaborbalazs.smartplatform.edgeservice"})
class RestResponseEntityExceptionHandler {

    private final RequestContext requestContext;

    RestResponseEntityExceptionHandler(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalArgumentException.class)
    ExceptionResponse handleIllegalArgumentException(Exception exception, WebRequest request) {
        return createExceptionResponse(exception);
    }

    private ExceptionResponse createExceptionResponse(Exception exception) {
        return ExceptionResponse.newBuilder()
                .withTimestamp(ZonedDateTime.now())
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .withMessage(exception.getMessage())
                .withConsumerName(requestContext.getConsumerName())
                .withRequestId(requestContext.getRequestId())
                .withPath(requestContext.getRequestURI())
                .build();
    }
}
