package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.Race;

public class RacingService {

    private final Race race;

    public RacingService(Race race) {
        this.race = race;
    }

    public void startRound(Cars cars) {
        race.moveAllCars(cars.getCarsList());
    }
}
