import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.itechart.guesser.*;
import com.itechart.constants.*;

public class App {
  public static void main(String[] args) {
    Guesser guesser = new Guesser();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int MAX_GAME_NUMBER = 100;
    int ATTEMPTS_COUNT = 10;
    int currentGuess;

    guesser.generateRandomNumber(MAX_GAME_NUMBER);

    guesser.startGame(ATTEMPTS_COUNT);
    System.out.println(Messages.HELLO);
    System.out.println(Messages.GUIDE);

    do {
      try {
        currentGuess = Integer.parseInt(reader.readLine());

        GuessResults guessResult = guesser.guess(currentGuess);

        if (guessResult == GuessResults.NO_ATTEMPTS) {
          System.out.println(
            String.format(
              "You are out of attempts :( The number was %d.",
              guesser.getCurrentNumber()
            )
          );
        } else if (guessResult == GuessResults.LOWER) {
          System.out.println("Lower!");
        } else if (guessResult == GuessResults.HIGHER) {
          System.out.println("Higher!");
        } else if (guessResult == GuessResults.EXACT) {
          final int attempsTaken = ATTEMPTS_COUNT - guesser.getAttemptsCount();

          System.out.println(
            String.format("Congratulations, you won! It took you %d attempts. The number was %d.",
              attempsTaken, 
              guesser.getCurrentNumber()
            )
          );
        }
      } catch (IOException e) {
        System.out.println(e);
      }
    } while (guesser.getGameState() != GameState.IDLE);

    System.out.println("Script exit..");
  }
}
