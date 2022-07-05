/*
Kevin Drake
Parent class for Goblins and Humans. 
*/
public class Humanoid extends Thing {
    // X and Y coords. Health, and Strength
    int x, y;
    int health;
    int strength;
    
    // Getters and Setters for all Data Fields
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }
    // Method to prints the stats 
    public void printStats(){
        System.out.println(getHealth());
        System.out.println(getStrength());
    }
    // Method to print the Reference UTF Value
    @Override
    public String toString(){
        return this.getValue();
    }
    // Attack Method
    public String attack(Object other){
        return "Something is attacking something else";
    }
}
