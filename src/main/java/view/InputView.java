package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String getLine() {
        return scanner.nextLine();
    }

    public static String[] inputCarName() {
        String string = scanner.nextLine();
        return string.split(",");
    }
}
