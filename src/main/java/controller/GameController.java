package controller;

import service.GameService;
import view.InputView;

public class GameController {
    private GameService gameService = new GameService();

    public void initGame() {
        gameService.startGame();
    }

    public static String inputCarName() {
        return InputView.getLine();
    }
}
