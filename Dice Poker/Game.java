package com.example;

/* 

--> Practice 2.2 Dice Game, but OOP

Game Rules
  The player has 5 tries (rounds) per game.
  In each try, the player rolls 5 dice.
  The player can choose to reroll any number of dice up to 3 times per round.
  After the final roll (or when the player is satisfied), the hand is evaluated and points are awarded based on the highest poker hand achieved.
  The goal is to accumulate as many points as possible over the 5 rounds.

Implementation Guidelines

1. Dice Rolling
  Use an array to represent the 5 dice.
  Implement a method to roll the dice (generate random numbers from 1 to 6).
  Think of how to display the dice to the user
  Allow the player to select which dice to reroll (up to 3 times per round).
  How will you ask the user which dice to reroll? (Hint: the dice are stored in an array).

2. Hand Evaluation
  Implement methods to check for different poker hands (e.g., Three of a Kind, Full House, etc.).
  Use conditional statements to determine the highest hand achieved.

3. Scoring
  Assign point values to each type of hand.
  Keep a running total of the player's score across all 5 rounds.

4. Game Flow
  Use a loop to manage the 5 rounds of the game.
  Within each round, use another loop to manage the up to 3 rerolls.
  Use conditional statements to check if the player wants to reroll or keep their current hand.

5. User Interface
  Display the current dice values after each roll.
  Prompt the player for input on which dice to reroll.
  Show the final hand and score for each round.
  Display the total score at the end of the game.
  
	Suggested Poker Hands and Points
  Five of a Kind: 50 points
  Four of a Kind: 40 points
  Full House: 30 points
  Straight: 25 points
  Three of a Kind: 20 points
  Two Pair: 15 points
  One Pair: 10 points
  High Card: 5 points


--> Practice 2.4 Advanced Gameplay

The game now has those expanded rules

There are now two types of dice: the normal dice and the jackpot dice.
Normal dices are six-sided dice, and have numbers from 1 to 6
Jackpot dices are eight-sided dice (that is, there are eight possible results when rolling one). Six sides are numerical, each showing 1 to 6. Two of the sides are jackpot. If they are part of the final throw, they grant 10 points each.
There are now two game modes: Standard and Jackpot
Standard Mode: Players will roll four normal dice and one jackpot dice. All the other rules are the same
Jackpot Mode: Players will roll three normal dice and three jackpot dice. The players only have five rerolls for the entire game, instead of having three rerolls per round.

When the user begins a game, they will choose which game mode they want to play in. Hint: it's easier to implement this if you already have a Game class with different methods representing the different processes of the game.

--> Practise 2.6 Cards and Dice
The client now requests a third game mode: Card and Dice. Here are the rules for this mode:


Players will draw three playing cards and roll 3 normal dice
Players can choose to redraw a card, or to reroll a dice, up to three times in the entire game (not each round)
Kings, Queens and Knaves are considered as 10.
If the sum of all the numbers (card + dice) is above 49 after a reroll, the player loses the round immediately (i.e, no chance to reroll)
If there is at least two black cards (spades and clubs), double the score
*/

import java.util.*;

import com.example.Card.Rank;
import com.example.Card.Suit;

class Dice {
	private int sides, diceId, value;
	private Random random;

	public Dice(int sides, int diceId) {
		if (sides <= 0) {
			throw new IllegalArgumentException("Number of sides must be greater than 0.");
		}
		this.sides = sides;
		this.diceId = diceId;
		this.value = 0;
		this.random = new Random();
	}

	public int roll() {
		this.value = random.nextInt(this.sides) + 1;
		return this.value;
	}

	public int getValue() {
		return this.value;
	}

	public int getSides() {
		return this.sides;
	}

	public int getDiceId() {
		return this.diceId;
	}

