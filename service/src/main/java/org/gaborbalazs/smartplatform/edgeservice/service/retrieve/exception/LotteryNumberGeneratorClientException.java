package org.gaborbalazs.smartplatform.edgeservice.service.retrieve.exception;

public class LotteryNumberGeneratorClientException extends RuntimeException {

    public LotteryNumberGeneratorClientException() {
    }

    public LotteryNumberGeneratorClientException(String message) {
        super(message);
    }

    public LotteryNumberGeneratorClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public LotteryNumberGeneratorClientException(Throwable cause) {
        super(cause);
    }
}
