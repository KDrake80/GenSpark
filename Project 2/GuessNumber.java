package genspark.assignments.section2;

import java.util.Scanner;
public class GuessNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        int answer = (int)(1 + Math.random() * 21);
        String name = input.next();
        System.out.println("Well, " + name + ", I'm thinking of a number between 1 and 20.\nTake a guess");
        int count = 1;
        while (count <= 6) {
            int guess = input.nextInt();
            if (guess < answer) {
                System.out.println("Your answer is too low");
            }
            else if (guess > answer){
                System.out.println("Your answer is too high");
            }
            else {
                System.out.print("Good Job! " + name + " You guess my number in " + count + " guesses!");
                if (count < 6) {
                    System.out.println(" Would you like to play again?");
                    String yes = input.next();
                    if (yes.equalsIgnoreCase("y")) {
                        System.out.println("Take a guess");
                    }
                    else
                        break;
                }
            }
            count++;
        }
    }
}
