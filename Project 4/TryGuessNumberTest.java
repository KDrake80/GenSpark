

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TryGuessNumberTest {
    // Create an Instance of the GuessNumber Class
    TryGuessNumber guess;
    @BeforeEach
    void setUp() {
        guess = new TryGuessNumber();
    }

    /**
     * This tests the setName method
     * String name, parameter to call method with
     */
    @Test
    void setName() {
        guess.setName("Kevin");
        assertEquals("Kevin", guess.getName(), "Set Name: Failed");
        guess.setName("Christian");
        assertEquals("Christian", guess.getName(), "Set Name 2: Failed");
    }

    /**
     * Tests getAnswer method. I created a "SetAnswer" method, specifically for this test. That Way I would
     *  not need to use another Ternary Operator for the Assert.
     */
    @Test
    void getAnswer() {
        guess.setAnswer(4);
        assertEquals(4, guess.getAnswer(), "Get Answer: Failed");
        guess.setAnswer(6);
        assertEquals(6, guess.getAnswer(), "Get Answer 2: Failed");
    }

    /**
     * Tests the setAnswer method I created specifically for the JUnits
     * int answer, any integer you can for this.
     */
    @Test
    void setAnswer(){
        guess.setAnswer(6);
        assertEquals(6, guess.getAnswer(), "Set Answer: Failed");
    }
}