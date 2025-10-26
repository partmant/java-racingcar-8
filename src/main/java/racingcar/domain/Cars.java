package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars create(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("경주에 참여한 자동차가 없습니다."));
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsList() {
        return List.copyOf(cars);
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }
}
