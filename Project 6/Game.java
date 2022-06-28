import java.util.Scanner;
/*
* Kevin Drake
* 6/28/22
* Main Class to run the Humans Vs Goblins game
*/
public class Game {
    /*
     Holds a GameMap grid instance
     Human instance as player
     Array of Goblins
     Current = the Goblin the Human attacks
    */
    GameMap world;
    Human player = new Human();
    Goblin[] enemies = new Goblin[3];
    Goblin current;
    // Constructor with a map dimension of 5
    public Game(){
        world = new GameMap(5);
        for (int i = 0; i <enemies.length ; i++) {
            enemies[i] = new Goblin();
        }
        world.setSpace(1, 1, player);
        world.setSpace(world.getDimensions() - 1, 1, enemies[0]);
        world.setSpace(world.getDimensions() - 1, 3, enemies[1]);
        world.setSpace(world.getDimensions() - 1, 4, enemies[2]);
        world.printMap();
    }
    // Constructor with custom map size
    public Game(int dim){
        world = new GameMap(dim);
        for (int i = 0; i <enemies.length ; i++) {
            enemies[i] = new Goblin();
        }
        world.setSpace(1, 1, player);
        world.setSpace(world.getDimensions() - 1, 1, enemies[0]);
        world.setSpace(world.getDimensions() - 1, 3, enemies[1]);
        world.setSpace(world.getDimensions() - 1, 4, enemies[2]);
        world.printMap();
    }
    // Method to play the Game, Uses a Scanner to get your Choice
    // runs a while loop, the loop exits either if the Human dies, or 
    // there are no goblins left on the Board
    public void playGame(){
        Scanner input = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Which direction? (N S W E) ");
                String s = input.nextLine().toUpperCase();
                char move = s.charAt(0);
                if (check(move)){
                    battle();
                }
                if (checkBoundaries(move)){
                   movePlayer(move);
                } else {
                    System.out.println("Cant Move That Direction");
                }
                world.printMap();
            }
            catch (Exception e){
                System.out.println("Illegal Argument: Please Use 1 Letter!");
            }
        }
    }
    
    // This is the Method to attack
    // If random == 1, Human Attacks, If random = 2 goblin attacks
    // If Humans health is 0, or the Board no longer contains goblins,
    // the Method exits the game, through System.exit(0)
    public void battle(){
        int random = (int)(1 + Math.random() * 2);
        if (random == 1)
            System.out.println(player.attack(current));
        else if (random == 2)
            current.attack(player);

        if (current.getHealth() <= 0){
            world.clearTile(current.getX(), current.getY());
        }
        if (player.getHealth() <= 0){
            System.out.println("Game Over! You Died!");
            System.exit(0);
        }
        if (!world.checkBoard()) {
            System.out.println("You Won! No more Goblins!");
            System.exit(1);
        }

    }
    /*
    Method to check the boundaries before the Player makes a move
    */
    public boolean checkBoundaries(char c) {
        if (c == 'N' && player.getX() > 0) {
            return true;
        } else if (c == 'S' && player.getX() < (world.getDimensions() - 1)) {
            return true;
        } else if (c == 'W' && player.getY() > 0) {
            return true;
        } else if (c == 'E' && player.getY() < (world.getDimensions() - 1)) {
            return true;
        } else {
            return false;
        }
    }
    /*
    Method to check if there is an Enemy near the player, I.e. An enemy is 1 Square ahead
        of the human whatever direction
    */
    public boolean check(char c){
        if (c == 'N' && world.getSpace(player.getX() - 1, player.getY()) instanceof Goblin){
            current = (Goblin)world.getSpace(player.getX() - 1, player.getY());
            return true;
        } else if (c == 'S' && world.getSpace(player.getX() + 1, player.getY()) instanceof Goblin) {
            current = (Goblin)world.getSpace(player.getX() + 1, player.getY());
            return true;
        } else if (c == 'W' && world.getSpace(player.getX(), player.getY() - 1) instanceof Goblin) {
            current = (Goblin)world.getSpace(player.getX(), player.getY() - 1);
            return true;
        } else if (c == 'E' && world.getSpace(player.getX(), player.getY() + 1) instanceof Goblin) {
            current = (Goblin)world.getSpace(player.getX(), player.getY() + 1);
            return true;
        }
        else {
            return false;
        }
    }
    /*
    Method to move the player. If the CheckBoundaries comes back true, And 
        Check(Enemy) Method is false. The Method moves the character
    */
    public void movePlayer(char c){
        switch (c){
            case 'N': world.setTile(player.getX() - 1, player.getY(), player); break;
            case 'S': world.setTile(player.getX() + 1, player.getY(), player); break;
            case 'W': world.setTile(player.getX(), player.getY() - 1, player); break;
            case 'E': world.setTile(player.getX(), player.getY() + 1, player); break;
        }
    }
    /*
     Main method to Test the Game
    */
    public static void main(String[] args){
        Game game = new Game();
        game.playGame();
    }
}
// Class to Define the Land Object and ToString Method
class Land extends Thing {
    public Land(){
        setValue("~");
    }
}
