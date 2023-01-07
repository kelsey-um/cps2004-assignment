import java.util.*;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int numberOfPlayers;

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

        /*
         * // number of ai players input
         * System.out.println("\nEnter number of AI players");
         * while (true) { // loop to allow user to try again
         * try {
         * numberOfAI = sc.nextInt();
         * break;
         * } catch (InputMismatchException e) { // catch non-integes
         * System.out.println("Input must be an integer. Please try again.");
         * sc.nextLine(); // skip line
         * }
         * }
         */

        HumanPlayer[] humanPlayerList = new HumanPlayer[numberOfPlayers];

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

            humanPlayerList[i] = new HumanPlayer(tempID, playerName, tempX, tempY);
        }

        /*
         * // creating ai players
         * for (int i = 0; i < numberOfAI; i++) { // i set to numberOfPlayers to keep
         * proper count in array
         * String playerName = "Computer " + (i + numberOfPlayers + 1);
         * 
         * int tempY = locations.remove(0);
         * int tempX = locations.remove(0);
         * int tempID = (i + 1);
         * 
         * aiPlayerList[i] = new AIPlayer(tempID, playerName, tempX, tempY);
         * }
         */

        int villagesLeft = numberOfPlayers;

        // game loop

        while (villagesLeft > 1) { // win condition check

            // loop for each player to take turn
            map.printMap();

            // human players
            for (int i = 0; i < humanPlayerList.length; i++) {
                HumanPlayer currentPlayer = humanPlayerList[i];

                System.out.println("\nIt is " + currentPlayer.getPlayerName() + "'s turn");

                if (currentPlayer.getVillage().getHealth() > 0) { // to check village is not destoryed
                    // friendly troop arrival

                    // enemy troop arrival

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
                                break;
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

            }

            // marching
            map.traverseArmies();

        }

        sc.close();
    }

}