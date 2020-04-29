/**
 * 
 * GameManager - A class that keeps track of the game. 
 */


public class GameManager {

	private int currentGameNumber = 1;
	private int currentRoundnumber = 1;
	private int totalGamesLeftToPlay;
	
	Player player01;
	Player player02;
		
	DuplicateVowelCounter duplicateVowelCounter;
	

	
	/**
	 * A constructor for the GameManager class. When created the GameManager will created two Player objects.
	 * @param playerLives	The number of lives each player begin with at the start of the first game.  
	 * @param playerScore	The score each player will begin at (usually 0). 
	 */
	public GameManager(int playerLives, int playerScore) {
		
		// create player01 and player02 with 4 lives and 0 points
		player01 = new Player(playerLives, playerScore);
		player02 = new Player(playerLives, playerScore);
	}
	
	
	/**
	 * A method determine how many points if any, is to be awarded the the active player. 
	 * @param word	A word
	 */
	public void awardPointsIfNecessary(String word) {
		
		int pointsToAward;
		
		// Calculate the number of duplicated vowels in a word.
		duplicateVowelCounter = new DuplicateVowelCounter(word);
		pointsToAward = duplicateVowelCounter.calculatePoints();
		
		// If the word has more than 1 of the same vowel..
		if (pointsToAward > 1) {

			// If player01 is currently active
			if (player01.getIsCurrentlyPlaying()) {

				// Add points to player01 score and display message.
				player01.addPointsToPlayerScore(pointsToAward);
				System.out.println("Player 01 receives " + pointsToAward + " points for the word '" + word + "' as it contains " + pointsToAward + " duplicated vowels. Well done!");
				System.out.println("Player 01 Score: " + player01.getPlayerScore());

				// If player02 is currently active.
			} else {

				// Add points to player02 score and display message.
				player02.addPointsToPlayerScore(pointsToAward);
				System.out.println("Player 02 receives " + pointsToAward + " points for the word '" + word + "' as it contains " + pointsToAward + " duplicated vowels. Well done!");
				System.out.println("Player 02 Score: " + player02.getPlayerScore());
			}
			
			// If the word has no duplicated vowels..
		} else {
			
			// If player01 is currently active..
			if(player01.getIsCurrentlyPlaying()) {
				
				// Display message.
				System.out.println("Player 01 receives no points for the word '" + word + "' as it contains no duplicated vowels!");

				// If player02 is currently active..
			}else {
				
				// Display message.
				System.out.println("Player 02 receives no points for the word '" + word + "' as it contains no duplicated vowels!");
			}
		}
	}
	

	/**
	 * A method which is called when all the lives of a player have been lost. 
	 */
	public void allPlayerLivesAreGone() {
		
		// If player01 has 0 lives..
		if(player01.getPlayerLives() == 0){
			
			// Invoke.
			player02.incrementNumberOfGamesWon();
			
			// Display message.
			System.out.println("Player 01 has no more lives left.");
			System.out.println("------------------------");
			System.out.println("");
			System.out.println("Player 02 wins the game!");
			System.out.println("Well done Player 02!");
			System.out.println("");
			System.out.println("------------------------");

			// If player02 has 0 lives..
		} else {
			
			player01.incrementNumberOfGamesWon();

			System.out.println("Player 02 has no more lives left.");
			System.out.println("------------------------");
			System.out.println("");
			System.out.println("Player 01 wins the game!");
			System.out.println("Well done Player 01!");
			System.out.println("");
			System.out.println("------------------------");
		}		
	}
	
	
	
	
	/**
	 * A method to set a players current word. 
	 * @param currentActivePlayer	A string stating which player is currently active. 
	 * @param word					The string to be set as the players current word.
	 */
	public void setCurrentPlayerWord(String currentActivePlayer, String word) {
		
		if(currentActivePlayer.equals("Player 01: ")) {
			
			player01.setCurrentWord(word);
		}else {
			
			player02.setCurrentWord(word);
		}
		
	}
	
	
	/**
	 * A method to set which player which is currently active. Note two players cannot be active at once. 
	 * @param 	player02IsActive	A boolean where if true player 02 is set as active	
	 */	
	public void setPlayerActiveStates(boolean player02IsActive) {

		// If player01 is active ..
		if (player02IsActive == false) {

			// Set player01 as active
			// Set player01 as not active
			player01.setIsCurrentlyPlaying(true);
			player02.setIsCurrentlyPlaying(false);
		} else {

			player01.setIsCurrentlyPlaying(false);
			player02.setIsCurrentlyPlaying(true);
		}
	}
	
	
	/**
	 * A method to get which player which player is currently active.
	 * @return	A string that states which player is currently active.
	 */
	public String getActivePlayer() {
		
		if(player01.getIsCurrentlyPlaying()){
			
			// Return what player is active as a string.
			return "Player 01: ";
		}else {
			
			return "Player 02: ";
		}
	}
	

