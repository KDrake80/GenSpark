import java.util.ArrayList;

public class GameMap {
    private Thing[][] things;
    private int dimensions;
    public GameMap(int dimensions){
        things = new Thing[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                things[i][j] = new Land();
            }
        }
        this.dimensions = dimensions;
    }
    public void printMap(){
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++){
                 System.out.print(things[i][j] + "");
            }
            System.out.println();
        }
    }
    public void setTile(int x, int y, Human p){
        int px = p.getX();
        int py = p.getY();
        things[x][y] = p;
        p.setX(x);p.setY(y);
        things[px][py] = new Land();
    }
    public void clearTile(int x, int y){
        things[x][y] = new Land();
    }

    public Thing getSpace(int x, int y){
        return things[x][y];
    }
    public void setSpace(int x, int y, Humanoid h){
        things[x][y] = h;
        h.setX(x);
        h.setY(y);
    }
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

    public int getDimensions() {
        return dimensions;
    }

}
