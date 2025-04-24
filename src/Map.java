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
                if(mapMatrix[i][j].isUncovered) {
                    System.out.printf("%c ", mapMatrix[i][j].type);
                } else {
                    System.out.printf("? ");
                }
            }
            System.out.println();
        }
    }

    public void generateMap() {
        Random random = new Random();
        int fields = xSize * ySize - 1; //player occupies one field
        int opponents = random.nextInt(fields/6) + 4;
        int lootFields = random.nextInt(opponents) + 2; //todo: change ratio

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
                f.type = '$'; //loot
            } else if (i < lootFields + opponents) {
                f.type = 'W'; //opponent
            } else if (i == fieldList.size() - 1) {
                f.type = '@'; //player
                f.isUncovered = true;
            } else {
                f.type = '.'; //empty
            }
        }
        }
    }

    class Field {
        int x;
        int y;
        boolean isUncovered = false;
        char type;
        Field(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

