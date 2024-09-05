package com.example;

import java.util.*;

class Dice {
  private int diceId, diceValue;

  public Dice(int diceId) {
    this.diceValue = 0;
    this.diceId = diceId;
  }

  public void rollDice() {
    this.diceValue = (int) (Math.random() * 6) + 1;
  }

  public int getDiceValue() {
    return this.diceValue;
  }

  public int getDiceId() {
    return this.diceId;
  }
}

public class Game {
  private String userName; // Used to store a user
  private int noOfRounds; // Number of rounds the user has played
  private int userScore; // Total score of user
  private int[] roundScores; // Scores for each round compiled into an array
  private Map<Integer, Dice> userDice; // Tracker for user dice
  private Map<Integer, Integer> diceValueTracker; // Tracker for dice values
  private int diceRerollTracker; // Tracker for number of dice rolled per round

  // Test run the dice game
  public static void main(String[] args) {
    System.out.println("Welcome to the Dice Game!\n\n");
    // Instatiating the game

    System.out.println("Creating a new user called Paul!\n");
    Game henryGame = new Game("Paul");

    // Check the initial state of the game
    System.out.println("Initial state of the game: ");
    System.out.println(henryGame.getStatistics());

    // Play the game
    System.out.println("Playing the game...\n");
    henryGame.nextRound();

    // Check the state of the game after playing
    System.out.println("State of the game after playing: \n");
    System.out.println(henryGame.getStatistics());

    // Player to initiate rerolling of dice
    // Try a diceID that does not exist
    henryGame.rerollDice(7); // Should throw the exception
    henryGame.rerollDice(3); // Should reroll dice 3
    henryGame.rerollDice(2); // Should reroll dice 2

    // Check the state of the game after rerolling
    System.out.println("State of the game after rerolling: \n");
    System.out.println(henryGame.getStatistics());

    // Advance to the next game, which rolls all 5 dice
    henryGame.nextRound();

    // Check the state of the game after playing
    System.out.println("State of the game after playing: \n");
    System.out.println(henryGame.getStatistics());
  }

  // Default constructor
  public Game() {
    this.userName = "Unknown User";
    this.noOfRounds = 0;
    this.userScore = 0;
    this.roundScores = new int[5]; // Holds the score for users in each of the 5 rounds
    this.userDice = new HashMap<Integer, Dice>();
    this.diceValueTracker = new HashMap<>();

    for (int id = 0; id < 5; id++) {
      this.userDice.put(id, new Dice(id));
      this.diceValueTracker.put(id, 0);
    }

    this.diceRerollTracker = 0; // Initial value for number of dice rolled.
  }

  // Overloaded constructor
  public Game(String usernmae) {
    this.userName = usernmae;
    this.noOfRounds = 0;
    this.userScore = 0;
    this.roundScores = new int[5]; // Holds the score for users in each of the 5 rounds
    this.userDice = new HashMap<Integer, Dice>();
    this.diceValueTracker = new HashMap<>();

    for (int id = 0; id < 5; id++) {
      this.userDice.put(id, new Dice(id));
      this.diceValueTracker.put(id, 0);
    }

    this.diceRerollTracker = 0; // Initial value for number of dice rolled.
  }

  // Basic getter methods
  public String getUsername() {
    return this.userName;
  }

  public int getNoOfRounds() {
    return this.noOfRounds;
  }

  public int getUserScore() {
    return this.userScore;
  }

  public Map<Integer, Integer> getDiceValueTracker() {
    return this.diceValueTracker;
  }

  public int getDiceRerollTracker() {
    return this.diceRerollTracker;
  }

  public String getStatistics() {
    return "Username: " + this.getUsername() + "\n" + "Round Number: " + this.getNoOfRounds() + "\n"
        + "User Current Score: " + this.getUserScore() + "\n" + "No of Rolls Made in Current Round: "
        + this.getDiceRerollTracker() + "\n" + "Round Scores: " + Arrays.toString(this.roundScores);
  }

  // Advance to the next round
  public void nextRound() {
    if (this.noOfRounds > 3) {
      // Tabulate final score and display it
      this.roundScores[this.noOfRounds] = this.userScore;
      System.out.println("Game Over! Your final score is: " + this.roundScores);
    } else {
      /*
       * If this is not the end of the game, proceed to the next round and roll all
       * dice. Reset the reroll tracker to 0 and increment the number of rounds by 1
       */

      // Tabulate the current round score
      this.roundScores[this.noOfRounds] = this.userScore;
      this.userScore = 0;

      // Reset and update the tracker
      this.noOfRounds += 1;
      this.diceRerollTracker = 0;
      for (int id = 0; id < 5; id++) {
        Dice dice = this.userDice.get(id);
        dice.rollDice();

        // Update the dice value tracker
        this.diceValueTracker.put(id, dice.getDiceValue());
      }

      // Tabulate the new round score
      for (int id = 0; id < 5; id++) {
        this.userScore += this.diceValueTracker.get(id);
      }
    }
  }

  // Reroll option for the current round by user
  public void rerollDice(int diceId) {
    if (this.diceRerollTracker > 3) {
      System.out.println("You have reached the maximum number of rerolls for this round");
    } else if (diceId < 0 || diceId > 6) {
      System.out.println("Invalid dice id. Please select a dice id between 1 and 6");
    } else {
      Dice selectedDice = this.userDice.get(diceId);
      selectedDice.rollDice();

      // Update the dice value tracker and total round score
      this.userScore -= this.diceValueTracker.get(diceId);
      this.diceValueTracker.put(diceId, selectedDice.getDiceValue());
      this.userScore += this.diceValueTracker.get(diceId);
      this.diceRerollTracker += 1;
      System.out
          .println("You have chosen to reroll dice " + diceId + ". Rerolls made " + this.getDiceRerollTracker() + "/3");
    }
  }
}
