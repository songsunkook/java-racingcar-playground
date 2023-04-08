package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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

@DisplayName("레이싱 게임에서")
public class RacingGameTest {
    @ParameterizedTest
    @CsvSource(value = {"abc,def,ghi,jkl", "aaa,bbb,ccc,ddd", "qwe,asd,zxc,rfv"}, delimiter = ':')
    @DisplayName("자동차 개수가 한도를 넘어가면 예외가 발생하는가")
    public void throwOverMaximumException(String inputString) {
        assertThrows(OverMaximumException.class, () -> new InputString(Arrays.asList(inputString.split(","))));
    }

    @ParameterizedTest
    @CsvSource(value = {"abc,def", "aaa,bbb", "qwe,asd"}, delimiter = ':')
    @DisplayName("자동차 개수가 한도보다 작으면 예외가 발생하는가")
    public void throwUnderMaximumException(String inputString) {
        assertThrows(UnderMaximumException.class, () -> new InputString(Arrays.asList(inputString.split(","))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "2s", "d13"})
    @DisplayName("시도 횟수가 정수가 아니면 예외가 발생하는가")
    public void throwNotIntegerException(String inputString) {
        assertThrows(NotIntegerException.class, () -> new TryCount(inputString));
    }

    @ParameterizedTest
    @MethodSource("carDataMethod")
    @DisplayName("승자가 정상적으로 판단되는가")
    public void judgeFinalWinner(List<Car> carData1, List<Car> carData2) {
        Cars cars1 = new Cars();
        cars1.setCars(carData1);
        Cars cars2 = new Cars();
        cars2.setCars(carData2);

        assertTrue(compareCars(cars1.getFinalWinner(), cars2));
    }

    private boolean compareCars(Cars cars1, Cars cars2) {
        for (int i = 0; i < cars1.size(); i++) {
            if (!cars1.getName(i).equals(cars2.getName(i))) {
                return false;
            }
            if (cars1.getLocation(i) != cars2.getLocation(i)) {
                return false;
            }
        }
        return true;
    }

    private static Stream<Arguments> carDataMethod() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Car("a", 3), new Car("b", 2), new Car("c", 1)),
                Collections.singletonList(new Car("a", 3))),
            Arguments.of(Arrays.asList(new Car("aaa", 3), new Car("bbb", 3), new Car("ccc", 0)),
                Arrays.asList(new Car("aaa", 3), new Car("bbb", 3))),
            Arguments.of(Arrays.asList(new Car("pobi", 5), new Car("crong", 4), new Car("honux", 5)),
                Arrays.asList(new Car("pobi", 5), new Car("honux", 5)))
        );
    }
}
