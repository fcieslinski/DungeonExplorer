import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Map {
    int ySize = 5;
    int xSize = 5;
    char[][] mapMatrix = new char[ySize][xSize];

    public boolean isPlayerInRange(int x, int y) {
        return x < ySize && x >= 0 && y < xSize && y >= 0;
    }

    public void showMap() {
        for(int i = 0; i < ySize; i++) {
            for(int j = 0; j < xSize; j++) {
                System.out.printf("%c ", mapMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void generateMap() {
        Random random = new Random();
        int fields = xSize * ySize - 1; //player occupies one field
        int opponents = random.nextInt(fields/3 - 3) + 3;
        int lootFields = random.nextInt(fields - opponents) + 1; //todo: change ratio
        int emptyFields = fields - opponents - lootFields;

        List<Field> fieldList = new ArrayList<>();

        for(int y = 0; y < ySize; y++) {
            for(int x = 0; x < xSize; x++) {
                fieldList.add(new Field(x, y));
            }
        }

        Collections.shuffle(fieldList);


    }

    private class Field {
        int x, y;
        char type = '?';
        Field(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
