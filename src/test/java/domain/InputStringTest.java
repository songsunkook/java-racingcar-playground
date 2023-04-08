package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import collection.Cars;

@DisplayName("입력받은 문자열중에")
class InputStringTest {

    @ParameterizedTest
    @MethodSource("domain.CarsTest#nameArrays")
    @DisplayName("자동차 이름을 잘 관리하는가")
    void setCars(List<String> strings) {
        Cars cars = new Cars();
        InputString inputString = new InputString(strings);
        inputString.setCars(cars);
        assertEquals(cars.getNames(), strings);
    }
}
