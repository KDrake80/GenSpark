import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kevin
 *  6/28/22
 */
class GameTest {
    Game game;

    /**
     * Instantiate the game
     */
    @BeforeEach
    void setUp() {
        // Create the game
        game = new Game();
        // Place player in a slot that is on the edge of the board, to test it.
        game.world.setTile(0, 0, game.player);
    }

    /**
     * Checks the boundaries for the human to move
     * returns false, if player is on edge, and player is trying to move that direction
     * return true, if player is not on edge
     */
    @Test
    void checkBoundaries() {
        assertEquals(false, game.checkBoundaries('N'), "Boundary Test 1: Failed");
        assertEquals(true, game.checkBoundaries('S'), "Boundary Test 2: Failed");
    }

    /**
     * Checks if a Goblin is in front of the player
     * returns false if goblin is not near player
     * returns true if near player
     */
    @Test
    void check() {
        assertEquals(false, game.check('S'), "Enemy Near Test 1: Failed");
        game.world.setSpace(0, 1, game.enemies[0]);
        assertEquals(true, game.check('E'), "Enemy Near Test 2: Failed");
    }

    /**
     * Tests the goblins Attack
     * Test 1 checks if player is damaged
     * Test 2 checks if player is killed
     */
    @Test
    void testAttackGoblin(){
        Goblin g = new Goblin();
        Human h = new Human();
        assertEquals("Goblin attacked player for " + g.getStrength() + " and reduced humans health", g.attack(h),
                "Goblin Attack Test 1: Failed");
        g.setStrength(50);
        assertEquals("Goblin attacked player for " + g.getStrength() + " and the human has died", g.attack(h),
                "Goblin Attack Test 2: Failed");
    }

    /**
     * Test Human Attack
     * test 1 checks if goblin has been killed
     * test 2 checks if goblin has been hurt
     */
    @Test
    void testAttackHuman(){
        Human h = new Human();
        Goblin g = new Goblin();
        assertEquals("Player attacked Goblin for " + h.getStrength() + " and has slain the Goblin!", h.attack(g),
                "Human Attack Test 1: Failed");
        h.setStrength(4);
        g.setHealth(10);
        assertEquals("Player has hurt the Goblin for " + h.getStrength() + " but it is still alive!", h.attack(g),
                "Human Attack Test 2: Failed");
    }

    /**
     * Tests all the ToString Methods
     * Test 1: Goblin toString
     * Test 2: Human toString
     * Test 3: Land toString
     */
    @Test
    void testAllToString(){
        assertEquals("G", game.enemies[0].toString(), "Goblin ToString: Failed");
        assertEquals("H", game.player.toString(), "Human ToString: Failed");
        assertEquals("~", game.world.getSpace(1, 1).toString(), "Land ToString: Failed");
    }

    /**
     * This checks the board if there are enemies
     * Test 1: checks if Goblins are present
     * create new Map with no Goblins
     * Test 2: returns false because there are none
     */
    @Test
    void testMapCheckBoardForEnemy(){
        assertEquals(true, game.world.checkBoard(), "Check Board 1: Failed");
        GameMap x = new GameMap(5);
        assertEquals(false , x.checkBoard(), "Check Board 2: Failed");
    }

    /**
     * Test Maps Get Dimensions
     * Test 1: gets Game Dimensions
     * Create new map with new Dimensions
     * Test 2: returns new Maps Dimensions
     */
    @Test
    void testMapGetDimensions(){
        assertEquals(5, game.world.getDimensions(), "Dimensions Test 1: Failed");
        GameMap g = new GameMap(10);
        assertEquals(10, g.getDimensions(), "Dimension Test 2: Failed");
    }
    @AfterEach
    void tearDown() {
    }
}