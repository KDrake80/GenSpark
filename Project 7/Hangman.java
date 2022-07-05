package Project7;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman {
    /*
    Refactor Hangman
        No loops, single master while loop, All loops must be
            Subsumed through map, filter, reduce

        Art for hangman should be read from a file, this art
            shows the game

        User should be able to enter Name, where name and score will be recorded
            in file after each game

        Game tells user if high score

        no exceptions, all must be caught

        add testing
     */
    List<Character> incorrect;
    HashMap correct;
    Scanner input = new Scanner(System.in);
    static String wordToGuess = "", name = "";
    static int score = 0;

    public void playGame() {
        incorrect = new ArrayList<>();
        System.out.println("Please enter your name: ");
        name = input.nextLine();
        wordToGuess = getWord();
        correct = new HashMap<Character, Integer>(wordToGuess.length());
        Stream.of(wordToGuess.toLowerCase().split(""))
                .forEach(e -> {
                    if (Character.isLetter(e.charAt(0))) {
                        correct.put(e.charAt(0), 0);
                    } else {
                        correct.put(e.charAt(0), 1);
                    }
                });
        playerGuess();
        if (!correct.containsValue(0)) {
            System.out.println(name + " Won!");
            //  calculateScore();
        } else {
            System.out.println("You Lost! Game Over! The word to guess was " + wordToGuess);
        }
        if (playAgain()){
            playGame();
        }
        else{
            System.out.println("Thanks for Playing!");
        }
    }

    public void calculateScore() {
        System.out.println("You missed " + incorrect.size() + " out of " + wordToGuess.length());
        score = wordToGuess.length() - incorrect.size();
    }

    public void playerGuess() {
        drawBoard(incorrect.size());
        printLetters();
        if (incorrect.size() != 6 && correct.containsValue(0)) {
            System.out.println("Take a guess: ");
            String g = input.nextLine().toLowerCase();
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

    public boolean checkValidity(String s) {
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

    public void printLetters() {
        // This will print out the letters every time its called, for incorrect/correct guesses
        Arrays.stream(wordToGuess.split("")).map(e -> (int) correct.get(e.charAt(0)) == 1 ? e : "_").forEach(System.out::print);
        System.out.println("Missed: " + incorrect);
    }

    public void drawBoard(int start) {
        List<String> list = new ArrayList<>();
        try {
            // Stream the file into a list for each line
            Stream<String> file = Files.lines(Path.of("HangmanArt.txt"));
            file.forEach(x -> list.add(x));
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public String getWord() {
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

    public void recordScores() {
        ArrayList<String> scores = new ArrayList<>();
        try {
            FileWriter output = new FileWriter("HangmanScores.txt");
            String s = name + " [Score: " + score + "]";
            output.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean playAgain() {
        System.out.println("Would you like to play Again? ");
        String answer = input.nextLine().toLowerCase();
        if (answer.charAt(0) == 'y'){
            return true;
        } else if (answer.charAt(0) == 'n') {
            return false;
        }
        else {
            System.out.println("Enter yes or no");
            playAgain();
        }
        return false;
    }

    public static void main(String[] args) {
        Hangman h = new Hangman();
        h.playGame();
    }
}
