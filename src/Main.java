import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map mapa = new Map();
        mapa.generateMap();
        mapa.showMap();

        System.out.println("> Enter your nickname: <");
        String nickname = sc.next();
        Player player = new Player(nickname, mapa);
        while(true) {
            switch (sc.next()) {
                case "w":
                    player.moveUp();
                    mapa.showMap();
                    break;
                case "s":
                    player.moveDown();
                    mapa.showMap();
                    break;
                case "a":
                    player.moveLeft();
                    mapa.showMap();
                    break;
                case "d":
                    player.moveRight();
                    mapa.showMap();
                    break;
                default:
                    System.out.println("> Use 'w', 's', 'a', 'd' to make move. <");
                    break;
            }

        }
    }
}
