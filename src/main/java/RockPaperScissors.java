package main.java;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random ran = new Random();

		ChoiceValues chosenValue = parseEntry(keyboard);
		while (chosenValue != null) {
			runGame(ran, chosenValue);
			chosenValue = parseEntry(keyboard);
		}
		keyboard.close();
	}

	private static void runGame(Random ran, ChoiceValues chosenValue) {
		ChoiceValues computerChoice = ChoiceValues.values()[ran.nextInt(3)];
		Choice userChoice = initializeChoice(chosenValue);

		switch (userChoice.compareTo(computerChoice)) {
		case -1:
			System.out.println("you lose, " + computerChoice + " beats your " + chosenValue);
			break;
		case 0:
			System.out.println("tie, you both chose " + computerChoice);
			break;
		case 1:
			System.out.println("you win, " + chosenValue + " beats " + computerChoice);
			break;
		}
	}

	private static Choice initializeChoice(ChoiceValues chosenValue) {
		if (chosenValue.equals(ChoiceValues.ROCK))
			return new Rock();
		if (chosenValue.equals(ChoiceValues.PAPER))
			return new Paper();
		if (chosenValue.equals(ChoiceValues.SCISSORS))
			return new Scissors();
		return null;
	}

	private static ChoiceValues parseEntry(Scanner keyboard) {
		System.out.println("enter ROCK/PAPER/SCISSORS/QUIT");
		String inputString = keyboard.next();
		ChoiceValues choiceValue = null;
		try {
			choiceValue = ChoiceValues.valueOf(inputString);
		} catch (IllegalArgumentException iae) {
			if (inputString.equalsIgnoreCase("QUIT"))
				return null;
			System.out.println("Invalid value: " + inputString);
			return parseEntry(keyboard);
		}
		return choiceValue;
	}
}
