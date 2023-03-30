package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.Cars;
import exception.OverMaximumException;

public class GameServiceTest {
    private Cars cars = new Cars();
    private GameService gameService = new GameService();

    @ParameterizedTest
    @CsvSource(value = {"abc,def,ghi,jkl", "aaa,bbb,ccc,ddd", "qwe,asd,zxc,rfv"}, delimiter = ':')
    public void throwExceedMaximumException(String inputString) {
        assertThrows(OverMaximumException.class, () -> {
            gameService.checkInputString(inputString.split(","));
        });
    }
}
