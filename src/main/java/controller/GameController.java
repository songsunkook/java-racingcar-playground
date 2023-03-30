package controller;

import service.GameService;
import view.InputView;
import view.OutputView;

public class GameController {
    private GameService gameService = new GameService();

    public void initGame() {
        try {
            gameService.startGame();
        } catch (RuntimeException runtimeException) {
            OutputView.println(runtimeException.getMessage());
        }
    }

    public static String inputCarName() {
        return InputView.getLine();
    }
}
