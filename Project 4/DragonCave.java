

import java.util.InputMismatchException;
import java.util.Scanner;
public class DragonCave {
    private int cave = 0;
    private int answer = 0;
    public int getAnswer() {
        return answer;
    }
    public DragonCave(){
        setCave();
    }
    public int getCave() {
        return cave;
    }

    public void setCave() {
       cave = (int)(1 + Math.random() * 2);
    }

    public void setAnswer(int answer) {
        if (answer == 1 || answer == 2)
            this.answer = answer;
        else {
            System.out.println("Please Enter 1 or 2");
            new DragonCave();
        }
    }

    public void evaluate(){
        if (answer == cave) {
            System.out.print("You approach the cave... \nIt is dark and spook...\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and..." +
                    "\nGobbles you down in one bite!");
        }
        else {
            System.out.print("You approach the cave, and hear a loud roar!\n" +
                    "You continue to walk in and see mountains of glittering treasure!" +
                    "\nThe dragon approaches you calmly and speaks to you in a low voice" +
                    "\nI will share my hoard with you. Congratulations!");
        }
    }
}
class TestClass {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        try {
            DragonCave dragons = new DragonCave();
            System.out.println("You are in a land of dragons. In front of you there are two caves.\nIn one cave the dragon" +
                    "is friendly and will share his treasure.\nThe other dragon is greedy and hungry and will eat you on site. " +
                    "\nWhich cave will you go into? (1 or 2)");
            int guess = input.nextInt();
            dragons.setAnswer(guess);
            dragons.evaluate();
        }
        catch (InputMismatchException i){
            System.out.print("Invalid Input: Enter only 1 or 2");
        }
    }
}
