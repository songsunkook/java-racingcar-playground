package controller;

import collection.Cars;
import constant.OutputMessages;
import game.RacingGame;
import view.InputView;
import view.OutputView;

public class GameController {
    private RacingGame racingGame = new RacingGame();

    public void initGame() {
        racingGame.inputCarName();
        racingGame.inputTryCount();
        racingGame.tryLoop();
        OutputView.outputFinalResult(racingGame.judgeFinalWinner());
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
