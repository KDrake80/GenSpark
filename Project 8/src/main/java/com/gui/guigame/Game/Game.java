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
        display.setText("Press UP, DOWN, LEFT, RIGHT arrow keys to move direction\nWhich direction?");
        movePiece();
        Scene s = new Scene(bp);
        stage.setScene(s);
        stage.setTitle("Humans VS Goblins");
        stage.show();
        display.requestFocus();
    }
    public String displayError(int num){
        if (num == 0)
            return "Error! Invalid Move! Retry!";
        else {
            Goblin target = null;
            for (Goblin g: map.enemies) {
                if (g.getX() == map.player.getX() && g.getY() == map.player.getY() + 1 ||
                g.getX() == map.player.getX() && g.getY() == map.player.getY() - 1 ||
                g.getX() == map.player.getX() + 1 && g.getY() == map.player.getY() ||
                g.getX() == map.player.getX() - 1 && g.getY() == map.player.getY()) {
                    target = g;
                }
            }
            return map.player.attack(target);
        }
    }
    public void movePiece(){
        display.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case UP -> {
                    if (map.player.getX() > 0 &&
                            !map.checkTileOccupied(map.player.getX() - 1, map.player.getY())){
                        map.movePiece("UP", map.player);
                    } else if (map.checkTileOccupied(map.player.getX() - 1, map.player.getY())) {
                        display.setText(displayError(1));
                    } else {
                        display.setText(displayError(0));
                    }
                }
                case DOWN -> {
                    if (map.player.getX() < map.dimension - 1 &&
                            !map.checkTileOccupied(map.player.getX() + 1, map.player.getY())){
                        map.movePiece("DOWN", map.player);
                    } else if (map.checkTileOccupied(map.player.getX() + 1, map.player.getY())) {
                        display.setText(displayError(1));
                    } else {
                        display.setText(displayError(0));
                    }
                }
                case LEFT -> {
                    if (map.player.getY() > 0 && !map.checkTileOccupied(map.player.getX(), map.player.getY() - 1)) {
                        map.movePiece("LEFT", map.player);
                    } else if (map.checkTileOccupied(map.player.getX(), map.player.getY() - 1)) {
                        display.setText(displayError(1));
                    } else {
                        display.setText(displayError(0));
                    }
                }
                case RIGHT -> {
                    if (map.player.getY() < map.dimension - 1 &&
                            !map.checkTileOccupied(map.player.getX(), map.player.getY() + 1)) {
                        map.movePiece("RIGHT", map.player);
                    } else if (map.checkTileOccupied(map.player.getX(), map.player.getY() + 1)) {
                        display.setText(displayError(1));
                    } else {
                        display.setText(displayError(0));
                    }
                }
            }
        });
    }

   public static void main(String[] args) {
        launch(args);
    }
}

