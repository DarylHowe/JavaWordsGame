/**
 * DuplicateVowelCounter - An instantiable class which calculates the number of duplicate vowels in a word: 
 * Example // "Moon" = 2 duplicate vowels, "Cheerleader" = 4 duplicate vowels, "Answer" = 0 duplicate vowels
 */

public class DuplicateVowelCounter {

	// instance variables
	private String chosenWord;
	private int chosenWordLength;
	
	private char character;
	
	private int aCount = 0 ;
	private int eCount = 0 ;
	private int iCount = 0 ;
	private int oCount = 0 ;
	private int uCount = 0 ;
	
	private int totalDuplicateVowels =0;

	
	/**
	 * A constructor for PointsAwardee.
	 * @param chosenWord	
	 */
	public DuplicateVowelCounter(String chosenWord) {
		this.chosenWord = chosenWord;
	}
	
	public DuplicateVowelCounter() {
	}

	
	/**
	 * A method to calculate the number of duplicated vowels in a word. 
	 * @return	The total number of duplicated vowels in a word. 
	 */
	public int calculatePoints() {
		
		// Remove any white space and start and end of word. 
		// Convert the word to lower case. 
		chosenWord = chosenWord.trim();
		chosenWord = chosenWord.toLowerCase();
		
		// Get the length of the word.
		chosenWordLength = chosenWord.length();
		
		// Traverse the word.
		for(int i = 0; i < chosenWordLength; i++) {
			
			// Get the character at each index of the word.
			character = chosenWord.charAt(i);
			
			// If the character is.. 
			switch(character) {
			
			// a, increment aCount by 1. 
			case 'a':
				aCount++;
				break;
				
			case 'e':
				eCount++;
				break;
				
			case 'i':
				iCount++;
				break;
				
			case 'o':
				oCount++;
				break;
				
			case 'u':
				uCount++;
				break;				
			}
		}
		
		// If their is 2 or more 'a' vowels in the word.. 
		if(aCount >= 2) {
			
			// Add the amount to 'totalPointsToAward'.
			totalDuplicateVowels += aCount; 
		}
		
		if(eCount >= 2) {
			totalDuplicateVowels += eCount; 
		}
		
		if(iCount >= 2) {
			totalDuplicateVowels += iCount; 
		}
		
		if(oCount >= 2) {
			totalDuplicateVowels += oCount; 
		}
		
		if(uCount >= 2) {
			totalDuplicateVowels += uCount; 
		}

		
		// Return the total amount of duplicated vowels. 
		return totalDuplicateVowels;
	}

	
	
}
