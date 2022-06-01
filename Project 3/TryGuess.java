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
			int count = 0;
			while (count <= 6) {
				int answer = (int)(1 + Math.random() * 5);
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
					count++;
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
			}
		}
		catch (Exception ex) {
			System.out.println("Incorrect Input: Please Reenter");
		}
	}
}

