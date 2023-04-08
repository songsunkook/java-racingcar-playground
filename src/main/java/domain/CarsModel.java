package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import collection.Car;
import collection.Cars;

public class CarsModel {
    private final List<Car> carList = new ArrayList<>();

    public CarsModel(Cars cars) {
        IntStream.range(0, cars.size())
            .forEach(i -> carList.add(cars.getCar(i)));
    }

    public int size() {
        return carList.size();
    }

    public String getName(int carIndex) {
        return carList.get(carIndex).getName();
    }

    public int getLocation(int carIndex) {
        return carList.get(carIndex).getLocation();
    }
}
