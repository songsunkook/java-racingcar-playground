package controller;

import service.GameService;
import view.InputView;

public class GameController {
    private GameService gameService = new GameService();

    public void initGame() {
        gameService.startGame();
        gameService.inputCarName();
        gameService.inputTryCount();
    }

    public static String[] inputCarName() {
        return InputView.inputCarName();
    }

    public static String inputTryCount() {
        return InputView.getLine();
    }
}
