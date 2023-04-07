package collection;


public class Car {
    private int location;
    private final String name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void goStraight(boolean isStraight) {
        if (isStraight) {
            location++;
        }
    }

    public boolean isSameLocation(int location) {
        return this.location == location;
    }
}
