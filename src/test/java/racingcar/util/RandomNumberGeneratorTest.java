package racingcar.util;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    void randomNumberGenerator(){
        for(int i=0; i<10; i++){
            int number = RandomNumberGenerator.randomNumberGenerate();
            assertThat(number).isBetween(0, 9);
        }
    }
}
