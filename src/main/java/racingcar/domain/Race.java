package racingcar.domain;

import java.util.List;

public class Race {

    private final NumberGenerator generator;

    public Race(NumberGenerator generator) {
        this.generator = generator;
    }

    public void moveAllCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(generator);
        }
    }
}
