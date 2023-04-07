package util;

import java.util.Random;

public class RandomSeedGenerator implements RandomGenerator {
    @Override
    public boolean straightCar() {
        Random random = new Random();
        int randomCount = random.nextInt(MAXIMUM_NUMBER + 1);
        return randomCount >= RANDOM_STANDARD;
    }
}
