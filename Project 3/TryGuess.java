package GenSpark;


import java.util.Scanner;
/*
 * Added Try Catch block to user Input Statements.
 */
public class TryGuess {
	    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        try {
            String name = input.next();
            System.out.println("Well, " + name + ", I'm thinking of a number between 1 and 20.\nTake a guess");
            int count = 1;
            int answer = (int)(1 + Math.random() * 20);
            while (count <= 6) {
                int guess = input.nextInt();
                if (guess < answer) {
                    System.out.println("Your answer is too low");
                    count++;
                }
                else if (guess > answer){
                    System.out.println("Your answer is too high");
                    count++;
                }
                else {
                    System.out.print("Good Job! " + name + " You guess my number in " + count + " guesses!");
                    if (count < 6) {
                        System.out.println(" Would you like to play again?");
                        String yes = input.next();
                        if (yes.equalsIgnoreCase("y")) {
                            answer = (int)(1 + Math.random() * 20);
                            count++;
                            System.out.print("Take a guess!");
                        }
                        else
                            break;
                    }
                }
                if (count == 6)
                    System.out.println("Last Round");
            }
            System.out.print("End of Game!");
            System.exit(0);
        }
        catch (Exception ex) {
            System.out.println("Incorrect Input: Make sure to use Only Numbers");
        }
    }
}