package racingcar.view;

public class OutputView {

    public void displayStart() {
        System.out.println("실행 결과");
    }

    public void displayResultByOrder(String progress) {
        System.out.println(progress);
    }

    public void displayWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
