import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author KevinD
 * 6/15/2022
 * Hangman Class. This class defines the game of Hangman
 */
public class Hangman {
    /**
     * List of words to use.
     */
    private ArrayList<String> words;
    /**
     * This is the board for hangman.
     */
    private String[][] board = {
            {" ", " ", " ", " ", "*", "-", "-", "-", "+"},
            {" ", " ", " ", " ", "*", " ", " ", " ", "|"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "|"},
            {"[", "*", "=", "*", "=", "*", "=", "*", "]"},
    };
    /**
     * The word you are trying to guess.
     */
    private String word;
    /**
     * Array List of Strings, this one is correct Guesses.
     */
    private ArrayList<String> correct;
    /**
     * This one is the incorrect Guesses.
     */
    private ArrayList<String> incorrect;
    /**
     * This is the amount of incorrect chances, each "life" is a body part added to the board.
     */
    private int lives = 6;

    /**
     * Default Constructor. Creates all arraylists, adds words to list of words. Sets one of them randomly as the
     * word to guess. Sets '-' character to the correct guesses, the amount of letters in the word to guess.
     * Finally, prints the board the first time.
     */
    public Hangman() {
        words = new ArrayList<>();
        correct = new ArrayList<>();
        incorrect = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        int random = ThreadLocalRandom.current().nextInt(0, 2);
        word = words.get(random);
        for (int i = 0; i < word.length(); i++)
            correct.add("-");

        printBoard();
    }

    /**
     * This method prints the Board. Nested for loop, to print the two-dimensional array.
     * Also prints the correct list, and incorrect list.
     */
    public void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + "");
            }
            System.out.println();
        }
        System.out.println("Correct: \n" + correct.toString());
        System.out.println("Incorrect: \n" + incorrect.toString());
    }

    /**
     * This method changes the board. Depending on what "life" you're on. It will run it through a switch-expression
     * Placing the correct body part with the corresponding life.
     */
    public void changeBoard() {
        switch (lives) {
            case 6:
                board[2][4] = "0";
                System.out.println("Is that a head or a zero?");
                break;
            case 5:
                board[3][4] = "|";
                System.out.println("Body..... or line?");
                break;
            case 4:
                board[3][3] = "-";
                System.out.println("Left ARRRRMMM");
                break;
            case 3:
                board[3][5] = "-";
                System.out.println("I dont see how dashes make a hang, but here's a right one!");
                break;
            case 2:
                board[4][3] = "/";
                System.out.println("Left leg");
                System.out.println("Last Chance!");
                break;
            case 1:
                board[4][5] = "\\";
                System.out.println("And that's a right leg.");
                System.out.println("GameOver!");
                System.exit(0);
        }
        printBoard();
        setLives();
    }

    /**
     * Checks the guess the user has input
     *
     * @param c, String. This checks to see if the word to guess contains the guessed letter.
     * @return true if it contains, false if not. Also, sets the index of Correct list with the correct guessed letter.
     * Or it changes the board and adds the incorrect guess to that list.
     */
    public boolean checkGuess(String c) {
        int index = 0;
        if (word.contains(c)) {
            index = word.indexOf(c);
            correct.set(index, c);
            printBoard();
            return true;
        } else {
            incorrect.add(c);
            changeBoard();
            return false;
        }
    }

    /**
     * Getter for word to guess
     *
     * @return word, String.
     */
    public String getWord() {
        return word;
    }

    /**
     * Optional method, Sets the word to whatever word you would like.
     *
     * @param word, String. New Optional Word.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * This gets the life count
     *
     * @return lives, int. Counts down depending on how many incorrect guesses you've made.
     */
    public int getLives() {
        return lives;
    }

    /**
     * Method to decrement the life count.
     */
    public void setLives() {
        lives--;
    }

    /**
     * Getter for guessed WORD not letters, Takes the List, and turns into a String
     *
     * @return result, String made out of the list of guessed letters
     */
    public String getGuesses() {
        String result = "";
        for (int i = 0; i < correct.size(); i++) {
            result = result + "" + correct.get(i);
        }
        return result;
    }
}

/**
 * Just an Inner class created to run the Hangman game
 */
class RunHangman {
    /**
     * Main method to run Game
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Creates Instance of Hangman and Scanner, Scanner is to get the guesses from user.
         */
        Scanner input = new Scanner(System.in);
        Hangman h = new Hangman();
        /**
         * Put into a Try-Catch for the input
         */
        try {
            while (h.getLives() > 0) {
                System.out.println("Take a guess: ");
                String guess = input.nextLine();
                h.checkGuess(guess);
                if (h.getWord().equals(h.getGuesses())) {
                    System.out.println("Yay! You got it! Good Job!");
                    System.exit(1);
                }

            }
            /**
             * Error Message for Incorrect Input.
             */
        } catch (Exception e) {
            System.out.print("Incorrect Input!");
        }
    }
}