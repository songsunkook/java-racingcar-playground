package exception;

import constant.ExceptionMessages;

public class UnderMaximumException extends RuntimeException {
    public UnderMaximumException() {
        super(ExceptionMessages.OVER_MAXIMUM.getMessage());
    }
}
