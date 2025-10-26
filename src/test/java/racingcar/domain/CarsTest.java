package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CarsTest {

    private static class TestCar extends Car {
        private final int testPosition;

        public TestCar(String name, int position) {
            super(name);
            this.testPosition = position;
        }

        @Override
        public int getPosition() {
            return testPosition;
        }
    }

    @Test
    @DisplayName("공동 우승자가 존재하면 공동 우승자 이름을 반환한다.")
    void 공동_우승자가_존재하면_공동_우승자_이름을_반환한다() {
        Car car1 = new TestCar("pobi", 5);
        Car car2 = new TestCar("woni", 3);
        Car car3 = new TestCar("jun", 5);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }

    @Test
    @DisplayName("단일 우승자가 존재하면 해당 이름만 반환한다.")
    void 단일_우승자가_존재하면_해당_이름만_반환한다() {
        Car car1 = new TestCar("pobi", 1);
        Car car2 = new TestCar("woni", 2);
        Cars cars = new Cars(Arrays.asList(car1, car2));

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactly("woni");
    }

    @Test
    @DisplayName("자동차 목록이 비어 있으면 빈 리스트를 반환한다.")
    void 자동차_목록이_비어_있으면_예외를_발생시킨다() {
        Cars cars = new Cars(Collections.emptyList());

        assertThatThrownBy(cars::getWinners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("경주에 참여한 자동차가 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름을 추가된 순서대로 반환한다.")
    void 자동차_이름을_추가된_순서대로_반환한다() {
        Car car1 = new TestCar("a", 1);
        Car car2 = new TestCar("b", 2);
        Cars cars = new Cars(Arrays.asList(car1, car2));

        List<String> names = cars.getCarNames();

        assertThat(names).containsExactly("a", "b");
    }

    @Test
    @DisplayName("자동차 위치를 추가된 순서대로 반환한다.")
    void 자동차_위치를_추가된_순서대로_반환한다() {
        Car car1 = new TestCar("a", 3);
        Car car2 = new TestCar("b", 0);
        Cars cars = new Cars(Arrays.asList(car1, car2));

        List<Integer> positions = cars.getPositions();

        assertThat(positions).containsExactly(3, 0);
    }
}
