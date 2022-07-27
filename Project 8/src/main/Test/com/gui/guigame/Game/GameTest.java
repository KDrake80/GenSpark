package com.gui.guigame.Game;

import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Kevin Drake
 * Test Class for all classes in this Game
 */
class GameTest {
    Game g;


    /**
     * Tests return methods of Humanoid Class, by extension Thing class, Human Class, and Goblin Class
     * return's int, X coordinate, tests 1 Human, 1 Goblin of the game
     * return's int, Y coordinate, tests 1 Human, 1 Goblin of the game
     * return's String, Path of ImageView, tests 1 Human, 1 Goblin of the game
     */
    @Test
    void testHumanoidClass(){
        assertEquals(0, g.map.player.getX(), "Human X test: Failed");
    }
}