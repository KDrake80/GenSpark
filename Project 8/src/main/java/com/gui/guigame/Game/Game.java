package com.gui.guigame.Game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application {
    BorderPane bp = new BorderPane();
    Map map = new Map(10);
    TextArea display = new TextArea();
    String move;
    boolean turn;

    public void start(Stage stage) {
        turn = true;
        bp.setCenter(map);
        bp.setPadding(new Insets(5, 5, 5, 5));
        bp.setBottom(display);
        display.setPrefHeight(75);
        display.setPrefRowCount(10);
        display.setEditable(false);
        display.setText("Which?");
        movePiece();
        Scene s = new Scene(bp);
        stage.setScene(s);
        stage.setTitle("Humans VS Goblins");
        stage.show();
        display.requestFocus();
    }
    public void displayError(int num){
        if (num == 0)
            display.setText("Error! Invalid Move! Retry!");
        else
            display.setText("Occupied");
    }
    public void movePiece(){
        display.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case UP -> {
                    if (map.player.getX() > 0 &&
                            !map.checkTileOccupied(map.player.getX() - 1, map.player.getY())){
                        map.movePiece("UP", map.player);
                    } else if (map.checkTileOccupied(map.player.getX() - 1, map.player.getY())) {
                        displayError(1);
                    } else {
                        displayError(0);
                    }
                //    moveGoblin();
                }
                case DOWN -> {
                    if (map.player.getX() < map.dimension - 1 &&
                            !map.checkTileOccupied(map.player.getX() + 1, map.player.getY())){
                        map.movePiece("DOWN", map.player);
                    } else if (map.checkTileOccupied(map.player.getX() + 1, map.player.getY())) {
                        displayError(1);
                    } else {
                        displayError(0);
                    }
               //     moveGoblin();
                }
                case LEFT -> {
                    if (map.player.getY() > 0 && !map.checkTileOccupied(map.player.getX(), map.player.getY() - 1)) {
                        map.movePiece("LEFT", map.player);
                    } else if (map.checkTileOccupied(map.player.getX(), map.player.getY() - 1)) {
                        displayError(1);
                    } else {
                        displayError(0);
                    }
                 //   moveGoblin();
                }
                case RIGHT -> {
                    if (map.player.getY() < map.dimension - 1 &&
                            !map.checkTileOccupied(map.player.getX(), map.player.getY() + 1)) {
                        map.movePiece("RIGHT", map.player);
                    } else if (map.checkTileOccupied(map.player.getX(), map.player.getY() + 1)) {
                    } else {
                        displayError(0);
                    }
                   // moveGoblin();
                }
            }
        });
    }
//    public void moveGoblin(){
//        boolean[][] data = new boolean[map.enemies.length][5];
//        boolean vert1, hor1, spec1, spec2, c1;
//        //  data[i]0 data[i]1 data[i]2 data[i]3 data[i]4
//        int[] subtractions = new int[2];
//        // map.enemies[i]
//        for (int i = 0; i < map.enemies.length; i++) {
//            /**
//             * case 0: check to see if the Goblin is Above the player, or Below
//             * case 1: check to see if Goblin is to the Left, or Right
//             * case 2: Special Case: if on same Row
//             * case 3: Special Case: if they are in same Column
//             * subtractions 0: count how many spaces away row wise (math.abs called just in case its negative)
//             * subtractions 1: count how many spaces away column wise (math.abs called just in case its negative)
//             * case 4: take the farthest path to shorten the distance
//             */
//            data[i][0] = GridPane.getRowIndex(map.enemies[i]) < GridPane.getRowIndex(map.player);
//            data[i][1] = GridPane.getColumnIndex(map.enemies[i]) < GridPane.getColumnIndex(map.player);
//            data[i][2] = GridPane.getRowIndex(map.enemies[i]) == GridPane.getRowIndex(map.player);
//            data[i][3] = GridPane.getColumnIndex(map.enemies[i]) == GridPane.getColumnIndex(map.player);
//            subtractions[0] = Math.abs(map.enemies[i].getX() - map.player.getX());
//            subtractions[1] =  Math.abs(map.enemies[i].getY() - map.player.getY());
//            data[i][4] = subtractions[0] < subtractions[1];
//
//            // Special Cases if they're both equal they should attack
//            if (!data[i][2] && !data[i][3]){
//                // Case 1: Down and Right
//                if (data[i][0] && data[i][1]){
//                    // Move: Down
//                    if (data[i][4]){
//                        map.movePiece("DOWN", map.enemies[i]);
//                    }
//                    // Move: Right
//                    else {
//                        map.movePiece("RIGHT", map.enemies[i]);
//                    }
//                    // Case 2:  Down and Left
//                } else if (data[i][0] && !data[i][1]) {
//                    if (data[i][4]){
//                        map.movePiece("DOWN", map.enemies[i]);
//                    }
//                    // Move: Left
//                    else {
//                        map.movePiece("Left", map.enemies[i]);
//                    }
//                    // Case 3: Up and Left
//                } else if (!data[i][0] && !data[i][1]) {
//                    // Move: Up
//                    if (data[i][4]){
//                        map.movePiece("UP", map.enemies[i]);
//                    }
//                    // Move: Left
//                    else {
//                        map.movePiece("LEFT", map.enemies[i]);
//                    }
//                    // Case 4: Up and Right
//                } else if (!data[i][0] && data[i][1]) {
//                    // Move: Up
//                    if (data[i][4]){
//                        map.movePiece("UP", map.enemies[i]);
//                    }
//                    // Move: Right
//                    else{
//                        map.movePiece("RIGHT", map.enemies[i]);
//                    }
//                }
//            }else if (data[i][2] && data[i][3]){
//                displayError(1);
//            }
//        }
//    }
   public static void main(String[] args) {
        launch(args);
    }
}

