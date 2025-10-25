package racingcar.domain;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final NumberGenerator generator;

    public Race(List<Car> cars, NumberGenerator generator) {
        this.cars = cars;
        this.generator = generator;
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.move(generator);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
