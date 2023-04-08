package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getLine() {
        return scanner.nextLine();
    }

    public static List<String> inputCarName() {
        String[] string = scanner.nextLine().split(SPLIT_DELIMITER);
        return Arrays.asList(string);
    }
}
