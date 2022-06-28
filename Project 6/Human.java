import java.util.Locale;
import java.util.Scanner;

public class Human extends Humanoid {

    public Human() {
        super();
        setValue("H");
        setStrength(25);
        setHealth(45);
    }


    @Override
    public String attack(Object o) {
        Goblin g = (Goblin) o;
        if (g.getHealth() <= getStrength()) {
            g.setHealth(0);
            return "Player attacked Goblin for " + getStrength() + " and has slain the Goblin!";
        } else {
            g.setHealth(g.getHealth() - getStrength());
            return "Player has hurt the Goblin for " + getStrength() + " but it is still alive!";
        }
    }
    @Override
    public String toString() {
        return this.getValue();
    }
}
