package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import collection.Cars;

class InputStringTest {

    @ParameterizedTest
    @MethodSource("domain.CarsTest#nameArrays")
    void setCars(List<String> strings) {
        Cars cars = new Cars();
        InputString inputString = new InputString(strings);
        inputString.setCars(cars);
        assertEquals(cars.getNames(), strings);
    }
}
