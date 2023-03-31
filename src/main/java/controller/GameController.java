package controller;

import collection.Cars;
import constant.OutputMessages;
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
        OutputView.outputMessage(OutputMessages.INPUT_CAR_NAME.getMessage());
        return InputView.inputCarName();
    }

    public static String inputTryCount() {
        OutputView.outputMessage(OutputMessages.INPUT_TRY_COUNT.getMessage());
        return InputView.getLine();
    }

    public static void outputResult(Cars cars) {
        OutputView.outputResult(cars);
    }
}
