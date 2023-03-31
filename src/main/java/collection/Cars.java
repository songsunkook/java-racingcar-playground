package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import constant.ConstantNumbers;
import controller.GameController;

public class Cars {
    private List<Car> carList = new ArrayList<Car>();

    public void add(String carName) {
        carList.add(new Car(carName));
    }

    public void add(Car car) {
        carList.add(car);
    }

    public Car getCar(int index) {
        return carList.get(index);
    }

    public String getName(int carIndex) {
        return carList.get(carIndex).getName();
    }

    public int getLocation(int carIndex) {
        return carList.get(carIndex).getLocation();
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), carList.size())
            .forEach(i -> names.add(carList.get(i).getName()));
        return names;
    }

    public List<Integer> getLocations() {
        List<Integer> locations = new ArrayList<>();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), carList.size())
            .forEach(i -> locations.add(carList.get(i).getLocation()));
        return locations;
    }

    public void setCars(List<Car> carList) {
        this.carList = carList;
    }

    public void goStraights() {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), carList.size())
            .forEach(i -> carList.get(i).goStraight());
    }

    public void goStraights(int randomSeed) {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), carList.size())
            .forEach(i -> carList.get(i).goStraight(randomSeed));
    }

    public void outputResult() {
        GameController.outputResult(this);
    }

    public Cars getFinalWinner() {
        Cars cars = new Cars();
        int max = Collections.max(getLocations());
        List<Integer> integerList = IntStream.range(ConstantNumbers.ZERO.getNumber(), carList.size())
            .filter(i -> carList.get(i).getLocation() == max)
            .boxed()
            .collect(Collectors.toList());

        integerList.stream()
            .forEach(i -> cars.add(carList.get(i)));

        return cars;
    }

    @Override
    public boolean equals(Object obj) {
        Cars parameterCars = (Cars)obj;
        if (carList.size() != parameterCars.carList.size()) {
            return false;
        }
        for (int i = ConstantNumbers.ZERO.getNumber(); i < carList.size(); i++) {
            if (carList.get(i).getName() != parameterCars.getName(i)) {
                return false;
            }
            if (carList.get(i).getLocation() != parameterCars.getLocation(i)) {
                return false;
            }
        }
        return true;
    }
}
