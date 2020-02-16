package org.gaborbalazs.smartplatform.edgeservice.web.exception;

import org.gaborbalazs.smartplatform.edgeservice.service.context.RequestContext;
import org.gaborbalazs.smartplatform.edgeservice.service.retrieve.exception.LotteryNumberGeneratorClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import springfox.documentation.swagger.readers.parameter.SwaggerExpandedParameterBuilder;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@RestControllerAdvice(basePackages = {"org.gaborbalazs.smartplatform.edgeservice"})
class RestResponseEntityExceptionHandler {

    private final RequestContext requestContext;

    RestResponseEntityExceptionHandler(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    ExceptionResponse handleIllegalArgumentException(Exception exception, WebRequest request) {
        return createExceptionResponse(exception, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(UnsupportedOperationException.class)
    ExceptionResponse handleUnsupportedOperationException(Exception exception, WebRequest request) {
        return createExceptionResponse(exception, HttpStatus.NOT_IMPLEMENTED);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(LotteryNumberGeneratorClientException.class)
    ExceptionResponse handleLotteryNumberGeneratorClientException(Exception exception, WebRequest request) {
        return createExceptionResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ExceptionResponse createExceptionResponse(Exception exception, HttpStatus httpStatus) {
        return ExceptionResponse.newBuilder()
                .withTimestamp(ZonedDateTime.now())
                .withStatus(httpStatus.value())
                .withError(httpStatus.getReasonPhrase())
                .withMessage(exception.getMessage())
                .withPath(requestContext.getRequestURI())
                .withQuery(requestContext.getRequestQuery())
                .build();
    }
}
