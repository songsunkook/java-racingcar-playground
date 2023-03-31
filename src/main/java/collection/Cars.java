package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import constant.ConstantNumbers;

public class Cars {
    private List<Car> carList = new ArrayList<Car>();

    public void add(String carName) {
        carList.add(new Car(carName));
    }

    public String getName(int carIndex) {
        return carList.get(carIndex).getName();
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
}
