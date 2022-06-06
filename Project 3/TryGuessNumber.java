package genspark.assignments.Projects;
import java.util.Scanner;
public class TryGuessNumber {
    private int answer = 0;
    private String name;

    public TryGuessNumber(){
        Scanner input = new Scanner(System.in);
        answer = (int)(1 + Math.random() * 20);
        System.out.print("Hello! What is your name?");
        setName(input.next());
        System.out.println("Well, " + name +  " I'm thinking of a number between 1 and 20.\nTake a guess");
        for (int i = 0; i != 6; i++) {
            try {
                int guess = input.nextInt();
                if (guess < answer) {
                    System.out.println("Your answer is too low");
                }
                else if (guess > answer){
                    System.out.println("Your answer is too high");
                }
                else {
                    System.out.print("Good Job! " + name + " You guess my number in " + i + " guesses!");
                    if (i < 6) {
                        System.out.println(" Would you like to play again?");
                        String yes = input.next();
                        if (yes.equalsIgnoreCase("y")) {
                            setNewAnswer();
                            System.out.println("Take a guess");
                        } else
                            break;
                    }
                }
            }
            catch (Exception e){
                System.out.println("Input Error: Please Retry");
            }
        }
    }

    public void setNewAnswer() {
        answer = (int)(1 + Math.random() * 20);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnswer() {
        return answer;
    }

    public String getName() {
        return name;
    }
}
