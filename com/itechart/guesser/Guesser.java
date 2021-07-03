package com.itechart.guesser;

public class Guesser {
  public int currentNumber;
  private int attemptsCount = 0;
  private GameState state;

  public void generateRandomNumber(int max) {
    currentNumber = (int) Math.floor(Math.random() * max);
  }

  public GuessResults guess(int number) {
    if (state == GameState.IDLE) {
      return GuessResults.EXACT;
    }

    if (attemptsCount == 0) {
      state = GameState.IDLE;
      return GuessResults.NO_ATTEMPTS;
    }

    attemptsCount -= 1;

    if (currentNumber == number) {
      state = GameState.IDLE;
      return GuessResults.EXACT;
    } else if (currentNumber < number) {
      return GuessResults.LOWER;
    } else {
      return GuessResults.HIGHER;
    }
  }

  public void startGame(int attempts) {
    state = GameState.STARTED;
    attemptsCount = attempts;
  }

  public int getAttemptsCount() {
    return attemptsCount;
  }

  public int getCurrentNumber() {
    return currentNumber;
  }

  public GameState getGameState() {
    return state;
  }
}
