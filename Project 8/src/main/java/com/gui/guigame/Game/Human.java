package com.gui.guigame.Game;

import javafx.geometry.Insets;

public class Human extends Humanoid {
    public Human(){
        setPadding(new Insets(5, 5, 5, 5));
        setHealth(45);
        setStrength(25);
        setIcon("C:\\Users\\kevin\\OneDrive\\Desktop\\GUIGame\\HumanPic.jpg");
        setCenter(icon);
    }
    public Human(int x, int y){
        setPadding(new Insets(5, 5, 5, 5));
        setHealth(45);
        setStrength(25);
        setIcon("C:\\Users\\kevin\\OneDrive\\Desktop\\GUIGame\\HumanPic.jpg");
        setCoords(x, y);
        setCenter(icon);
    }

    @Override
    public String toString() {
        return "Player [\n" + super.toString() + "\n]";
    }

    @Override
    public String attack(Humanoid h) {
        if (h.getHealth() <= getStrength()){
            return "Player attacked Goblin for " + getStrength() + ", and has slain the Goblin!";
        }
        else {
            h.setHealth(h.getHealth() - getStrength());
            return "Player attacked Goblin for " + getStrength() + ", but he survived!";
        }
    }
}

