/**
 * Java Words Game - A 2 player turn based game where each player enters words given a set of pre defined rules. 
 @author Daryl Howe
 */

import java.util.Scanner;

public class JavaWordsGameApp {

	public static void main(String[] args) {

		
		// Note: 'numberOfGamesToPlay' set by players at the beginning of the program
		int numberOfGamesToPlay;
		int numberOfOpeningLives = 4;
		
		// Note: By default player 01 is the first active player - Ie. Player 01 goes first.
		boolean player02IsActive = false;
		boolean wordIsValid = false;
		boolean playerEndsRound = false;
		
		char startingLetter;
		
		WordValidation wordValidation = new WordValidation();
		RandomLetter randomLetter = new RandomLetter();

		String word01 = "";
		String word02 = "";

		String currentActivePlayer;
		
		/////////////////////////////////////////
		
		System.out.println("");		
		System.out.println("-------- Welcome To 'Java Words Game!' --------");
		System.out.println("");
		System.out.println("");
		System.out.println("How To Play:");
		System.out.println("-----------");
		System.out.println("");
		System.out.println("2 players are needed to play this game.");
		System.out.println("Each player is given 4 lives at the beginning of each game.");
		System.out.println("The number of games to be played is chosen by you after these instructions are read.");
		System.out.println("Player 01 goes first.");
		System.out.println("To begin a game, a letter from the English alphapbet is chosen at random and displayed on screen.");
		System.out.println("Player 01 must enter a word that begins with the selected letter.");
		System.out.println("It is then Player 02's turn.");
		System.out.println("Player 02 must enter a word that starts with the last two letters of the word entered by player 01.");
		System.out.println("If a player cannot think of a valid word or no valid word exists, the player can forfeit the round by entering the '-' symbol instead of a word.");
		System.out.println("Therefore, entering '-' means the round is lost by that player. A single life will be dedcuted from the player who choose to forfeit the round.");
		System.out.println("A game is only over when all lives of a player have been lost");
		System.out.println("When there are no more games left to play the overall winner will be displayed.");
		System.out.println("");
		System.out.println("Addition rules:");
		System.out.println("All words entered must be at least 3 characters in length to be valid.");
		System.out.println("All words entered must also be present in the word list attached to this folder to be valid.");
		System.out.println("After the opening round, the winner of the last round goes first!");
		System.out.println("");
		System.out.println("One Last Thing..");
		System.out.println("");
		System.out.println("Point scoring:");
		System.out.println("Players can score points with the words they enter.");
		System.out.println("If a player enters a word with duplicated vowels, the number of duplicated vowels will be equal to the number of points they receive!");
		System.out.println("For example. 'Java' = 2 points, 'Nestle' = 2 points, 'Cheerleader' = 4 points and so on..");
		System.out.println("");
		System.out.println("Thats it!");
		System.out.println("");
		System.out.println("-------- Lets Begin! --------");

		System.out.println("Please enter the number of games you would like to play: ");
		Scanner input01 = new Scanner(System.in);
		numberOfGamesToPlay = input01.nextInt();

		System.out.println("You have chosen to play " + numberOfGamesToPlay + " games. Good luck!");

		System.out.println("");
		System.out.println("Remember...");
		System.out.println("Each player has " + numberOfOpeningLives + " lives per game.");
		System.out.println("To forfeit the round simply enter the '-' symbol.");
		System.out.println("");
		
		
		//Create GameManager object. Note: This creates two players each with the same number of lives and starting score.
		//Set the 'numberOfGamesToPlay' to what the user has input.
		GameManager gameManager = new GameManager(numberOfOpeningLives, 0);
		gameManager.setTotalGamesLeftToPlay(numberOfGamesToPlay);
		
		// Set which player is active.
		gameManager.setPlayerActiveStates(player02IsActive);
		
		// Do while there are still games left to played..
		do {
		
			// Do while both players still have lives..
			do {

				System.out.println("-------- Info --------");
				System.out.println("");
				System.out.println("Current Game Number: " + gameManager.getCurrentGameNumber());
				System.out.println("Round Number: " + gameManager.getCurrentRoundNumber());
				System.out.println("Games Left to Play : " + gameManager.getTotalGamesLeftToPlay());

				System.out.println("");
				System.out.println("");

				System.out.println("Generating random letter.. .. ..");
				System.out.println(".. .. ..");
				System.out.println(".. .. ");
				System.out.println("..");
								
				// Generate a random letter.
				startingLetter = randomLetter.generateRandomLetter();

				System.out.println("");
				System.out.println("");
				
				// Get which player is active.
				currentActivePlayer = gameManager.getActivePlayer();

				// Prompt player to enter a word.
				System.out.println(currentActivePlayer + "Please enter a 3 letter+ word beginning with the letter '" + startingLetter +"'.");
				Scanner input02 = new Scanner(System.in);
				word01 = input02.nextLine();
			
				// Check to see if the player enters a "-" symbol.
				playerEndsRound = wordValidation.validatePlayerEndsRound(word01);
				

				// If the player does not want to end the round..
				if (playerEndsRound == false) {
										
					// Validate the word is at least 3 letters long, starts with the letter 'startingLetter' and is on the vocab list.
					wordIsValid = wordValidation.validateFirst(startingLetter, word01);	
					
					// If the word is valid..
					if(wordIsValid) {
						
						// Set the current players word to their valid choice.
						gameManager.setCurrentPlayerWord(currentActivePlayer, word01);
						
						// Switch which player is now active. 
						gameManager.switchPlayer();
					}
					
					// While the word is invalid..
					while (wordIsValid == false) {
					
						// Prompt player to enter another word.
						System.out.println("");
						System.out.println(currentActivePlayer + "Please enter a different 3 letter+ word beginning with the letter '" + startingLetter + "' or enter '-' to forfit the round.");
						word01 = input02.nextLine();

						// Check to see if the player enters a "-" symbol.
						playerEndsRound = wordValidation.validatePlayerEndsRound(word01);

						// If "-" has been entered..
						if (playerEndsRound == true) {
												
							gameManager.roundEnded();							
							break;
							
							// If "-" has NOT been entered..
						} else {

							// Validate the word is at least 3 letters long, starts with the letter 'startingLetter' and is on the list.
							wordIsValid = wordValidation.validateFirst(startingLetter, word01);
							
							// If the word is valid..
							if(wordIsValid) {
								
								// Set the current players word to their valid choice.
								gameManager.setCurrentPlayerWord(currentActivePlayer, word01);
					
								// Switch which player is now active. 
								gameManager.switchPlayer();
							}
						}
					}
					
					// If the player has ended the round..
				} else {
					
					gameManager.roundEnded();
				}

				// Reset 'wordIsValid' back to false. 
				wordIsValid = false;
							
							
			///// Alternate player's turn. (Back and fourth loop) /////	
			
				// While neither player ends the round.. (In case player ends round at the very first chance)
				while (playerEndsRound == false) {
								
					
					// Reset 'wordIsValid' back to false. If the word is valid
					wordIsValid = false;

					
					// While neither player ends the round and while the is invalid.. (If the word is valid it will 'break;' out of this while loop.)
					while (playerEndsRound == false && wordIsValid == false) {
						
						
						// Get which player is active. Note: By default Player01 is active first.
						currentActivePlayer = gameManager.getActivePlayer();
						
												
						// If player01 is active
						if(currentActivePlayer.equals("Player 01: ")) {
							
							word01 = gameManager.player02.getCurrentWord();							
						}else {
							
							word01 = gameManager.player01.getCurrentWord();
						}
						
								
						// Reset 'wordIsValid' back to false. 
						wordIsValid = false;

						// Prompt the player to input word. 
						System.out.println(currentActivePlayer + "Please enter a 3 letter+ word beginning with the last two letters of the word '"+ word01 +"'.");
						Scanner input03 = new Scanner(System.in);
						word02 = input03.nextLine();
						
						// Set the current players word to word02.
						gameManager.setCurrentPlayerWord(currentActivePlayer, word02);
						
						
						// If player01 is active..
						if(currentActivePlayer.equals("Player 01: ")) {
														
							word02 = gameManager.player01.getCurrentWord();
							word01 = gameManager.player02.getCurrentWord();
						}else {
							
							word01 = gameManager.player01.getCurrentWord();
							word02 = gameManager.player02.getCurrentWord();
						}
						

						// Check to see if the player enters a "-" symbol.
						playerEndsRound = wordValidation.validatePlayerEndsRound(word02);

						// If the player does not enter "-" symbol..
						if (playerEndsRound == false) {

							// Validate the word is at least 3 letters long, starts with the last two letters of the word 'word01' and is on the vocab list.
							wordIsValid = wordValidation.validateWord(word01, word02);

							// If the word is valid..
							if (wordIsValid == true) {
							
								// Set the current players word to word02.
								gameManager.setCurrentPlayerWord(currentActivePlayer, word02);
								
								// Award points if word contains duplicated vowels.
								gameManager.awardPointsIfNecessary(word02);
								System.out.println("");
								
								// Switch which player is now active. 
								gameManager.switchPlayer();
								
							} else {

								// While the word is invalid..
								while (wordIsValid == false) {

									System.out.println("");
									System.out.println(currentActivePlayer + "Please enter a different 3 letter+ word beginning with the last two letters of the word '"+ word01 +"'.");
									word02 = input03.nextLine();

									// Check to see if the player enters a "-" symbol.
									playerEndsRound = wordValidation.validatePlayerEndsRound(word02);

									// If "-" has been entered..
									if (playerEndsRound == true) {
									
										gameManager.roundEnded();
										
										break;
										
										// If the player does not enter "-" symbol..
									} else {

										// Validate the word is at least 3 letters long, starts with the last two letters of the word 'word01' and is on the vocab list.
										wordIsValid = wordValidation.validateWord(word01, word02);

										// If the word is valid..
										if (wordIsValid == true) {

											// Set the current players word to word02.
											gameManager.setCurrentPlayerWord(currentActivePlayer, word02);
											
											// Award points if word contains duplicated vowels.
											gameManager.awardPointsIfNecessary(word02);
											System.out.println("");
											
											// Switch which player is now active. 
											gameManager.switchPlayer();
										}
									}
								}
							}
							
							// Player has ended the round.
						} else {
							
							gameManager.roundEnded();
						}
					}			

					// reset
					wordIsValid = false;					
					
				}				
				// A single ROUND is now over. A player has entered the "-" symbol.
				
				// reset
				playerEndsRound = false;
				System.out.println("");
				System.out.println("-----------------------");
				System.out.println("");
				System.out.println("Game " + gameManager.getCurrentGameNumber() + " Stats:");

				System.out.println("");
				System.out.println("Player 01 Games Won: " + gameManager.player01.getNumberOfGamesWon());
				System.out.println("Player 02 Games Won: " + gameManager.player02.getNumberOfGamesWon());
				
				System.out.println("");
				System.out.println("Player 01 Lives: " + gameManager.player01.getPlayerLives());				
				System.out.println("Player 02 Lives: " + gameManager.player02.getPlayerLives());
				
				System.out.println("");
				System.out.println("Player 01 Points: " + gameManager.player01.getPlayerScore());
				System.out.println("Player 02 Points: " + gameManager.player02.getPlayerScore());
				
				System.out.println("");

			} while (gameManager.player01.getPlayerLives() > 0 && gameManager.player02.getPlayerLives() > 0);

			
			// A SINGLE game is now over.			

			// Reset
			playerEndsRound = false;
			
			// Reset 
			gameManager.singleGameOverReset(numberOfOpeningLives);
			
			System.out.println("Good gaming! Enter any key to continue.. ");
			Scanner input05 = new Scanner(System.in);
			String throwaway = input05.nextLine();
		
		} while (gameManager.getTotalGamesLeftToPlay() > 0);

		
		// ALL games are now over.

		System.out.println("");		
		System.out.println("All games have been played!");
		
		System.out.println("");
		System.out.println("");

		System.out.println("-------- Final Statistics --------");
		System.out.println("");
		
		System.out.println("Player 01 Games Won: " + gameManager.player01.getNumberOfGamesWon());
		System.out.println("Player 02 Games Won: " + gameManager.player02.getNumberOfGamesWon());
		
		System.out.println("");
		
		System.out.println("Player 01 Total Points Received: " + gameManager.player01.getTotalPlayerScore());
		System.out.println("Player 02 Total Points Received: " + gameManager.player02.getTotalPlayerScore());
		
		System.out.println("");
		System.out.println("-------- Thank you for playing 'Java Word Game!' --------");

		System.out.println("");
		System.out.println("EXIT!");
	}
}
