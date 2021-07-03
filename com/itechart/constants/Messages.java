package com.itechart.constants;

public enum Messages {
  HELLO("Welcome to the Guesser game. The point of the game is to guess a random number."),
  GUIDE("Start guessing by entering numbers. Remember: you have only 10 attempts. \nMax number is 100! Good luck.");

  private String message;

  Messages(String msg) {
    this.message = msg;
  }

  @Override
  public String toString() {
    return message;
  }
}