	/**
	 * A method to switch which player is currently active and return . 
	 * @return	boolean
	 */
	public boolean switchPlayer() {
		
		// If player01 is currently active..
		if(player01.getIsCurrentlyPlaying()){
			
			player01.setIsCurrentlyPlaying(false);
			player02.setIsCurrentlyPlaying(true);
			return true;
			// If player02 is currently active..
		}else {
			
			player01.setIsCurrentlyPlaying(true);
			player02.setIsCurrentlyPlaying(false);
			return false;
		}
	}

	
	

	/**
	 * A method to be called when a round has been ended. 
	 */
	public void roundEnded() {
		
		// Deduct a life from the currently active player.
		// Increment the current round number by 1.
		deductLife();
		incrementCurrentRoundNumber();
		
		// Switch which player is now active. 
		switchPlayer();
	}
	
	
	/**
	 * A method to increment the current round number by 1.
	 */
	public void incrementCurrentRoundNumber() {
		
		currentRoundnumber = currentRoundnumber +1;
	}
	
	
	/**
	 * A method which deducts a life from the currently active player and checks to see if the player has any lives remaining. 
	 */
	public void deductLife() {
		
		// If player01 is currently active.. 
		if(player01.getIsCurrentlyPlaying()) {
			
			// Deduct a life.
			player01.deductlife();
			
			// Display message.
			System.out.println("Player 01 has lost a life!");
			System.out.println("Player 01 Lives Left: " + player01.getPlayerLives());
			
			// If all player 01's lives are lost..
			if(player01.getPlayerLives() == 0){
				
				// Invoke
				allPlayerLivesAreGone();
			}
			
			// If player02 is currently active.. 
		} else {
			
			player02.deductlife();
			System.out.println("Player 02 has lost a life!");
			System.out.println("Player 02 Lives Left: " + player02.getPlayerLives());
			
			if(player02.getPlayerLives() == 0){
				allPlayerLivesAreGone();
			}
		}
	}
	
	

	
	/**
	 * A method to reset the games variables after a single game has end.
	 * @param numberOfOpeningLives	sets the number of lives each player begins with at at the start of a new game. 
	 */
	public void singleGameOverReset(int numberOfOpeningLives) {
		
		// Increment the game number.
		// Reset the round number back to 1.
		currentGameNumber = currentGameNumber + 1;
		currentRoundnumber = 1;
		
		// Set the each total player score equal to their total score + their current score.
		player01.setTotalPlayerScore(player01.getTotalPlayerScore() + player01.getPlayerScore());
		player02.setTotalPlayerScore(player02.getTotalPlayerScore() + player02.getPlayerScore());

		// Reset the player score for next game.
		player01.setPlayerScore(0);
		player02.setPlayerScore(0);
		
		// reset the amount of lives each player has
		player01.setPlayerLives(numberOfOpeningLives);
		player02.setPlayerLives(numberOfOpeningLives);

		// -1 from the amount of games left to play
		totalGamesLeftToPlay = totalGamesLeftToPlay -1;
	}
	
	
	
	
	
	// Setters & Getters
	
	public void setTotalGamesLeftToPlay(int totalGamesLeftToPlay){
		this.totalGamesLeftToPlay = totalGamesLeftToPlay;
	}
	
	public int getTotalGamesLeftToPlay(){
		return totalGamesLeftToPlay;
	}
	
	public int getCurrentGameNumber() {
		return currentGameNumber;
	}
	
	public void setCurrentRoundnumber(int currentRoundnumber) {
		this.currentRoundnumber = currentRoundnumber;
	}
	
	public int getCurrentRoundNumber() {
		return currentRoundnumber;
	}
	

}
