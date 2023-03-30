package controller;

import service.GameService;
import view.InputView;
import view.OutputView;

public class GameController {
    private GameService gameService = new GameService();

    public void initGame() {
        try {
            gameService.startGame();
            //예외처리를 Application에서 진행, 컨트롤러에서 gameService 각 단계 호출하도록 수정하기
        } catch (RuntimeException runtimeException) {
            OutputView.println(runtimeException.getMessage());
        }
    }

    public static String[] inputCarName() {
        return InputView.inputCarName();
    }

    public static String inputTryCount() {
        return InputView.getLine();
    }
}
