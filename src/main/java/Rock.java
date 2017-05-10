package main.java;

public class Rock extends Choice {

	@Override
	public int compareTo(ChoiceValues choice) {
		if (choice.equals(ChoiceValues.PAPER))
			return -1;
		if (choice.equals(ChoiceValues.SCISSORS))
			return 1;
		return 0;
	}

}