	public void resetValue() {
		this.value = 0;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

/*
 * This normal dice is a 6-sided die with numbers from 1 to 6
 */
class NormalDice extends Dice {
	public NormalDice(int diceId) {
		super(6, diceId); // Normal dice has 6 sides
	}
}

/*
 * Jackpot dices are eight-sided dice (that is, there are eight possible results
 * when rolling one). Six sides are numerical, each showing 1 to 6. Two of the
 * sides are jackpot. If they are part of the final throw, they grant 10 points
 * each.
 */
class JackpotDice extends Dice {
	private static final int JACKPOT_VALUE = 10;
	private boolean finalThrow = false;

	public JackpotDice(int diceId) {
		super(8, diceId); // Jackpot dice has 8 sides
	}

	@Override
	public int roll() {
		int value = super.roll(); // Roll using the parent class's roll method
		if (value > 6) { // If the value is 7 or 8, it's a jackpot
			System.out.println("Jackpot rolled on dice " + getDiceId() + "!");
			return finalThrow ? JACKPOT_VALUE : value; // Jackpot is worth 10 points on final throw
		}
		return value;
	}
}

class Card {
	private final Suit suit;
	private final Rank rank;

	public enum Suit {
		HEARTS, DIAMONDS, CLUBS, SPADES
	}

	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
}

public class Game {
	private static final int NUM_ROUNDS = 5;
	private static final int MAX_REROLLS_STANDARD = 3;
	private int MAX_REROLLS_JACKPOT = 5;
	private int MAX_REROLLS_CARD_AND_DICE = 3;
	private String GAME_MODE;

	private int totalScore;
	private List<Dice> diceList;
	private List<Card> cardList;
	private Scanner scanner;

	public Game() {
		this.totalScore = 0;
		this.scanner = new Scanner(System.in);
		this.GAME_MODE = "N/A";
	}

	public void playGame() {
		System.out.println("Welcome to Dice Game!");

		/*
		 * Expanding the game to include two game modes: Standard and Jackpot
		 * The user will have the option to choose either one when starting the game
		 */
		System.out.println("Choose a game mode: 1 - Standard Mode, 2 - Jackpot Mode, 3 - Card and Dice Mode");
		int choice = scanner.nextInt();

		if (choice == 1) {
			/*
			 * Players will roll four normal dice and one jackpot dice. All the other rules
			 * are the same
			 */
			this.GAME_MODE = "Standard";
			this.standardMode();
		} else if (choice == 2) {
			/*
			 * Players will roll three normal dice and three jackpot dice. The players only
			 * have five rerolls for the entire game, instead of having three rerolls per
			 * round.
			 */
			this.GAME_MODE = "Jackpot";
			this.jackpotMode();
		} else if (choice == 3) {
			/*
			 * Players will draw three playing cards and roll 3 normal dice Players can
			 * choose to redraw a card, or to reroll a dice, up to three times in the entire
			 * game (not each round) Kings, Queens and Knaves are considered as 10. If the
			 * sum of all the numbers (card + dice) is above 49 after a reroll, the player
			 * loses the round immediately (i.e, no chance to reroll) If there is at least
			 * two black cards (spades and clubs), double the score
			 */
			this.GAME_MODE = "Card and Dice";
			this.cardAndDiceMode();
		} else {
			System.out.println("Invalid choice. Exiting game.");
		}
	}

	// Standard Mode: 4 Normal Dice and 1 Jackpot Dice, 3 rerolls per round
	public void standardMode() {
		System.out.println("Playing in Standard Mode.");
		diceList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			diceList.add(new NormalDice(i));
		}
		diceList.add(new JackpotDice(4)); // 1 Jackpot dice

		for (int round = 1; round <= NUM_ROUNDS; round++) {
			this.playRound(MAX_REROLLS_STANDARD);
		}

		System.out.println("Total score after " + NUM_ROUNDS + " rounds: " + totalScore);
	}

	// Jackpot Mode: 3 Normal Dice and 3 Jackpot Dice, 5 rerolls total
	public void jackpotMode() {
		System.out.println("Playing in Jackpot Mode.");
		diceList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			diceList.add(new NormalDice(i));
		}
		for (int i = 3; i < 6; i++) {
			diceList.add(new JackpotDice(i));
		}

		for (int round = 1; round <= NUM_ROUNDS; round++) {
			this.playRound(MAX_REROLLS_JACKPOT); // In Jackpot Mode, rerolls are shared across rounds
		}

		System.out.println("Total score after " + NUM_ROUNDS + " rounds: " + totalScore);
	}

	// Card and Dice Mode: 3 Cards and 3 Normal Dice, 3 rerolls total
	public void cardAndDiceMode() {
		System.out.println("Playing in Card and Dice Mode.");
		diceList = new ArrayList<>();
		cardList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			diceList.add(new NormalDice(i));
		}
		for (int i = 0; i < 3; i++) {
			cardList.add(new Card(this.generateRandomSuit(), this.generateRandomRank()));
		}

		for (int round = 1; round <= NUM_ROUNDS; round++) {
			this.playRound(MAX_REROLLS_CARD_AND_DICE);
		}

