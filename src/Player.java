import java.util.List;

public class Player {
    String name;
    int hp = 100;
    int power = 1;
    int x, y;
    List<String> equipment;
    Map currentMap;

    Player(String name, Map currentMap, int x, int y) {
        this.currentMap = currentMap;
        this.name = name;
        this.x = x;
        this.y = y;
    }


    public void move(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;

        if(currentMap.isPlayerInRange(newX, newY)) {
            this.x = newX;
            this.y = newY;
        } else {
            System.out.println("Nice try, but there's nothing beyond the edge!");
        }
    }
}