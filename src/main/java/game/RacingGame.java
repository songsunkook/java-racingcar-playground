package game;

import java.util.List;

import collection.Cars;
import domain.CarsModel;
import domain.InputString;
import domain.TryCount;

public class RacingGame {
    private TryCount tryCount;
    private final Cars cars = new Cars();

    public void setCarName(List<String> carName) {
        InputString inputString = new InputString(carName);
        inputString.setCars(cars);
    }

    public void setTryCount(String tryCount) {
        this.tryCount = new TryCount(tryCount);
    }

    public CarsModel tryLoopOnce(List<Boolean> isStraightList) {
        cars.goStraights(isStraightList);
        return new CarsModel(cars);
    }

    public int getTryCount() {
        return tryCount.get();
    }

    public CarsModel judgeFinalWinner() {
        return new CarsModel(cars.getFinalWinner());
    }
}
