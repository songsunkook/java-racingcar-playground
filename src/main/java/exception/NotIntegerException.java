package exception;

import constant.ExceptionMessages;

public class NotIntegerException extends RuntimeException {
    public NotIntegerException() {
        super(ExceptionMessages.NOT_INTEGER.getMessage());
    }
}
