package step4_winner;

import step4_winner.domain.Car;
import step4_winner.domain.Race;
import step4_winner.view.InputView;
import step4_winner.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class Step4Application {
    private Step4Application() {
        throw new UnsupportedOperationException("이 유틸 클래스는 인스턴스화할 수 없습니다.");
    }

    public static void main(String[] args) {
        // init
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();

        // input
        Race race = prepare(inputView);

        // result
        runRaces(race, resultView);
    }
    private static Race prepare(InputView inputView){
        String carNamesWithComma= inputView.getCarNamesWithComma();
        int numberOfTries = inputView.getNumberOfRounds();
        String[] carNames = carNamesWithComma.split(",");

        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Race(cars, numberOfTries);
    }

    private static void runRaces(
                                 Race race,
                                 ResultView resultView) {
        resultView.printResultHeader();
        for(int i = 0; i < race.getTries(); i++) {
            race.runRound();
            resultView.displayRaceResult(race.getCars());
        }
        resultView.printFinalWinner(race.getCars());
    }
}
