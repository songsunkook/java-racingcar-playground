package util;

import java.util.Random;

public class RandomManager {
    public static final int RANDOM_STANDARD = 4;
    public static final int MAXIMUM_NUMBER = 9;

    public static boolean straightCar() {
        Random random = new Random();
        int randomCount = random.nextInt(MAXIMUM_NUMBER + 1);
        return randomCount >= RANDOM_STANDARD;
    }

    public static boolean straightCar(int randomSeed) {
        Random random = new Random(randomSeed);
        int randomCount = random.nextInt(MAXIMUM_NUMBER + 1);
        return randomCount >= RANDOM_STANDARD;
    }
}
