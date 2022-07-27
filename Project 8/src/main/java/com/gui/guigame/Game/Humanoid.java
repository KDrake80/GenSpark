package com.gui.guigame.Game;

import javafx.scene.image.ImageView;

public class Humanoid extends Thing {
    private int health, strength;

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public String getStats(){
        return "Health: " + getHealth() + "\nStrength: " + getStrength();
    }
    public String attack(Humanoid h){
        return "Attack!";
    }
    @Override
    public void setIcon(String path) {
        icon = new ImageView(path);
        icon.setFitWidth(35);
        icon.setFitHeight(35);
    }

    @Override
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int[] getCoords(){
        return new int[]{this.getX(), this.getY()};
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
