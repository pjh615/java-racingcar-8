package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.util.Converter;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    public final InputView inputView;
    public final OutputView outputView;
    public final Parser parser;
    public final Validator validator;
    public final Converter converter;
    public final RaceService raceService;

    public GameController(InputView inputView, OutputView outputView, Parser parser,
                          Validator validator, Converter converter, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
        this.validator = validator;
        this.converter = converter;
        this.raceService = raceService;
    }

    public void gameStart() {
        String carNamesInput = inputView.inputCarNames();
        List<String> carNames = parser.parseByDelimiter(carNamesInput);
        validator.isOver5Characters(carNames);
        validator.isDuplicateName(carNames);

        String attemptCountInput = inputView.inputAttemptCount();
        int attemptCount = converter.stringToInt(attemptCountInput);
        validator.isNegative(attemptCount);

        outputView.displayStart();
        raceService.init(carNames);
        for (int i = 0; i < attemptCount; i++) {
            raceService.playRace();
            outputView.displayResultByOrder(raceService.getRaceResult());
        }
        outputView.displayWinner(raceService.getWinnerResult());

    }
}
