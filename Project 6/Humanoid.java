public class Humanoid extends Thing {
    int x, y;
    int health;
    int strength;

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

    public void printStats(){
        System.out.println(getHealth());
        System.out.println(getStrength());
    }
    @Override
    public String toString(){
        return this.getValue();
}
    public String attack(Object other){
        return "Something is attacking something else";
    }
}