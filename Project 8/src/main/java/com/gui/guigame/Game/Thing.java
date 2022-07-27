package com.gui.guigame.Game;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public abstract class Thing extends BorderPane {
    ImageView icon;
    int x, y;

    public ImageView getIcon() {
        return icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public abstract void setIcon(String path);
    public abstract void setCoords(int x, int y);
}

