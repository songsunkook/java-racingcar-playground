package service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import domain.Cars;

public class GameServiceTest {
    private Cars cars = new Cars();
    private GameService gameService = new GameService();

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    public void inputCarNames() {
        gameService.inputCarName();
    }
}
