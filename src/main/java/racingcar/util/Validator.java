package racingcar.util;

import java.util.List;

public class Validator {
    public void isOver5Characters(List<String> carNames){
        for (String carName : carNames ) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isNegative(int number){
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}
