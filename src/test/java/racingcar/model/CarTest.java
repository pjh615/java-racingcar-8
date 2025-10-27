package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 이름_조회() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 초기_위치_조회() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이동_테스트() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
