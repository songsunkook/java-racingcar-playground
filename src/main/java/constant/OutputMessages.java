package constant;

public enum OutputMessages {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
    FINAL_WINNER("가 최종 우승했습니다.");

    private final String message;

    OutputMessages(String label) {
        message = label;
    }

    public String getMessage() {
        return message;
    }
}
