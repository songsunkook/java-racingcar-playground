package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import collection.Car;
import collection.Cars;
import domain.InputString;
import domain.TryCount;
import exception.NotIntegerException;
import exception.OverMaximumException;
import exception.UnderMaximumException;

public class GameServiceTest {
    private Cars cars = new Cars();
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
    public void tryLoop(List<Car> carData) {
        Cars cars = new Cars();
        cars.setCars(carData);

        gameService.tryLoop(cars);
    }
}
