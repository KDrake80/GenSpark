public class Goblin extends Humanoid {

   public Goblin(){
       super();
       setValue("G");
       setHealth(15);
       setStrength(5);
   }
    @Override
    public String attack(Object o) {
       Human player = (Human) o;
       if (player.getHealth() <= this.getStrength()) {
           player.setHealth(0);
           return "Goblin attacked player for " + getStrength() + " and the human has died";
       }
       else {
           player.setHealth(player.getHealth() - getStrength());
           return "Goblin attacked player for " + getStrength() + " and reduced humans health";
       }
   }
   @Override
    public String toString() {
       return this.getValue();
   }
}
