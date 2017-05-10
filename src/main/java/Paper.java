package main.java;

public class Paper extends Choice {

	@Override
	public int compareTo(ChoiceValues choice) {
		if (choice.equals(ChoiceValues.SCISSORS))
			return -1;
		if (choice.equals(ChoiceValues.ROCK))
			return 1;
		return 0;
	}

}
