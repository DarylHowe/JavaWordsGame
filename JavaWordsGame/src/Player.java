/**
 * Player - an instantiable class to hold hold a player information such as:
 * The number of lives a player has. 
 * A player's score for a single game.
 * A player's score for the entire game.
 * The number of games a player has won.
 * Is the player currently playing/active. 
 */

public class Player {
	
	// instance variables
	private int playerLives;
	private int playerScore = 0;
	private int totalPlayerScore = 0;
	private boolean isCurrentlyPlaying = false;
	private int numberOfGamesWon = 0;
	private String currentWord;
		
	
	/**
	 * A constructor for a Player
	 * @param playerLives	the number of lives a player has remaining 
	 * @param playerScore 	the current score of the player
	 */
	public Player(int playerLives, int playerScore) {
		this.playerLives = playerLives;
		this.playerScore = playerScore;
	}
	
	
	/**
	 * A method to add to the players score. 
	 * @param points	The number of points to add to the player's score. 
	 */
	public void addPointsToPlayerScore(int points) {
		playerScore = playerScore + points;	
	}
	
	
	/**
	 * A method to deduct a life from the player. 
	 */
	public void deductlife() {
		playerLives = playerLives -1;
	}
	
	
	/**
	 * A method to increment the number of games won by a player by 1. 
	 */
	public void incrementNumberOfGamesWon() {
		numberOfGamesWon = numberOfGamesWon +1;
	}
	
	
	// Setters & Getters
	
	public void setPlayerLives(int playerLives) {
		this.playerLives = playerLives;
	}
	
	public int getPlayerLives() {
		return playerLives;
	}
	
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;	
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public void setIsCurrentlyPlaying(boolean isCurrentlyPlaying) {
		this.isCurrentlyPlaying = isCurrentlyPlaying;
	}
	
	public boolean getIsCurrentlyPlaying() {
		return isCurrentlyPlaying;
	}

	public int getNumberOfGamesWon() {
		return numberOfGamesWon;
	}
	
	public void setTotalPlayerScore(int totalPlayerScore) {
		this.totalPlayerScore = totalPlayerScore;
	}
	
	public int getTotalPlayerScore() {
		return totalPlayerScore;
	}
	
	public String getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}
	
	
	

	
	
}
