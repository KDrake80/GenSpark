
import java.util.Scanner;
public class TryGuessNumber {
    private int answer = 0;
    private String name;

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
    public void setAnswer(int answer) {
        // Created Specifically for the JUnit tests. Just So I can make can Assert.
        this.answer = answer;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        answer = (int)(1 + Math.random() * 20);
        System.out.println("Hello! What is your name?");
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
                    System.out.println("Good Job! " + name + " You guess my number in " + i + " guesses!");
                    if (i < 6) {
                        System.out.println("Would you like to play again?");
                        String yes = input.next();
                        if (yes.equalsIgnoreCase("y")) {
                            answer = (int)(1 + Math.random() * 20);
                            System.out.println("Take a guess");
                        } else
                            break;
                    }
                }
            }
            catch (Exception e){
                System.out.println("Input Error: Only Input Numbers");
                System.exit(0);
            }
        }
    }
}
 class TestGuess {
    public static void main(String[] args){
        TryGuessNumber t = new TryGuessNumber();
        t.run();
    }
}