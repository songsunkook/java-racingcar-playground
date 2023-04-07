package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import constant.OutputMessages;
import game.RacingGame;
import util.RandomManager;
import view.InputView;
import view.OutputView;

public class GameController {
    private final RacingGame racingGame = new RacingGame();

    public void initGame() {
        racingGame.inputCarName();
        racingGame.inputTryCount();
        loopGame();
        OutputView.outputFinalResult(racingGame.judgeFinalWinner());
    }

    private void loopGame() {
        List<Boolean> isStraightList = new ArrayList<>();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), racingGame.getTryCount())
            .forEach(i -> {
                IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
                    .forEach(j -> isStraightList.add(RandomManager.straightCar()));
                racingGame.tryLoopOnce(isStraightList);
            });
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
