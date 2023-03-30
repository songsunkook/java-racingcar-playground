package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import constant.ConstantNumbers;

class CarsTest {

    @ParameterizedTest
    @MethodSource("nameArrays")
    public void manageCarNames(String[] names) {
        Cars cars = new Cars();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> cars.addCar(names[i]));
        assertEquals(cars.getCarNames(), Arrays.asList(names));
    }
/*
    //자동차 객체 세팅
    @ParameterizedTest
    @MethodSource("carDataMethod")
    public void test(List<Car> carData) {
        Cars cars = new Cars();
        cars.setCars(carData);
    }*/

    private static Stream<Arguments> nameArrays() {
        return Stream.of(
            Arguments.of((Object)new String[] {"a", "b", "c"}),
            Arguments.of((Object)new String[] {"aaa", "bbb", "ccc"}),
            Arguments.of((Object)new String[] {"pobi", "crong", "honux"})
        );
    }

    private static Stream<Arguments> carDataMethod() {
        return Stream.of(
            Arguments.of((Object)Arrays.asList(new Car("a"), new Car("b"), new Car("c"))),
            Arguments.of((Object)Arrays.asList(new Car("aaa"), new Car("bbb"), new Car("ccc"))),
            Arguments.of((Object)Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux")))
        );
    }
}
