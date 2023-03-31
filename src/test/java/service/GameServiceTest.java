package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import collection.Car;
import collection.Cars;
import constant.ConstantNumbers;
import domain.InputString;
import domain.TryCount;
import exception.NotIntegerException;
import exception.OverMaximumException;
import exception.UnderMaximumException;

public class GameServiceTest {
    private GameService gameService = new GameService();

    @ParameterizedTest
    @CsvSource(value = {"abc,def,ghi,jkl", "aaa,bbb,ccc,ddd", "qwe,asd,zxc,rfv"}, delimiter = ':')
    public void throwOverMaximumException(String inputString) {
        assertThrows(OverMaximumException.class, () -> {
            new InputString(inputString.split(","));
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"abc,def", "aaa,bbb", "qwe,asd"}, delimiter = ':')
    public void throwUnderMaximumException(String inputString) {
        assertThrows(UnderMaximumException.class, () -> {
            new InputString(inputString.split(","));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "2s", "d13"})
    public void throwNotIntegerException(String inputString) {
        assertThrows(NotIntegerException.class, () -> {
            new TryCount(inputString);
        });
    }

    @ParameterizedTest
    @MethodSource("carDataMethod")
    public void judgeFinalWinner(List<Car> carData) {
        Cars cars = new Cars();
        cars.setCars(carData);
        assertEquals(cars.getFinalWinner(), judgeWinner(cars));
    }

    private Cars judgeWinner(Cars cars) {
        Cars result = new Cars();
        int max = Collections.max(cars.getLocations());
        List<Boolean> winners = new ArrayList<>();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .filter(i -> cars.getLocation(i) == max)
            .forEach(i -> result.add(cars.getCar(i)));
        return result;
    }

    private static Stream<Arguments> carDataMethod() {
        return Stream.of(
            Arguments.of((Object)Arrays.asList(new Car("a", 3), new Car("b", 2), new Car("c", 1))),
            Arguments.of((Object)Arrays.asList(new Car("aaa", 3), new Car("bbb", 3), new Car("ccc"), 0)),
            Arguments.of((Object)Arrays.asList(new Car("pobi", 5), new Car("crong", 4), new Car("honux"), 5))
        );
    }
}
