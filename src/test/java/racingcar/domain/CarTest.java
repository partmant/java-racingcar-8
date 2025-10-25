package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 4 이상이면 자동차가 전진한다")
    void movesWhenNumberIsAtLeastThreshold() {
        Car car = new Car("pobi");
        NumberGenerator generator = () -> 4;

        car.move(generator);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만이면 자동차가 전진하지 않는다")
    void doesNotMoveWhenNumberIsBelowThreshold() {
        Car car = new Car("pobi");
        NumberGenerator generator = () -> 3;

        car.move(generator);

        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 생성 시 이름이 올바르게 저장된다")
    void nameIsPreservedAfterCreation() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 생성 시 위치는 0으로 초기화된다")
    void positionIsZeroAfterCreation() {
        Car car = new Car("pobi");

        assertThat(car.getPosition()).isZero();
    }
}
