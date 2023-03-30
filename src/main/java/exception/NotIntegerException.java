package exception;

import constant.ExceptionMessages;

public class NotIntegerException extends RuntimeException {
    public NotIntegerException() {
        super(ExceptionMessages.EXCEPTION_MESSAGES_NOT_INTEGER.getMessage());
    }
}
