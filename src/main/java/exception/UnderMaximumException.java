package exception;

import constant.ExceptionMessages;

public class UnderMaximumException extends RuntimeException {
    public UnderMaximumException() {
        super(ExceptionMessages.EXCEPTION_MESSAGES_OVER_MAXIMUM.getMessage());
    }
}
