package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 초기_조회() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"));
        List<Car> carsList = cars.getCars();

        assertThat(carsList).hasSize(3);
        assertThat(carsList.get(0).getName()).isEqualTo("pobi");
        assertThat(carsList.get(1).getName()).isEqualTo("woni");
        assertThat(carsList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 이동_테스트() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni"));

        cars.getCars().get(0).move(MOVING_FORWARD);
        cars.getCars().get(1).move(STOP);

        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void 단일_우승자_찾기() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni"));

        cars.getCars().get(0).move(MOVING_FORWARD);
        cars.getCars().get(1).move(STOP);

        List<Car> winners = cars.findWinners();
        assertThat(winners).extracting(Car::getName)
                .contains("pobi");
    }

    @Test
    void 복수_우승자_찾기() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"));

        cars.getCars().get(0).move(MOVING_FORWARD);
        cars.getCars().get(1).move(STOP);
        cars.getCars().get(2).move(MOVING_FORWARD);

        List<Car> winners = cars.findWinners();
        assertThat(winners).extracting(Car::getName)
                .contains("pobi", "jun");
    }

}
