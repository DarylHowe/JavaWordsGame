/**
 * RandomLetter - An instantiable class which randomly selects a letter of the English alphabet.  
 */

import java.util.Random;

public class RandomLetter {

	// instance variables
	private char randomLetter;
	char[] letterArray = "ABCDEFGHIJKLMNOPQRSTUVWQXZ".toCharArray();

	/**
	 * A constructor for RandomLetter.
	 */
	public RandomLetter() {
	}
	
	
	/**
	 * A method to generate and return a random letter from the alphabet.
	 * @return	a randomly selected character from the alphabet.
	 */
	public char generateRandomLetter(){
		int randomNumber;
		Random rand = new Random();
		randomNumber = rand.nextInt(26);
		randomLetter = letterArray[randomNumber];
		return randomLetter;
	}
	
}
