package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import collection.Cars;

class InputStringTest {

    @ParameterizedTest
    @MethodSource("nameArrays")
    void setCars(String[] strings) {
        Cars cars = new Cars();
        InputString inputString = new InputString(strings);
        inputString.setCars(cars);
        assertEquals(cars.getCarNames(), Arrays.asList(strings));
    }

    private static Stream<Arguments> nameArrays() {
        return Stream.of(
            Arguments.of((Object)new String[] {"a", "b", "c"}),
            Arguments.of((Object)new String[] {"aaa", "bbb", "ccc"}),
            Arguments.of((Object)new String[] {"pobi", "crong", "honux"})
        );
    }
}
