import java.util.*;

public class Map {
    private int size = 15;
    private String[][] map = new String[size][size];
    
    private ArrayList<Army> armiesList = new ArrayList<Army>();

    private Boolean validatePos(int x, int y, int size) { // to check if array indexes go out of bounds

        if (x < 0 || y < 0 || x > size - 1 || y > size - 1) {
            return false;
        }

        return true;

    }

    public ArrayList<Integer> initMap(int totalPlayers) {

        Random rand = new Random();

        ArrayList<Integer> locations = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = "--";
            }
        }

        for (int i = 0; i < totalPlayers; i++) {

            boolean adjacent = false; // to use to check if adjacent village was found
            int randY = rand.nextInt(size); // random coordinates
            int randX = rand.nextInt(size);

            if (map[randY][randX] == "--") { // to check theres not village

                // check theres no village in adjacent

                // x-1 y-1
                if (validatePos(randX - 1, randY - 1, size) && adjacent == false) {
                    if (map[randY - 1][randX - 1] != "--") {
                        adjacent = true;
                    }
                }

                // x-1 y
                if (validatePos(randX - 1, randY, size) && adjacent == false) {
                    if (map[randY][randX - 1] != "--") {
                        adjacent = true;
                    }
                }

                // x-1 y+1
                if (validatePos(randX - 1, randY + 1, size) && adjacent == false) {
                    if (map[randY + 1][randX - 1] != "--") {
                        adjacent = true;
                    }
                }

                // x y-1
                if (validatePos(randX, randY - 1, size) && adjacent == false) {
                    if (map[randY - 1][randX] != "--") {
                        adjacent = true;
                    }
                }

                // x y+1
                if (validatePos(randX, randY + 1, size) && adjacent == false) {
                    if (map[randY + 1][randX] != "--") {
                        adjacent = true;
                    }
                }

                // x+1 y-1
                if (validatePos(randX + 1, randY - 1, size) && adjacent == false) {
                    if (map[randY - 1][randX + 1] != "--") {
                        adjacent = true;
                    }
                }

                // x+1 y
                if (validatePos(randX + 1, randY, size) && adjacent == false) {
                    if (map[randY][randX + 1] != "--") {
                        adjacent = true;
                    }
                }

                // x+1 y+1
                if (validatePos(randX + 1, randY + 1, size) && adjacent == false) {
                    if (map[randY + 1][randX + 1] != "--") {
                        adjacent = true;
                    }
                }

                if (adjacent == false) {
                    map[randY][randX] = "V" + (i + 1);

                    locations.add(randY);
                    locations.add(randX);
                } else {
                    i--;
                }

            } else { // village was not created
                i--;
            }

        }

        return locations; // returning arraylist with coordinates
    }

    public void printMap() {

        // corner
        System.out.print("--  ");

        // display numbers on top
        for (int i = 0; i < size; i++) {
            if (i < 10) {
                System.out.print("0" + i + "  ");
            } else {
                System.out.print(i + "  ");
            }

        }

        System.out.println();

        for (int i = 0; i < size; i++) {

            // numbers on side
            if (i < 10) {
                System.out.print("0" + i + "  ");
            } else {
                System.out.print(i + "  ");
            }

            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

    }

    public void addArmy(Army army){ //add army to map

        armiesList.add(army);

        //update string
        // map[army.getCurrentY()][army.getCurrentX()] += "A" + army.getOwner().getPlayerID();

    }

    public void traverseArmies(){
        
    }

}
