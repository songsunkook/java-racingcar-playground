package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    private Cars cars = new Cars();

    @ParameterizedTest
    @MethodSource("nameArrays")
    public void ManageCarNames(String[] names) {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> cars.addCar(names[i]));
        assertEquals(cars.getCarNames(), Arrays.asList(names));
    }

    private static Stream<Arguments> nameArrays() {
        return Stream.of(
            Arguments.of((Object)new String[] {"a", "b", "c"}),
            Arguments.of((Object)new String[] {"aaa", "bbb", "ccc"}),
            Arguments.of((Object)new String[] {"pobi", "crong", "honux"})
        );
    }
}
