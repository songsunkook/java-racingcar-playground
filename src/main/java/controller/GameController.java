package controller;

import collection.Cars;
import service.GameService;
import view.InputView;
import view.OutputView;

public class GameController {
    private GameService gameService = new GameService();

    public void initGame() {
        gameService.inputCarName();
        gameService.inputTryCount();
        gameService.tryLoop();
    }

    public static String[] inputCarName() {
        return InputView.inputCarName();
    }

    public static String inputTryCount() {
        return InputView.getLine();
    }

    public static void outputResult(Cars cars) {
        OutputView.outputResult(cars);
    }
}
