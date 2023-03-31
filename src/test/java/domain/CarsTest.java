package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import collection.Car;
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

    @ParameterizedTest
    @MethodSource("carDataMethod")
    public void goStraights(List<Car> carData) {
        Cars cars = new Cars();
        cars.setCars(carData);
        cars.goStraights();
        //cars.goStraights(TEST_RANDOM_SEED);
        //random test 구현해야 함
        //seed를 매개로 넘겨주는 것까진 생각해봤는데 어떻게 적용해서 테스트할지 모르겠음
        //assertEquals(cars.getCarLocations(), Arrays.asList());
        System.out.println(cars.getLocations().get(0));
    }

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
