import java.util.List;

public class Player {
    String name;
    int hp = 100;
    int power = 1;
    int x, y;
    List<String> equipment;
    Map currentMap;

    Player(String name, Map currentMap) {
        this.currentMap = currentMap;
        this.name = name;
    }

    public void moveUp() {
        if(currentMap.isPlayerInRange(x, y++)) {
           y++;
        } else {
            System.out.println("Nice try, but there's nothing beyond the edge!");
        }
    }

    public void moveDown() {
        if(currentMap.isPlayerInRange(x, y--)) {
            y--;
        } else {
            System.out.println("Nice try, but there's nothing beyond the edge!");
        }
    }

    public void moveRight() {
        if(currentMap.isPlayerInRange(x++, y)) {
            x++;
        } else {
            System.out.println("Nice try, but there's nothing beyond the edge!");
        }
    }

    public void moveLeft() {
        if(currentMap.isPlayerInRange(x--, y)) {
            x--;
        } else {
            System.out.println("Nice try, but there's nothing beyond the edge!");
        }
    }

}