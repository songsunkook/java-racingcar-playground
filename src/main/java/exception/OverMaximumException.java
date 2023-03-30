package exception;

import constant.ExceptionMessages;

public class OverMaximumException extends RuntimeException {
    public OverMaximumException() {
        super(ExceptionMessages.EXCEPTION_MESSAGES_UNDER_MAXIMUM.getMessage());
    }
}
