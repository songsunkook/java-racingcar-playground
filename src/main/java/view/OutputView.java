package view;

import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;

public class OutputView {
    private static final String RESULT_TEXT = "실행 결과";
    private static final String LOCATION_CHAR = "-";

    public static void println(String message) {
        System.out.println(message);
    }

    public static void outputResult(Cars cars) {
        System.out.println(RESULT_TEXT);
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .mapToObj(i -> cars.getName(i) + " : " + createLocationText(cars.getLocation(i)))
            .forEach(System.out::println);
    }

    private static String createLocationText(int location) {
        String result = new String();
        for (int j = ConstantNumbers.ZERO.getNumber(); j < location; j++) {
            result += LOCATION_CHAR;
        }
        return result;
    }
}
