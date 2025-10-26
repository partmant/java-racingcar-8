package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    private static class TestCar extends Car {
        public TestCar(String name) {
            super(name);
        }
    }

    private static class FixedNumberGenerator implements NumberGenerator {
        private final int number;
        public FixedNumberGenerator(int number) {
            this.number = number;
        }
        @Override
        public int generate() {
            return number;
        }
    }

    @Test
    @DisplayName("모든 자동차가 이동 조건을 만족하면 모두 전진한다")
    void allCarsMoveWhenNumberIsAtLeastThreshold() {
        List<Car> cars = Arrays.asList(new TestCar("pobi"), new TestCar("woni"));
        NumberGenerator generator = new FixedNumberGenerator(4);
        Race race = new Race(generator);

        race.moveAllCars(cars);

        assertThat(cars)
                .extracting(Car::getPosition)
                .containsExactly(1, 1);
    }

    @Test
    @DisplayName("모든 자동차가 이동 조건을 만족하지 않으면 모두 정지한다")
    void allCarsDoNotMoveWhenNumberIsBelowThreshold() {
        List<Car> cars = Arrays.asList(new TestCar("pobi"), new TestCar("woni"), new TestCar("jun"));
        NumberGenerator generator = new FixedNumberGenerator(3);
        Race race = new Race(generator);

        race.moveAllCars(cars);

        assertThat(cars)
                .extracting(Car::getPosition)
                .containsExactly(0, 0, 0);
    }
}
