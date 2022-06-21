public class HumansVSGoblins {
    /*
    1. Everything must be objects, land, humans, goblins
    2. Must override the ToString() method in each, to represent the objects
    3. Create grid for game world
    4. Use UTF characters for players, and goblins, and land
    5. Game is turn based move: n/s/e/w
    6. Once human and goblin collide, battle is initiated
    7. combat use math.Random
    8. Extras:
        a. Humans have Inventory
        b. goblins have drops
        c. stats can be modified by equipment
        d. map generates random treasure chests after each combat
        e. goblins pursue the player.
     */
    char[][] world = new char[6][6];
    char[][][] regions = new char[9][2][2];
    char[] spaces = new char[36];
}
