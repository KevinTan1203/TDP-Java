
/* Practice 2.2 Dice Game, but OOP

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
*/

package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class App {
	// Variables and Types
	/*
	 * This is a variable declaration. The variable is called
	 * and output is shown below
	 */
	static int secretOfLife = 10;
	static short moneyInBalance = 100;
	static long distanceToSun = 149600000L;
	static float pi = 3.14f;
	static String name = "John Doe";
	static char grade = 'A';
	static boolean alwaysTrue = true;
	static double distanceToMoon = 238855.0;

	// Arrays
	/*
	 * Arrays can only store a finite amount of values
	 * aka elements. The size of the array is fixed
	 * It can only store one datatype and the indexing
	 * starts from 0
	 */
	static int[] numbers = { 1, 2, 3 };

	// ArrayList
	static ArrayList<Integer> numbersList = new ArrayList<Integer>();

	// Map
	/*
	 * Define the data type of the key and value
	 * Hashmap is a specific type of map. Map can be thought of as a generic version
	 * of a hashmap
	 * Note: When using generic collections, the data type of the key and value must
	 * be the class equivalent of the primitive data type
	 */
	static Map<String, Integer> months = new HashMap<String, Integer>();

	public static void main(String[] args) {
		// Variables and Types
		System.out.println("Hello World!");
		System.out.println("int = " + secretOfLife);
		System.out.println("short = " + moneyInBalance);
		System.out.println("long = " + distanceToSun);
		System.out.println("float = " + pi);
		System.out.println("String = " + name);
		System.out.println("char = " + grade);
		System.out.println("boolean = " + alwaysTrue);
		System.out.println("double = " + distanceToMoon);

		// Calling the array
		System.out.println("numbers = " + numbers);
		System.out.println("numbers[0] = " + numbers[0]);
		System.out.println("numbers[1] = " + numbers[1]);
		System.out.println("numbers[2] = " + numbers[2]);

		// Accessing the ArrayList
		numbersList.add(111);
		numbersList.add(222);
		numbersList.add(333);
		System.out.println("numbersList = " + numbersList);
		System.out.println("numbersList get first element = " + numbersList.get(0));
		System.out.println("numbersList get second element = " + numbersList.get(1));
		System.out.println("numbersList get third element = " + numbersList.get(2));

		// Map
		months.put("January", 31);
		months.put("February", 28);
		months.put("March", 31);
		months.put("April", 30);

		System.out.println("Number of days in January = " + months.get("January"));

		// Referencing a method
		System.out.println("isTrue() = " + isTrue());
		System.out.println("isFalse() = " + isFalse());
		System.out.println("greetings() = " + greetings("John Doe"));

		// Predefined (i.e non customed) methods
		String story = "A quick brown fox jumps over the lazy dog";
		System.out.println("Uppercase = " + story.toUpperCase());
		System.out.println("String contains = " + story.contains("fox"));
		System.out.println("Substring = " + story.substring(2, 7)); // Get 'quick' from the story

		// Custom methods
		System.out.println("add(2, 3) = " + add(2, 3));
		System.out.println("calculateGST(100, 0.06) = " + calculateGST(100, 0.06));
		System.out.println("calculatePerimeter(2, 3) = " + calculatePerimeter(2, 3));

		// Scanner class
		/*
		 * next() will only capture the input as string, and will treat spaces and
		 * enter
		 * as end of line
		 * To capture the entire line, use nextLine()
		 */
		Scanner sc = new Scanner(System.in); // sc is a variable that can store data from users
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		System.out.println("Enter your height in metres: ");
		double height = sc.nextDouble();
		System.out.println("Enter your weight in kg: ");
		double weight = sc.nextDouble();
		System.out.println(
				"Hello " + name + "! I see you are " + age + " years old. Your bmi is " +
						(weight / (height * height)));

		// Conditional Statements
		/*
		 * In java, we only use == for primitive values. So to compare objects like
		 * strings, we will use .equals()
		 */
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Please key in a number: ");
		int magicNumber = sc2.nextInt();
		if (magicNumber > 10) {
			System.out.println("Magic number is greater than 10");
		} else {
			System.out.println("Magic number is less than or equal to 10");
		}

		String text = "Java programming is fun!";
		String word = text.substring(5, 16);
		System.out.println(word);

		// For loops
		int value = 0;
		int sum = 10;
		for (int i = 0; i < sum; i++) {
			value += i;
		}
		System.out.println("Total Sum = " + value);

		statsCalc();

	}

	// Methods are functions that belongs to a class
	public static String greetings(String name) {
		return "Hello " + name;
	}

	// Method that takes in two integers and returns their sum
	public static int add(int a, int b) {
		return a + b;
	}

	public static double calculateGST(double amount, double gst) {
		return amount * gst;
	}

	public static int calculatePerimeter(int length, int width) {
		return 2 * (length + width);
	}

	public static boolean isTrue() {
		return true;
	}

	public static boolean isFalse() {
		return false;
	}

	public static void statsCalc() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			} else {
				numbers.add(num);
			}
		}

		// Calc the mean, median and mode
		double sum = 0.0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		double mean = sum / numbers.size();
		System.out.println("Mean = " + mean);

		// Median
		Collections.sort(numbers);
		double median = 0.0;
		if (numbers.size() % 2 == 0) {
			median = (numbers.get(numbers.size() / 2) + numbers.get((numbers.size() / 2) - 1)) / 2;
		} else {
			median = numbers.get(numbers.size() / 2);
		}

		System.out.println("Median = " + median);

		// Mode
		int mode = 0;
		int maxCount = 0;
		int currentCount = 0;

		for (int i = 0; i < numbers.size(); i++) {
			currentCount = 0;
			for (int j = 0; j < numbers.size(); j++) {
				if (numbers.get(j) == numbers.get(i)) {
					currentCount++;
				}
			}
			if (currentCount > maxCount) {
				maxCount = currentCount;
				mode = numbers.get(i);
			}
		}

		System.out.println("Mode = " + mode);

		// Find all possible modes
		Map<Integer, Integer> modeMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.size(); i++) {
			if (modeMap.containsKey(numbers.get(i))) {
				modeMap.put(numbers.get(i), modeMap.get(numbers.get(i)) + 1);
			} else {
				modeMap.put(numbers.get(i), 1);
			}
		}
		// Get all possible modes from hashmap
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : modeMap.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		ArrayList<Integer> modes = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : modeMap.entrySet()) {
			if (entry.getValue() == max) {
				modes.add(entry.getKey());
			}
		}
		System.out.println("All possible modes: " + modes);
	}
}
