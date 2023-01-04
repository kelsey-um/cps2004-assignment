import java.util.*;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int numberOfPlayers;
        int numberOfAI;
        int totalPlayers;

        System.out.println("-- Village War Game --\n");

        // number of players input
        System.out.println("Enter the number of players");
        while (true) { // loop to allow user to try again
            try {
                numberOfPlayers = sc.nextInt();

                if (numberOfPlayers < 1) { // at least 1 player
                    System.out.println("There must be at least 1 player. Please try again.");
                } else { // input is all valid
                    break;
                }
            } catch (InputMismatchException e) { // catch non-integes
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine(); // skip line
            }
        }

        // number of ai players input
        System.out.println("\nEnter number of AI players");
        while (true) { // loop to allow user to try again
            try {
                numberOfAI = sc.nextInt();
                break;
            } catch (InputMismatchException e) { // catch non-integes
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine(); // skip line
            }
        }

        HumanPlayer[] humanPlayerList = new HumanPlayer[numberOfPlayers];
        AIPlayer[] aiPlayerList = new AIPlayer[numberOfAI];

        totalPlayers = numberOfPlayers + numberOfAI;

        // generating map
        Map map = new Map();
        ArrayList<Integer> locations = new ArrayList<Integer>(); // array to store coordinates
        locations = map.initMap(totalPlayers);

        // declaring each player and their villages
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("\nEnter the name of player " + (i + 1)); // +1 so output is done properly
            String playerName = sc.next();

            int tempY = locations.remove(0);
            int tempX = locations.remove(0);
            byte tempID = (byte) (i + 1);

            humanPlayerList[i] = new HumanPlayer(tempID, playerName, tempX, tempY);
        }

        // creating ai players
        for (int i = 0; i < numberOfAI; i++) { // i set to numberOfPlayers to keep proper count in array
            String playerName = "Computer " + (i + numberOfPlayers + 1);

            int tempY = locations.remove(0);
            int tempX = locations.remove(0);
            byte tempID = (byte) (i + 1);

            aiPlayerList[i] = new AIPlayer(tempID, playerName, tempX, tempY);
        }

        map.printMap();

        // for(int i = 0 ; i < humanPlayerList.length ; i++){
        // System.out.println("\n\nName: " + humanPlayerList[i].playerName);
        // System.out.println("Location of village: ("+ humanPlayerList[i].locationX +
        // ", "+ humanPlayerList[i].locationY + ")");
        // }

        // for(int i = 0 ; i < aiPlayerList.length ; i++){
        // System.out.println("\n\nName: " + aiPlayerList[i].playerName);
        // System.out.println("Location of village: ("+ aiPlayerList[i].locationX + ",
        // "+ aiPlayerList[i].locationY + ")");
        // }

        sc.close();
    }

}