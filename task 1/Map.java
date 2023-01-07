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

    private void updateMapString(int newX, int newY, int oldX, int oldY, int id) {

        String army = "A" + id;

        String cell = map[oldY][oldX];

        cell = cell.replaceFirst(army, "");
        map[oldY][oldX] = cell;

        if (map[oldY][oldX].isEmpty()) {

            map[oldY][oldX] = "--";

        }

        if (map[newY][newX] == "--") {

            map[newY][newX] = army;

        } else {

            map[newY][newX] += army;

        }

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

    public void addArmy(Army army) { // add army to map

        armiesList.add(army);

        // update string
        // map[army.getCurrentY()][army.getCurrentX()] += "A" +
        // army.getOwner().getPlayerID();

    }

    public void traverseArmies() {

        System.out.println("traversing");

        for (int i = 0; i < armiesList.size(); i++) {

            Army currentArmy = armiesList.get(i);
            int ownerID = currentArmy.getOwner().getPlayerID();

            int targetX = currentArmy.getTargetX();
            int targetY = currentArmy.getTargetY();

            int oldX = currentArmy.getCurrentX();
            int oldY = currentArmy.getCurrentY();

            int newX = oldX;
            int newY = oldY;

            int speed = currentArmy.getSpeed();

            if (oldX != targetX) { // if x is not same

                if (oldX > targetX) { // if current is larger than target

                    if ((oldX - targetX) < speed) { // if army is close enough to targetX that it can be done in
                                                    // less than 1 unit of speed

                        newX = targetX;
                        currentArmy.setCurrentX(newX);

                    } else { // move according to speed

                        newX = oldX - speed;
                        currentArmy.setCurrentX(newX);

                    }

                } else if (oldX < targetX) { // if current is smaller than target

                    if ((targetX - oldX) < speed) { // if army is close enough to target that it can be done in less
                                                    // than 1 unit of speed

                        newX = targetX;
                        currentArmy.setCurrentX(newX);

                    } else { // move according to speed

                        newX = oldX + speed;
                        currentArmy.setCurrentX(newX);

                    }

                }

            } else if (oldY != targetY) { // if y is not same

                if (oldY > targetY) { // if current is larger than target

                    if ((oldY - targetY) < speed) { // if army is close enough to targetX that it can be done in
                                                    // less than 1 unit of speed

                        newY = targetY;
                        currentArmy.setCurrentY(newY);

                    } else { // move according to speed

                        newY = oldY - speed;
                        currentArmy.setCurrentY(newY);
                    }

                } else if (oldY < targetY) { // if current is smaller than target

                    if ((targetY - oldY) < speed) { // if army is close enough to target that it can be done in less
                                                    // than 1 unit of speed

                        newY = targetY;
                        currentArmy.setCurrentY(newY);

                    } else { // move according to speed

                        newY = oldY + speed;
                        currentArmy.setCurrentY(newY);

                    }

                }

            }

            // updating map
            updateMapString(newX, newY, oldX, oldY, ownerID);
        }

    }

}