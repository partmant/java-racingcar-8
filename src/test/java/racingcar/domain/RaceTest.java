package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("모든 자동차가 이동 조건을 만족하면 모두 전진한다")
    void allCarsMoveWhenNumberIsAtLeastThreshold() {
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
        NumberGenerator generator = () -> 4;
        Race race = new Race(cars, generator);

        race.moveAllCars();

        assertThat(cars)
                .extracting(Car::getPosition)
                .containsExactly(1, 1);
    }

    @Test
    @DisplayName("모든 자동차가 이동 조건을 만족하지 않으면 모두 정지한다")
    void allCarsDoNotMoveWhenNumberIsBelowThreshold() {
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
        NumberGenerator generator = () -> 3;
        Race race = new Race(cars, generator);

        race.moveAllCars();

        assertThat(cars)
                .extracting(Car::getPosition)
                .containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("자동차 목록을 반환한다")
    void returnsCarList() {
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
        Race race = new Race(cars, () -> 4);

        List<Car> result = race.getCars();

        assertThat(result).containsExactlyElementsOf(cars);
    }
}
