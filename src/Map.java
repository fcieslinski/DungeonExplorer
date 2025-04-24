import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Map {
    int ySize = 5;
    int xSize = 5;
    Field[][] mapMatrix = new Field[ySize][xSize];

    public boolean isPlayerInRange(int x, int y) {
        return x < ySize && x >= 0 && y < xSize && y >= 0;
    }

    public void showMap() {
        for(int i = 0; i < ySize; i++) {
            for(int j = 0; j < xSize; j++) {
                System.out.printf("%c ", mapMatrix[i][j].type);
            }
            System.out.println();
        }
    }

    public void generateMap() {
        Random random = new Random();
        int fields = xSize * ySize - 1; //player occupies one field
        int opponents = random.nextInt(fields/3 - 3) + 3;
        int lootFields = random.nextInt(fields - opponents) + 1; //todo: change ratio

        List<Field> fieldList = new ArrayList<>();

        for(int y = 0; y < ySize; y++) {
            for(int x = 0; x < xSize; x++) {
                mapMatrix[y][x] = new Field(x, y);
                fieldList.add(mapMatrix[y][x]);
            }
        }
        Collections.shuffle(fieldList);

        for (int i = 0; i < fieldList.size(); i++) {
            Field f = fieldList.get(i);

            if (i < lootFields) {
                f.type = '$';
            } else if (i < lootFields + opponents) {
                f.type = 'W';
            } else {
                f.type = '.';
            }
        }
        }
    }

    class Field {
        int x;
        int y;
        //boolean isUncovered = false;
        char type = '?';
        Field(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

