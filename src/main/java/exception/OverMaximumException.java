package exception;

import constant.ExceptionMessages;

public class OverMaximumException extends RuntimeException {
    public OverMaximumException() {
        super(ExceptionMessages.UNDER_MAXIMUM.getMessage());
    }
}
