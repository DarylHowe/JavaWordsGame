import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("When running DuplicatedVowelCounter")
class DuplicateVowelCounterTest {

	DuplicateVowelCounter duplicateVowelCounter;

	@BeforeEach
	void init() {
		duplicateVowelCounter = new DuplicateVowelCounter();
	}


	
	@Test
	@DisplayName("No duplicate vowels test")
	void noDuplicateVowelsTest() {

		duplicateVowelCounter.setChosenWord("Rythm");

		int expected = 0;
		int actual = duplicateVowelCounter.calculatePoints();

		assertEquals(expected, actual, "Should return the number of duplicated vowels.");
	}

	@Test
	@DisplayName("Vowel but no duplicate test")
	void vowelButNoDuplicateTest() {

		duplicateVowelCounter.setChosenWord("Mobile");
		assertEquals(0, duplicateVowelCounter.calculatePoints(), "Should return the number of duplicated vowels.");
	}

	@Test
	@DisplayName("Duplicated vowels test")
	void duplicatedVowelsTest() {

		duplicateVowelCounter.setChosenWord("Speaker");
		assertEquals(2, duplicateVowelCounter.calculatePoints(), "Should return the number of duplicated vowels.");
	}

	@Test
	@DisplayName("Duplicated vowels test upper case")
	void duplicatedVowelsTestUpperCase() {

		duplicateVowelCounter.setChosenWord("ENEMY");
		assertEquals(2, duplicateVowelCounter.calculatePoints(), "Should return the number of duplicated vowels.");
	}
	
	@Test
	@DisplayName("Many duplicated vowels test")
	void manyDuplicatedVowelsTest() {

		duplicateVowelCounter.setChosenWord("AAbbooiissddff");
		assertEquals(6, duplicateVowelCounter.calculatePoints(), "Should return the number of duplicated vowels.");
	}

}
