package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> carList = new ArrayList<Car>();

    public void addCar(String carName) {
        carList.add(new Car(carName));
    }

    public String getCarName(int carIndex) {
        return carList.get(carIndex).getName();
    }

    public List<String> getCarNames() {
        List<String> names = new ArrayList<>();
        IntStream.range(ConstantNumbers.ZERO.getNumber(), carList.size())
            .forEach(i -> names.add(carList.get(i).getName()));
        return names;
    }

    public void setCars(List<Car> carList) {
        this.carList = carList;
    }
}
