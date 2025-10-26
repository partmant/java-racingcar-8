package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Race;

public class RacingService {

    private final Race race;

    public RacingService(Race race) {
        this.race = race;
    }

    public void startRace(Cars cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            race.moveAllCars(cars.getCarsList());
        }
    }
}
