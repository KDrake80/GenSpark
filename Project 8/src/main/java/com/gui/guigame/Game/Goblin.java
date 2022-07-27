package com.gui.guigame.Game;


public class Goblin extends Humanoid {
    public Goblin(){
        setHealth(15);
        setStrength(25);
        setIcon("C:\\Users\\kevin\\OneDrive\\Desktop\\GUIGame\\GoblinPic.png");
        setCenter(icon);
    }
    public Goblin(int x, int y){
        setHealth(15);
        setStrength(25);
        setIcon("C:\\Users\\kevin\\OneDrive\\Desktop\\GUIGame\\GoblinPic.png");
        setCoords(x, y);
        setCenter(icon);
    }
    @Override
    public String toString() {
        return "Goblin [\n" + super.toString() + "\n]";
    }

    @Override
    public String attack(Humanoid h) {
        if (h.getHealth() <= getStrength()){
            return "Goblin attacked you for " + getStrength() + ", and has killed you!";
        }
        else {
            h.setHealth(h.getHealth() - getStrength());
            return "Goblin attacked you for " + getStrength() + ", but you survived!";
        }
    }
}

