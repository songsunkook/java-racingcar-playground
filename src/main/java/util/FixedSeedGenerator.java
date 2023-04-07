package util;

import java.util.Random;

public class FixedSeedGenerator implements RandomGenerator {
    private final int randomSeed;

    public FixedSeedGenerator(int randomSeed) {
        this.randomSeed = randomSeed;
    }
    @Override
    public boolean straightCar() {
        Random random = new Random(randomSeed);
        int randomCount = random.nextInt(MAXIMUM_NUMBER + 1);
        return randomCount >= RANDOM_STANDARD;
    }
}
