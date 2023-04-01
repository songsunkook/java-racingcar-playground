package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class RandomManagerTest {
    private static final int TEST_RANDOM_SEED = 10;

    @Test
    public void straightCar() {
        assertEquals(RandomManager.straightCar(TEST_RANDOM_SEED),
            (new Random(TEST_RANDOM_SEED).nextInt(RandomManager.MAXIMUM_NUMBER + 1) >= 4));
    }
}