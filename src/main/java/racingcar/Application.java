package racingcar;

import racingcar.controller.GameController;
import racingcar.service.RaceService;
import racingcar.util.Converter;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();
        Validator validator = new Validator();
        Converter converter = new Converter();
        RaceService raceService = new RaceService();

        GameController gameController = new GameController(
                inputView, outputView, parser, validator, converter, raceService
        );
        gameController.gameStart();
    }
}
