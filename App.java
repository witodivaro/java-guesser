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

        switch (guessResult) {
          case LOWER:
            System.out.println("Lower!");
            break;

          case HIGHER:
            System.out.println("Higher!");
            break;

          case EXACT:
            final int attempsTaken = ATTEMPTS_COUNT - guesser.getAttemptsCount();

            System.out.println(
              String.format("Congratulations, you won! It took you %d attempts. The number was %d.",
                attempsTaken, 
                guesser.getCurrentNumber()
              )
            );
            break;
        }

        int attemptsLeft = guesser.getAttemptsCount();

        if (guesser.getAttemptsCount() == 0) {
          System.out.println(
            String.format(
              "You are out of attempts :( The number was %d.",
              guesser.getCurrentNumber()
            )
          );
          break;
        } else {
          System.out.println(
            String.format(
              "You have %d attempt(s) left",
              attemptsLeft
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

