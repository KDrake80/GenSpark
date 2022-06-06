package genspark.assignments.Projects;

import java.util.Scanner;
public class DragonCave {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("You are in a land of dragons. In front of you there are two caves.\nIn one cave the dragon" +
                "is friendly and will share his treasure.\nThe other dragon is greedy and hungry and will eat you on site. " +
                "\nWhich cave will you go into? (1 or 2)");
        int hungry =(int)( 1 + Math.random() * 3);
        int choice = input.nextInt();
        if (choice == hungry) {
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
