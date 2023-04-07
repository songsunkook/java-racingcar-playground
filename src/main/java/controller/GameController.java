package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import constant.OutputMessages;
import game.RacingGame;
import util.RandomGenerator;
import util.RandomSeedGenerator;
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
        final RandomGenerator randomSeedGenerator = new RandomSeedGenerator();
        List<Boolean> isStraightList = new ArrayList<>();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), racingGame.getTryCount())
            .forEach(i -> {
                getRandomValues(isStraightList, randomSeedGenerator);
                racingGame.tryLoopOnce(isStraightList);
            });
    }

    public void getRandomValues(List<Boolean> isStraightList, RandomGenerator randomGenerator) {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> isStraightList.add(randomGenerator.straightCar()));
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
