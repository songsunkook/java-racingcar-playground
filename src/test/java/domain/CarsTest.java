package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import collection.Cars;
import constant.ConstantNumbers;

class CarsTest {
    private static final int TEST_RANDOM_SEED = 10;

    @ParameterizedTest
    @MethodSource("nameArrays")
    public void manageCarNames(String[] names) {
        Cars cars = new Cars();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> cars.add(names[i]));
        assertEquals(cars.getNames(), Arrays.asList(names));
    }

    private static Stream<Arguments> nameArrays() {
        return Stream.of(
            Arguments.of((Object)new String[] {"a", "b", "c"}),
            Arguments.of((Object)new String[] {"aaa", "bbb", "ccc"}),
            Arguments.of((Object)new String[] {"pobi", "crong", "honux"})
        );
    }
}
