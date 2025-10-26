package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RaceService {
    private Cars cars;

    public void init(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    public void playRace(){
        cars.moveByNumber();
    }

    public String getRaceResult() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getCars()) {
            sb.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        return sb.toString();
    }

    public String getWinnerResult() {
        List<String> winners = cars.findWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return String.join(", ", winners);
    }

}
