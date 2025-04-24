public class Map {
    int length = 5;
    int width = 5;
    char[][] mapMatrix = new char[length][width];

    public boolean isPlayerInRange(int x, int y) {
        return x < length && x >= 0 && y < width && y >= 0;
    }

}
