package main.java;

public class Scissors extends Choice {

	@Override
	public int compareTo(ChoiceValues choice) {
		if (choice.equals(ChoiceValues.ROCK))
			return -1;
		if (choice.equals(ChoiceValues.PAPER))
			return 1;
		return 0;
	}

}