		System.out.println("Total score after " + NUM_ROUNDS + " rounds: " + totalScore);
	}

	// Plays a single round of the game
	public void playRound(int rerolls) {
		System.out.println("\n--- New Round ---");
		// Check if the game mode is Card and Dice
		if (GAME_MODE.equals("Card and Dice")) {
			this.rollAllDice(); // Roll the dice
			this.drawCards(); // Draw the cards
		} else {
			this.rollAllDice();
		}

		while (rerolls > 0) {
			if (GAME_MODE.equals("Card and Dice")) {
				this.displayCards();
				this.displayDice();
			} else {
				this.displayDice();
			}
			System.out.println("You have " + rerolls + " rerolls left.");
			System.out
					.println("Enter dice / card positions to reroll / redraw (separated by spaces) or 'done' to continue: ");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("done")) {
				break;
			}

			// Handle the case for drawing of cards in Card and Dice mode
			if (this.GAME_MODE.equals("Card and Dice")
					&& ((input.contains("3") || input.contains("4") || input.contains("5")))) {
				int validRedraws = this.redrawCards(input);
				if (validRedraws > 0) {
					rerolls--;
				}
			}

			// General rerolling of dice
			int validRerolls = this.rerollDice(input);
			if (validRerolls > 0) {
				rerolls--;
			}
		}

		int roundScore = this.evaluateHand();
		System.out.println("Round score: " + roundScore);
		totalScore += roundScore;

		if (GAME_MODE.equals("Jackpot")) {
			this.MAX_REROLLS_JACKPOT = rerolls; // Update rerolls left for Jackpot Mode
		}
	}

	// Method to roll all dice (normal or jackpot)
	public void rollAllDice() {
		for (Dice die : diceList) {
			die.roll();
		}
	}

	// Method to draw cards (3 for the current game play)
	public void drawCards() {
		this.cardList.clear(); // Remove preexisting cards
		for (int i = 0; i < 3; i++) {
			cardList.add(new Card(this.generateRandomSuit(), this.generateRandomRank()));
		}
	}

	// Method to display the dice to the user
	public void displayDice() {
		System.out.print("Current dice: ");
		for (int i = 0; i < diceList.size(); i++) {
			System.out.print("[" + i + "]: " + diceList.get(i) + " ");
		}
		System.out.println();
	}

	// Method to display the cards to the user
	public void displayCards() {
		System.out.print("Current cards: ");
		for (int i = 0; i < cardList.size(); i++) {
			System.out.print("[" + i + "]: " + cardList.get(i) + " ");
		}
		System.out.println();
	}

	// Method to handle redrawing of cards
	public int redrawCards(String input) {
		String[] positions = input.split(" ");
		int validRerolls = 0;
		for (String pos : positions) {
			try {
				int cardIndex = Integer.parseInt(pos.trim());
				if (cardIndex >= 0 && cardIndex < cardList.size()) {
					cardList.set(cardIndex, new Card(this.generateRandomSuit(), this.generateRandomRank()));
					validRerolls++;
				} else {
					System.out.println("Invalid card position: " + pos);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input: " + pos);
			}
		}

		return validRerolls;
	}

	// Method to handle rerolling of dice
	public int rerollDice(String input) {
		String[] positions = input.split(" ");
		int validRerolls = 0;

		for (String pos : positions) {
			try {
				int diceIndex = Integer.parseInt(pos.trim());
				if (diceIndex >= 0 && diceIndex < diceList.size()) {
					diceList.get(diceIndex).roll();
					validRerolls++;
				} else {
					System.out.println("Invalid dice position: " + pos);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input: " + pos);
			}
		}
		return validRerolls;
	}

	// Generates a random card with a random suit
	public Suit generateRandomSuit() {
		Random random = new Random();
		int suitIndex = random.nextInt(Card.Suit.values().length);
		return Card.Suit.values()[suitIndex];
	}

	// Generates a random card with a random rank
	public Rank generateRandomRank() {
		Random random = new Random();
		int rankIndex = random.nextInt(Card.Rank.values().length);
		return Card.Rank.values()[rankIndex];
	}

	// Method that evaluates the hand and returns the score based on the poker hand
	public int evaluateCardScore(Suit suit, Rank rank) {
		int value = 0;
		switch (rank) {
			case ACE:
				value = 1;
				break;
			case TWO:
				value = 2;
				break;
			case THREE:
				value = 3;
				break;
			case FOUR:
				value = 4;
				break;
			case FIVE:
				value = 5;
				break;
			case SIX:
				value = 6;
				break;
			case SEVEN:
				value = 7;
				break;
			case EIGHT:
				value = 8;
				break;
			case NINE:
				value = 9;
				break;
			case TEN:
			case JACK:
			case QUEEN:
			case KING:
				value = 10;
				break;
		}
		return value;
	}

	public int evaluateHand() {
		Map<Integer, Integer> counts = new HashMap<>();

		for (Dice die : diceList) {
			counts.put(die.getValue(), counts.getOrDefault(die.getValue(), 0) + 1);
		}

		boolean threeOfAKind = false;
		boolean fourOfAKind = false;
		boolean twoPair = false;
		boolean onePair = false;

		for (int count : counts.values()) {
			if (count == 5) {
				return 50; // Five of a Kind
			} else if (count == 4) {
				fourOfAKind = true;
			} else if (count == 3) {
				threeOfAKind = true;
			} else if (count == 2) {
				if (onePair) {
					twoPair = true;
				} else {
					onePair = true;
				}
			}
		}

		if (this.hasConsecutiveNumbers()) {
			return 25; // Straight
		}
		if (fourOfAKind)
			return 40; // Four of a Kind
		if (threeOfAKind && onePair)
			return 30; // Full House
		if (threeOfAKind)
			return 20; // Three of a Kind
		if (twoPair)
			return 15; // Two Pair
		if (onePair)
			return 10; // One Pair
		return 5; // High Card
	}

	public boolean hasConsecutiveNumbers() {
		int[] values = new int[diceList.size()];
		for (int i = 0; i < diceList.size(); i++) {
			values[i] = diceList.get(i).getValue();
		}

		Arrays.sort(values);
		for (int i = 0; i < values.length - 1; i++) {
			if (values[i] + 1 != values[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.playGame();
	}
}
