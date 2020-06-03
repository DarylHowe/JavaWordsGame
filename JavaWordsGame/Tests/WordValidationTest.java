import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WordValidationTest {

	WordValidation wordValidation;
	
	@BeforeEach
	@DisplayName("")
	void init(){
		wordValidation = new WordValidation();
	}
	
	@Test
	@DisplayName("First two letters match last two letters test")
	void wordValidationTest() {
		
		assertEquals(true, wordValidation.validateWord("Apple", "Lemon"), "should return boolean");
	}
	
	@Nested
	@DisplayName("First two letters do not match last two letters tests")
	class fails{
		
		@Test
		@DisplayName("First two letters do not match last two letters test")
		void wordValidationTestFail() {
			
			assertEquals(false, wordValidation.validateWord("Apple", "Zebra"),"should return boolean");
		}
		
		@Test
		@DisplayName("First two letters do not match last two letters test")
		void wordValidationTestFailAlternate() {
			
			assertEquals(false, wordValidation.validateWord("Table", "King"), "should return boolean");
		}
	}

	
	@Test
	@DisplayName("Player ends round")
	void userEndsRoundTest() {
		assertEquals(true, wordValidation.validatePlayerEndsRound("-"), "should return boolean");
	}
	
	@Test
	@DisplayName("Player doesn't end round")
	void userDoesNotEndsRoundTest() {
		assertEquals(false, wordValidation.validatePlayerEndsRound("Cat"), "should return boolean");
	}
	
	@Test
	@DisplayName("Word not on list")
	void wordNotOnListTest() {
		
		assertEquals(false, wordValidation.validateWordVocabList("Elephant"), "should return boolean");
	}
	
	@Test
	@DisplayName("Word is on list")
	void wordIsOnListTest() {
		assertEquals(true, wordValidation.validateWordVocabList("Apple"), "should return boolean");
	}

}
