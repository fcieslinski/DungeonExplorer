import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map mapa = new Map();
        mapa.generateMap();

        System.out.println("> Enter your nickname: <");
        String nickname = sc.next();
        Player player = new Player(nickname, mapa, mapa.getPlayerStarX(), mapa.getPlayerStarY());
        System.out.println("Hello " + nickname + "!");
        mapa.showMap(player);
        while(true) {
            switch (sc.next()) {
                case "w" -> player.move(0, -1);
                case "s" -> player.move(0, 1);
                case "a" -> player.move(-1, 0);
                case "d" -> player.move(1, 0);
                default -> System.out.println("> Use 'w', 's', 'a', 'd' to make move. <");
            }
            mapa.showMap(player);
        }
    }
}
