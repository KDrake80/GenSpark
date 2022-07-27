package com.gui.guigame.Game;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;

public class Land extends Thing {
    public Land(int x, int y) {
        setIcon("C:\\Users\\kevin\\OneDrive\\Desktop\\GUIGame\\LandPic.png");
        setCoords(x, y);
        setCenter(icon);
    }

    @Override
    public void setIcon(String path) {
        icon = new ImageView(path);
        icon.setFitHeight(45);
        icon.setFitWidth(45);
    }
    @Override
    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "I am Land";
    }
}

