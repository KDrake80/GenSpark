import java.util.ArrayList;
/*
Kevin Drake
Class to define the Map for HumansVsGoblins
*/
public class GameMap {
    /*
    2-D array of "Things" 
    Dimensions of Array
    */
    private Thing[][] things;
    private int dimensions;
    // Constructor with Dimensions
    public GameMap(int dimensions){
        things = new Thing[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                things[i][j] = new Land();
            }
        }
        this.dimensions = dimensions;
    }
    /*
    Runs a nested for loop to print the Map
    */
    public void printMap(){
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++){
                 System.out.print(things[i][j] + "");
            }
            System.out.println();
        }
    }
    /*
    Method to Specifically place a HUMAN on the map
    taking in x, y coords. and the Player
    Moves the player, sets previous Tile to "Land"
    */
    public void setTile(int x, int y, Human p){
        int px = p.getX();
        int py = p.getY();
        things[x][y] = p;
        p.setX(x);p.setY(y);
        things[px][py] = new Land();
    }
    /*
    Method to clear the Tile, Just places a new Land at x, and y
    */
    public void clearTile(int x, int y){
        things[x][y] = new Land();
    }
    // Method to get the "Thing" object at x, y
    public Thing getSpace(int x, int y){
        return things[x][y];
    }
    /*
    Method to set the Tile with any humanoid
    and sets the Humanoid Object's x, and y
    */
    public void setSpace(int x, int y, Humanoid h){
        things[x][y] = h;
        h.setX(x);
        h.setY(y);
    }
    /*
        Runs a nested for loop to check if any enemies are on the board
        if there is an enemy, It returns true;
        if no enemies, returns false, and game ends
    */
    public boolean checkBoard(){
        boolean result = false;
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (things[i][j] instanceof Goblin) {
                    result = true;
                    break;
                }
                else
                    result = false;
            }
        }

        return result;
    }
    // Method to get Dimensions of map
    public int getDimensions() {
        return dimensions;
    }

}
