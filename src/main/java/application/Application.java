package application;

import controller.GameController;
import view.OutputView;

public class Application {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        try {
            gameController.initGame();
        } catch (RuntimeException runtimeException) {
            OutputView.outputMessage(runtimeException.getMessage());
        }
    }
}
