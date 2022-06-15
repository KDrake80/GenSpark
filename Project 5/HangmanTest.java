import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Class for Hangman game
 *
 * @author KevinD
 * 6/15/22
 */
class HangmanTest {
    /**
     * Initialize an Instance of Hangman
     */
    Hangman hangman;

    /**
     * Before Each: Create Instance of Hangman
     * Set Test Word: genspark
     */
    @BeforeEach
    void setUp() {
        hangman = new Hangman();
        hangman.setWord("genspark");
    }

    /**
     * Test Check Guess
     * Test 1: checks a true case
     * Test 2: checks a false case
     */
    @Test
    void testCheckGuess() {
        assertEquals(true, hangman.checkGuess("g"), "Check Guess: Failed");
        assertEquals(false, hangman.checkGuess("t"), "Check Guess 2: Failed");
    }

    /**
     * Test Get Word
     * Test 1: get genspark
     * Set new word for Test 2
     * Test 2: returns car
     */
    @Test
    void testGetWord() {
        assertEquals("genspark", hangman.getWord(), "Get Word: Failed");
        hangman.setWord("car");
        assertEquals("car", hangman.getWord(), "Get Word 2: Failed");
    }

    /**
     * Test Get Lives
     * Test 1: gets initial life
     * Test 2: Set lifes once, decrement 1, return 5
     */
    @Test
    void testGetLives() {
        assertEquals(6, hangman.getLives(), "Get Lives: Failed");
        hangman.setLives();
        assertEquals(5, hangman.getLives(), "Get Lives 2: Failed");
    }

    /**
     * Test Guess
     * Test 1: the guess is set to "---" in contructor
     */
    @Test
    void testGetGuesses() {
        assertEquals("---", hangman.getGuesses(), "Get Guesses: Failed");
    }
}