package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public void isOver5Characters(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isDuplicateName(List<String> carNames) {
        Set<String> uniqueCarNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (!uniqueCarNameSet.contains(carName)) {
                uniqueCarNameSet.add(carName);
            }
            else
                throw new IllegalArgumentException();
        }
    }
}
