package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import collection.Cars;
import constant.ConstantNumbers;

class CarsTest {

    @ParameterizedTest
    @MethodSource("nameArrays")
    public void manageCarNames(List<String> names) {
        Cars cars = new Cars();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> cars.add(names.get(i)));
        assertEquals(cars.getNames(), names);
    }

    private static Stream<Arguments> nameArrays() {
        return Stream.of(
            Arguments.of(Arrays.asList("a", "b", "c")),
            Arguments.of(Arrays.asList("aaa", "bbb", "ccc")),
            Arguments.of(Arrays.asList("pobi", "crong", "honux"))
        );
    }
}
