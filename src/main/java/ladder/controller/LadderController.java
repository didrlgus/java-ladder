package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Lines;
import ladder.domain.Names;
import ladder.strategy.RandomPointGenerator;
import ladder.domain.ResultName;
import ladder.domain.Results;
import ladder.domain.ResultsBoard;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderController {

	public static void start() {
		Names names = new Names(InputView.inputNames());
		Results results = new Results(InputView.inputResults(), names);
		Height height = new Height(InputView.inputHeight());

		Ladder ladder = new Ladder(Lines.of(height, names, new RandomPointGenerator()));
		ResultView.printNames(names);
		ResultView.printLadder(ladder);
		ResultView.printResults(results);

		LadderGame ladderGame = new LadderGame();
		ladderGame.start(ladder, names);
		ResultsBoard resultsBoard = ladderGame.makeResultsBoard(names, results);

		boolean all = false;
		while (all == false) {
			ResultName resultName = new ResultName(names, InputView.inputResultName());
			ResultView.printGameResult(resultsBoard, resultName);
			all = resultName.isAll();
		}
	}
}
