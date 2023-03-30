package constant;

public enum ExceptionMessages {
    EXCEPTION_MESSAGES_EXCEED_MAXIMUM("자동차 개수 최대치 초과");

    private final String message;

    ExceptionMessages(String label) {
        this.message = label;
    }

    public String getMessage() {
        return message;
    }
}
