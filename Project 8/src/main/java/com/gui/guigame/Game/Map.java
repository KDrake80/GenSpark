package com.gui.guigame.Game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Map extends GridPane {
    Human player;
    Goblin[] enemies;
    int dimension;

    public Map(int size) {
        setPadding(new Insets(5, 5, 5, 5));
        setAlignment(Pos.CENTER);
        dimension = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                add(new Land(i, j), i, j);
            }
        }
        player = new Human();
        setPiece(0, 3, player);
        enemies = new Goblin[3];
        for (int i = 0; i < 3; i++) {
            enemies[i] = new Goblin();
        }
        setPiece(size - 1, 2, enemies[0]);
        setPiece(5, 4, enemies[1]);
        setPiece(7, 6, enemies[2]);
    }

    public void movePiece(String s, Humanoid h) {
        switch (s) {
            case "UP" -> {
                    GridPane.setRowIndex(h, h.getX() - 1);
                    h.setX(GridPane.getRowIndex(h));
            }
            case "DOWN" -> {
                    GridPane.setRowIndex(h, h.getX() + 1);
                    h.setX(GridPane.getRowIndex(h));
            }
            case "LEFT" -> {
                    GridPane.setColumnIndex(h, h.getY() - 1);
                    h.setY(GridPane.getColumnIndex(h));
            }
            case "RIGHT" -> {
                    GridPane.setColumnIndex(h, h.getY() + 1);
                    h.setY(GridPane.getColumnIndex(h));
            }
        }
    }

    public void setPiece(int x, int y, Humanoid piece) {
        add(piece, y, x);
        piece.setX(x);
        piece.setY(y);
    }
    public boolean checkTileOccupied(int x, int y){
        for (Goblin g: enemies) {
            if (g.getX() == x && g.getY() == y){
                player.attack(g);
                return true;
            }
        }
        return false;
    }
}
