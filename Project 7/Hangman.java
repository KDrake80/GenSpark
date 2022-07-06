package Project7;

import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Kevin Drake
    7/6/22
 */
public class Hangman {
    // Static Data Fields, so I can process them in Static methods
    static List<Character> incorrect;
    static HashMap correct;
    static Scanner input = new Scanner(System.in);
    static String wordToGuess = "", name = "";
    static int score = 0;

    // Main Run Method, PlayGame, Initializes all variables and begins game
    public static void playGame() {
        incorrect = new ArrayList<>();
        System.out.println("Please enter your name: ");
        // Method call for Input, this is So I can have one method, with one Try/Catch
        // Statement on the input, instead of having multiple throughout the game
        name = getInput();
        // Randomly Generate word from File, Method call
        wordToGuess = getWord();
        correct = new HashMap<Character, Integer>(wordToGuess.length());
        // Split word up
        Stream.of(wordToGuess.toLowerCase().split(""))
                .forEach(e -> {
                    if (Character.isLetter(e.charAt(0))) {
                        correct.put(e.charAt(0), 0);
                    } else {
                        correct.put(e.charAt(0), 1);
                    }
                });
        // Call Recursive Method to begin Guessing
        playerGuess();
        if (!correct.containsValue(0)) {
            System.out.println(name + " Won!");
            calculateScore();
        } else {
            System.out.println("You Lost! Game Over! The word to guess was " + wordToGuess);
        }
        if (playAgain()) {
            playGame();
        } else {
            System.out.println("Thanks for Playing!");
        }
    }

    // Define Player Guess
    public static void playerGuess() {
        drawBoard(incorrect.size());
        printLetters();
        if (incorrect.size() != 6 && correct.containsValue(0)) {
            System.out.println("Take a guess: ");
            String g = getInput().toLowerCase();
            if (checkValidity(g)) {
                char guess = g.charAt(0);
                if (correct.containsKey(guess)) {
                    correct.put(guess, 1);
                } else {
                    incorrect.add(guess);
                }
            }
            playerGuess();
        }
    }

    // Definition of CheckValid on input
    public static boolean checkValidity(String s) {
        if (s.length() != 1 || !Character.isLetter(s.charAt(0))) {
            System.out.println("Please Enter a Valid Guess, 1 Letter!");
            return false;
        } else {
            if (incorrect.contains(s.charAt(0)) || correct.containsKey(s.charAt(0)) &&
                    (int) correct.get(s.charAt(0)) == 1) {
                System.out.println("Letter already guessed. Please Try Again!");
                return false;
            }
        }
        return true;
    }

    // PrintLetter Method
    public static void printLetters() {
        // This will print out the letters every time its called, for incorrect/correct guesses
        Arrays.stream(wordToGuess.split(""))
                .map(e -> (int) correct.get(e.charAt(0)) == 1 ? e : "_")
                .forEach(System.out::print);
        System.out.println("\tMissed: " + incorrect);
    }

    //Get Board from file, Compare to IncorrectList Size, Print out
    //Specific 7 lines from File
    public static void drawBoard(int start) {
        List<String> list = new ArrayList<>();
        try {
            // Stream the file into a list for each line
            Stream<String> file = Files.lines(Path.of("HangmanArt.txt"));
            file.forEach(x -> list.add(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (start) {
            case 1:
                start = 7;
                break;
            case 2:
                start = 14;
                break;
            case 3:
                start = 21;
                break;
            case 4:
                start = 28;
                break;
            case 5:
                start = 35;
                break;
            case 6:
                start = 42;
                break;
            default:
                start = 0;
        }
        List<String> board = list.subList(start, start + 7);
        Arrays.stream(board.toArray())
                .forEach(s -> System.out.println(s.toString()));
    }

    public static String getWord() {
        // Gets a Random Word from the File, to guess
        // Create a new List
        List<String> words = new ArrayList<>();
        try {
            // Store elements from File, into the list
            Stream<String> s = Files.lines(Path.of("HangmanWords.txt"));
            words = s.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Create a random integer, from 0 - (the number of words, held in file)
        int random = ThreadLocalRandom.current().nextInt(0, 17);
        // Return the word at list.get(random index)
        return words.get(random);
    }

    public static boolean playAgain() {
        // PlayAgain Method
        System.out.println("Would you like to play Again? ");
        String answer = getInput().toLowerCase();
        if (answer.charAt(0) == 'y') {
            return true;
        } else if (answer.charAt(0) == 'n') {
            return false;
        } else {
            System.out.println("Enter yes or no");
            playAgain();
        }
        return false;
    }

    // Compare Scores to print out HighScore or not
    public static void compareScores() {
        List<String> scores = new ArrayList<>();
        try {
            scores = new ArrayList<>(Files.lines(Path.of("HangmanScores.txt")).toList());
            if (score >= getScoreFromFile(scores.get(0))) {
                System.out.println("Congratulations! You got the Highest Score!");
                scores.add(0, name + " | " + score + " | " + wordToGuess);
            } else if (score >= getScoreFromFile(scores.get(1))) {
                System.out.println("WOOOOOOOO! You got the Second Place!");
                scores.add(1, name + " | " + score + " | " + wordToGuess);
            } else if (score >= getScoreFromFile(scores.get(2))) {
                System.out.println("Nice! Third Place!");
                scores.add(2, name + " | " + score + " | " + wordToGuess);
            } else {
                System.out.println("Didn't make top 3, but Good Job!!!");
                scores.add(name + " | " + score + " | " + wordToGuess);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter output = new FileWriter("HangmanScores.txt");
            scores.stream().forEach(e -> {
                try {
                    output.write(e + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parses Integer for whatever Score needed
    public static int getScoreFromFile(String s) {
        String[] result = s.split("\\|");
        return Integer.parseInt(result[1].trim());
    }

    // Calculate this specific score
    public static void calculateScore() {
        score = 800 - (incorrect.size() * 100);
        System.out.println("Your score is " + score);
        compareScores();
    }

    // Get Input method, with Try/Catch inside
    public static String getInput() {
        try {
            return input.nextLine();
        } catch (Exception e) {
            System.out.println("Input Error: Retry!");
            getInput();
        }
        return null;
    }

    // Main method to play the game.
    public static void main(String[] args) {
        Hangman.playGame();
    }
}
