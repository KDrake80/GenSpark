package Project7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kevin Drake
 * 7/4/22
 * JUnit for FunctionalHangman
 */
class HangmanTest {
    /**
     * Hangman is Static Don't need to create the Instance of the Object.
     * I have written Test Cases, For all Methods that return a Variable.
     */

    /**
     * This one has 4 test cases,
     * 1: Length of Input
     * 2: Length false Case
     * 3: Incorrect Letter guessed Already
     * 4: Correct Letter guessed Already
     * @return boolean, true, if valid, false if Invalid
     */
    @Test
    void checkValidity() {
        Hangman.incorrect = new ArrayList<>();
        Hangman.correct = new HashMap<Character, Integer>();
        assertEquals(true, Hangman.checkValidity("n"), "Valid Test 1: Failed");
        assertEquals(false, Hangman.checkValidity("nmo"), "T=Valid Test 2: Failed");
        Hangman.incorrect.add('m');
        assertEquals(false, Hangman.checkValidity("m"), "Valid Test 3: Failed");
        Hangman.correct.put('s', 1);
        assertEquals(false, Hangman.checkValidity("s"), "Valid Test 4: Failed");
    }

    /**
     * "HangmanWords.txt" -- Path for Words File
     * Tests to see if Program randomly generates word from file. Retrieve all
     * words from the file, then compare the cases to the list of words.
     * Test 1: Tests a false case, words not stored to List.
     * Test 2: Tests a true case, if list contains word Generated.
     * return false if it doesnt, return true if it does contain.
     * @throws IOException
     */
    @Test
    void getWord() throws IOException {
        List<String> words = new ArrayList<>();
        assertEquals(false, words.contains(Hangman.getWord()), "GetRandomWord Test 1: Failed");
        words = Files.lines(Path.of("HangmanWords.txt")).collect(Collectors.toList());
        assertEquals(true, words.contains(Hangman.getWord()), "GetRandomWord Test 2: Failed");
    }

    /**
     * "HangmanScores.txt" -- Scores File Path
     * Tests Integer Parsing for scores from the File
     * Test 1: Creates a String, alike the ones found in File; Then Parses the score
     * Test 2: Same, Just creates a Different Number to check; then parses
     * @return Integer: parsed from Score String in File
     */
    @Test
    void getScoreFromFile() {
        assertEquals(700, Hangman.getScoreFromFile("Ra | 700 | Sun-God"), "GetNumber Test 1: Failed");
        assertEquals(500, Hangman.getScoreFromFile("Hathor | 500 | Egypt"), "GetNumber Test 2: Failed");
    }
}