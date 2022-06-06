
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonCaveTest {
    // Create an instance of the DragonCave
    DragonCave dragons;

    @BeforeEach
    /**
     * Create an instance of the DragonCave class, before each test
     */
    void setUp() {
        dragons = new DragonCave();
    }
    /**
     * This is to test the getAnswer method
     * return int, answer. Answer is the input the user guessed
     */
    @Test
    void getAnswer() {
        assertEquals(0, dragons.getAnswer(), "Get Answer: Failed");
        dragons.setAnswer(1);
        assertEquals(1, dragons.getAnswer(), "Get Answer 2: Failed");
    }

    /**
     * This is to test the getCave Method
     * returns int, cave. Set up to create either 1 or 2 randomly
     */
    @Test
    void getCave() {
        // Random on the test if its 1 or 2, So i did a ternary operator for this
        assertEquals((dragons.getCave() == 1) ? 1 : 2, dragons.getCave(), "Get Cave: Failed");
    }

    /**
     * This is to test the setCave method, which randomly places a 1 or 2
     */
    @Test
    void setCave() {
        // Random on the test if its 1 or 2, So i did a ternary operator for this
        assertEquals((dragons.getCave() == 1) ? 1 : 2, dragons.getCave(), "Set Cave: Failed");
    }

    /**
     * This is to test the setAnswer method.
     */
    @Test
    void setAnswer() {
        dragons.setAnswer(1);
        assertEquals(1, dragons.getAnswer(), "Set Answer: Failed");
    }
}