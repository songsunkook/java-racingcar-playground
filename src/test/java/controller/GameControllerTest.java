package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import constant.ConstantNumbers;
import util.FixedSeedGenerator;
import util.RandomGenerator;

@DisplayName("게임 컨트롤러가")
class GameControllerTest {
    private static final int TEST_RANDOM_SEED = 10;

    @Test
    @DisplayName("랜덤값을 잘 반환하는가")
    public void getRandomValues() {
        GameController gameController = new GameController();
        List<Boolean> testList = new ArrayList<>();
        List<Boolean> resultStraightList = new ArrayList<>();

        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> testList.add(new Random(TEST_RANDOM_SEED).nextInt(RandomGenerator.MAXIMUM_NUMBER + 1) >= 4));

        gameController.getRandomValues(resultStraightList, new FixedSeedGenerator(TEST_RANDOM_SEED));
        assertEquals(testList, resultStraightList);
    }
}
