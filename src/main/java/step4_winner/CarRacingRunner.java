package step4_winner;

import lombok.RequiredArgsConstructor;
import step4_winner.domain.Car;
import step4_winner.view.InputView;
import step4_winner.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarRacingRunner {
    private final InputView inputView;
    private final ResultView resultView;

    private void Prepare(){
        String carNamesWithComma = inputView.getCarNamesWithComma();
        int numberOfTries = inputView.getNumberOfRounds();
        List<Car> cars = Arrays.stream(carNamesWithComma.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
