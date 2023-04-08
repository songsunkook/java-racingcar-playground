package view;

import java.util.stream.IntStream;

import constant.ConstantNumbers;
import constant.OutputMessages;
import domain.CarsModel;

public class OutputView {
    private static final String RESULT_TEXT = "실행 결과";
    private static final String LOCATION_CHAR = "-";
    private static final String SPLITTER_STRING = ", ";

    public static void outputMessage(String message) {
        System.out.println(message);
    }

    public static void outputFinalResult(CarsModel carsModel) {
        for (int i = ConstantNumbers.ZERO.getNumber(); i < carsModel.size(); i++) {
            System.out.print(carsModel.getName(i));
            if (i != carsModel.size() - 1) {
                System.out.print(SPLITTER_STRING);
            }
        }
        System.out.println(OutputMessages.FINAL_WINNER.getMessage());
    }

    public static void outputResult(CarsModel carsModel) {
        System.out.println(RESULT_TEXT);
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .mapToObj(i -> carsModel.getName(i) + " : " + createLocationText(carsModel.getLocation(i)))
            .forEach(System.out::println);
        System.out.println();
    }

    private static String createLocationText(int location) {
        String result = new String();
        for (int j = ConstantNumbers.ZERO.getNumber(); j < location; j++) {
            result += LOCATION_CHAR;
        }
        return result;
    }
}
