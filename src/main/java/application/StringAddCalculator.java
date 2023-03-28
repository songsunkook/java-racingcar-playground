package application;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringAddCalculator {
    private static final int ZERO_NUMBER = 0;

    public static int splitAndSum(String expression) {
        Integer result;

        if (!checkEmptyExpression(expression)) {
            return ZERO_NUMBER;
        }

        result = checkOnlyOneNumber(expression);
        if (result != null) {
            return result;
        }

        result = sumWithDelimiterCommaOrColon(expression);
        if (result != null) {
            return result;
        }

        result = sumWithCustomDelimiter(expression);
        if (result != null) {
            return result;
        }

        return ZERO_NUMBER;
    }

    private static boolean checkEmptyExpression(final String expression) {
        if (expression == null) {
            return false;
        }
        if (expression.isEmpty()) {
            return false;
        }
        return true;
    }

    private static Integer checkOnlyOneNumber(final String expression) {
        try {
            return Integer.parseInt(expression);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private static Integer sumWithDelimiterCommaOrColon(final String expression) {
        String[] numbersString = expression.split(",|:");

        try {
            numbersString[1].isEmpty();
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return null;
        }

        int[] numbers = stringsToInts(numbersString);

        return getSum(numbers);
    }

    private static Integer sumWithCustomDelimiter(String expression) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            int[] numbers = stringsToInts(tokens);

            return getSum(numbers);
        }
        return null;
    }

    private static int[] stringsToInts(String[] strings) {
        return Stream.of(strings).mapToInt(Integer::parseInt).toArray();
    }

    private static int getSum(int[] numbers) {
        checkNegativeNumbers(numbers);
        return Arrays.stream(numbers).sum();
    }

    private static void checkNegativeNumbers(int[] numbers) {
        IntStream.range(0, numbers.length)
            .filter(i -> numbers[i] < 0).forEach(i -> {
                throw new RuntimeException();
            });
    }
}

/*

        6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
구글에서 “junit4 expected exception”으로 검색해 해결책을 찾는다.
*/
