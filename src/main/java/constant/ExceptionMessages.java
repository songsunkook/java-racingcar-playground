package constant;

public enum ExceptionMessages {
    EXCEPTION_MESSAGES_OVER_MAXIMUM("자동차 개수 최대치 초과"),
    EXCEPTION_MESSAGES_UNDER_MAXIMUM("자동차 개수 부족"),
    EXCEPTION_MESSAGES_NOT_INTEGER("시도 횟수가 정수가 아님");

    private final String message;

    ExceptionMessages(String label) {
        this.message = label;
    }

    public String getMessage() {
        return message;
    }
}
