package util;

import java.util.Random;

public class RandomManager {
    public static boolean straightCar() {
        Random random = new Random();
        int randomCount = random.nextInt(10);
        return randomCount >= 4;
    }

    public static boolean straightCar(int randomSeed) {
        Random random = new Random(randomSeed);
        int randomCount = random.nextInt(10);
        return randomCount >= 4;
    }
}
