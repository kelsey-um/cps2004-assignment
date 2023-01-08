import java.util.*;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int numberOfPlayers;
        int numberOfHumans;
        int numberOfAI;

        System.out.println("-- Village War Game --\n");

        // number of players input
        System.out.println("Enter the number of players");
        while (true) { // loop to allow user to try again
            try {
                numberOfHumans = sc.nextInt();

                if (numberOfHumans < 1) { // at least 1 player
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

        ArrayList<HumanPlayer> humanPlayerList = new ArrayList<HumanPlayer>();
        ArrayList<AIPlayer> aiPlayerList = new ArrayList<AIPlayer>();

        numberOfPlayers = numberOfHumans + numberOfAI;

        // generating map
        Map map = new Map();
        ArrayList<Integer> locations = new ArrayList<Integer>(); // array to store coordinates
        locations = map.initMap(numberOfPlayers);

        // declaring each player and their villages
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("\nEnter the name of player " + (i + 1)); // +1 so output is done properly
            String playerName = sc.next();

            int tempY = locations.remove(0);
            int tempX = locations.remove(0);
            int tempID = (i + 1);

            humanPlayerList.add(new HumanPlayer(tempID, playerName, tempX, tempY));
        }

        // creating ai players
        for (int i = 0; i < numberOfAI; i++) { 
            String playerName = "Computer " + (i + numberOfHumans + 1);

            int tempY = locations.remove(0);
            int tempX = locations.remove(0);
            int tempID = (i + numberOfHumans +1);

            aiPlayerList.add(new AIPlayer(tempID, playerName, tempX, tempY));
        }

        // game loop

        while (humanPlayerList.size() > 1 || aiPlayerList.size() > 1) { // win condition check

            // loop for each player to take turn

            // marching
            map.traverseArmies();
            map.printMap();

            // human players
            for (int i = 0; i < humanPlayerList.size(); i++) {
                HumanPlayer currentPlayer = humanPlayerList.get(i);

                System.out.println("\nIt is " + currentPlayer.getPlayerName() + "'s turn");

                // resource earning
                currentPlayer.getVillage().resourceLoop();

                // player actions
                actions_loop: while (true) {
                    System.out.println("\nWhat would you like to do?");
                    System.out.println("1. Build building");
                    System.out.println("2. Upgrade building");
                    System.out.println("3. Train troops");
                    System.out.println("4. Attack village");
                    System.out.println("5. Surrender");
                    System.out.println("6. Pass");

                    int userChoice;

                    while (true) { // input loop
                        try {

                            userChoice = sc.nextInt();

                            if (userChoice < 1 || userChoice > 6) {
                                System.out.println("That is not a valid choice. Please try again.");
                            } else {

                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Input must be an integer. Please try again.");
                            sc.nextLine();
                        }
                    }

                    switch (userChoice) {

                        case 1: { // build
                            currentPlayer.getVillage().buildBuilding(sc);
                            break;
                        }

                        case 2: { // upgrade
                            currentPlayer.getVillage().upgradeBuilding(sc);
                            break;
                        }

                        case 3: { // train
                            currentPlayer.getVillage().trainTroops(sc);

                            break;
                        }

                        case 4: { // attack
                            currentPlayer.getVillage().createArmy(sc, humanPlayerList, currentPlayer, map);
                            break;
                        }

                        case 5: { // surrender
                            currentPlayer.getVillage().setHealth(0);
                            map.removeVillage(currentPlayer.getXCoordinate(), currentPlayer.getYCoordinate(),
                                    currentPlayer.getPlayerID());
                            break actions_loop;
                        }

                        case 6: { // pass
                            break actions_loop;
                        }

                        default: {
                            System.out.println("This should never print");
                        }

                    }

                }
            }

            for (int i = 0; i < humanPlayerList.size(); i++) { // remove any destroyed villages

                if (humanPlayerList.get(i).getVillage().getHealth() <= 0) {
                    humanPlayerList.remove(i);
                }

            }

            for(int i = 0 ; i < aiPlayerList.size() ; i++){

                if (aiPlayerList.get(i).getVillage().getHealth() <= 0) {
                    aiPlayerList.remove(i);
                }

            }

        }

        System.out.println("\n" + humanPlayerList.get(0).getPlayerName() + " has won the game!");

        sc.close();
    }

}