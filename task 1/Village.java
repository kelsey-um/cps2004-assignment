import java.util.*;

public class Village {

    private int health;
    private Resources resources;
    private Troops troops;

    private ArrayList<Building> buildings = new ArrayList<Building>();
    private TroopBuilding barracks = null;
    private TroopBuilding archeryRange = null;
    private TroopBuilding stables = null;

    public Village() {
        this.health = 100;
        this.troops = new Troops();
        this.resources = new Resources();
    }

    private void printNumberedBuildings() {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + buildings.get(i).getBuildingType() + " "
                            + buildings.get(i).getBuildingID());
            System.out.println("Level: " + buildings.get(i).getBuildingLevel() + "\n");
        }
    }

    public void buildBuilding(Scanner sc) {

        int userChoice;

        outer_loop: while (true) {

            resources.printResources();

            System.out.println("Which building would you like to build?\n");

            System.out.println("1. Farm");
            System.out.println("Cost: 20 wood, 20 food, 10 metal\n");

            System.out.println("2. Lumber Mill");
            System.out.println("Cost: 20 wood, 10 food, 20 metal\n");

            System.out.println("3. Forge");
            System.out.println("Cost: 10 wood, 10 food, 40 metal\n");

            if (barracks == null) {
                System.out.println("4. Barracks");
                System.out.println("Cost: 20 wood, 80 food, 40 metal\n");
            }

            if (archeryRange == null) {
                System.out.println("5. Archery Range");
                System.out.println("Cost: 80 wood, 40 food, 20 metal\n");
            }

            if (stables == null) {
                System.out.println("6. Stables");
                System.out.println("Cost: 80 wood, 60 food, 20 metal\n");
            }

            System.out.println("0. Back");

            while (true) { // input loop
                try {

                    userChoice = sc.nextInt();

                    if (userChoice < 0 || userChoice > 6) {
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

                case 1: { // farm

                    if (resources.getWood() >= 20 && resources.getFood() >= 20 && resources.getMetal() >= 10) {

                        ResourceBuilding tempBuild = new ResourceBuilding("Farm", (buildings.size() + 1));
                        buildings.add(tempBuild);

                        resources.decreaseWood(20);
                        resources.decreaseFood(20);
                        resources.decreaseMetal(10);

                        System.out.println("\nYou have successfully built a new farm!");

                        break outer_loop;

                    } else {

                        System.out.println("Sorry, you don't have enough resources to do that.");

                    }

                    break;
                }

                case 2: { // lumber mill

                    if (resources.getWood() >= 20 && resources.getFood() >= 10 && resources.getMetal() >= 20) {

                        ResourceBuilding tempBuild = new ResourceBuilding("Lumber Mill", (buildings.size() + 1));
                        buildings.add(tempBuild);

                        resources.decreaseWood(20);
                        resources.decreaseFood(10);
                        resources.decreaseMetal(20);

                        System.out.println("\nYou have successfully built a new lumber mill!");

                        break outer_loop;

                    } else {

                        System.out.println("\nSorry, you don't have enough resources to do that.");

                    }

                }

                case 3: { // forge

                    if (resources.getWood() >= 10 && resources.getFood() >= 10 && resources.getMetal() >= 40) {

                        ResourceBuilding tempBuild = new ResourceBuilding("Forge", (buildings.size() + 1));
                        buildings.add(tempBuild);

                        resources.decreaseWood(10);
                        resources.decreaseFood(10);
                        resources.decreaseMetal(40);

                        System.out.println("You have successfully built a new forge!");

                        break outer_loop;

                    } else {

                        System.out.println("Sorry, you don't have enough resources to do that.");

                    }

                    break;
                }

                case 4: { // barracks
                    if (barracks == null) {
                        if (resources.getWood() >= 20 && resources.getFood() >= 80 && resources.getMetal() >= 40) {

                            barracks = new TroopBuilding("Barracks", (buildings.size() + 1));
                            buildings.add(barracks);

                            resources.decreaseWood(20);
                            resources.decreaseFood(80);
                            resources.decreaseMetal(40);

                            System.out.println("\nYou have successfully built the barracks!");

                            break outer_loop;

                        } else {

                            System.out.println("Sorry, you don't have enough resources to do that.\n");

                        }
                    } else {
                        System.out.println("The barracks have already been built!\n");

                        break outer_loop;
                    }

                    break;
                }

                case 5: { // archery range
                    if (archeryRange == null) {
                        if (resources.getWood() >= 80 && resources.getFood() >= 40 && resources.getMetal() >= 20) {

                            archeryRange = new TroopBuilding("Archery Range", (buildings.size() + 1));
                            buildings.add(archeryRange);

                            resources.decreaseWood(80);
                            resources.decreaseFood(40);
                            resources.decreaseMetal(20);

                            System.out.println("\nYou have successfully built the archery range!");

                            break outer_loop;

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.\n");

                        }
                    } else {
                        System.out.println("The archery range has already been built!\n");

                        break outer_loop;
                    }

                    break;
                }

                case 6: { // stables
                    if (stables == null) {
                        if (resources.getWood() >= 80 && resources.getFood() >= 60 && resources.getMetal() >= 20) {

                            stables = new TroopBuilding("Stables", (buildings.size() + 1));
                            buildings.add(stables);

                            resources.decreaseWood(80);
                            resources.decreaseFood(60);
                            resources.decreaseMetal(20);

                            System.out.println("You have successfully built the stables!");

                            break outer_loop;

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.\n");

                        }
                    } else {

                        System.out.println("The stables have already been built!\n");

                        break outer_loop;

                    }

                    break;
                }

                case 0: { // back
                    break outer_loop;
                }

                default: {
                    System.out.println("This should never be printed");
                }

            }

        }

    }

    public void upgradeBuilding(Scanner sc) {

        int userChoice;

        if (buildings.size() > 0) { // to check there are buildings

            System.out.println("\nUpgrade Costs:\n");
            System.out.println("Farm: \t\t10 wood 10 food  5 metal");
            System.out.println("Lumber Mill: \t10 wood  5 food 10 metal");
            System.out.println("Forge: \t\t 5 wood  5 food 20 metal");
            System.out.println("Barracks: \t10 wood 40 food 20 metal");
            System.out.println("Archery Range: \t40 wood 20 food 10 metal");
            System.out.println("Stables: \t40 wood 30 food 10 metal");

            resources.printResources();

            System.out.println("Which building would you like to upgrade?\n");

            printNumberedBuildings();

            while (true) { // input loop
                try {

                    userChoice = sc.nextInt();

                    if (userChoice < 1 || userChoice > (buildings.size() + 1)) {
                        System.out.println("That is not a valid choice. Please try again.");
                    } else {
                        userChoice--; // since arraylist starts from 0
                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input must be an integer. Please try again.");
                    sc.nextLine();
                }
            }

            if (buildings.get(userChoice).getBuildingLevel() < 5) { // check if building is at max level

                String buildingType = buildings.get(userChoice).getBuildingType();

                switch (buildingType) {
                    case "Farm": {

                        if (resources.getWood() >= 10 && resources.getFood() >= 10 && resources.getMetal() >= 5) {

                            buildings.get(userChoice).increaseLevel(); // increase level by 1

                            resources.decreaseWood(10); // decrease resources according to cost
                            resources.decreaseFood(10);
                            resources.decreaseMetal(5);

                            System.out.println("\nYou have successfully upgraded your farm!");

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }

                        break;
                    }

                    case "Lumber Mill": {

                        if (resources.getWood() >= 10 && resources.getFood() >= 5 && resources.getMetal() >= 10) {

                            buildings.get(userChoice).increaseLevel(); // increase level by 1

                            resources.decreaseWood(10); // decrease resources according to cost
                            resources.decreaseFood(5);
                            resources.decreaseMetal(10);

                            System.out.println("\nYou have successfully upgraded your lumber mill!");

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }

                        break;
                    }

                    case "Forge": {

                        if (resources.getWood() >= 5 && resources.getFood() >= 5 && resources.getMetal() >= 20) {

                            buildings.get(userChoice).increaseLevel(); // increase level by 1

                            resources.decreaseWood(5); // decrease resources according to cost
                            resources.decreaseFood(5);
                            resources.decreaseMetal(20);

                            System.out.println("\nYou have successfully upgraded your forge!");

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }

                        break;
                    }

                    case "Barracks": {

                        if (resources.getWood() >= 10 && resources.getFood() >= 40 && resources.getMetal() >= 10) {

                            buildings.get(userChoice).increaseLevel(); // increase level by 1

                            resources.decreaseWood(10); // decrease resources according to cost
                            resources.decreaseFood(40);
                            resources.decreaseMetal(10);

                            System.out.println("\nYou have successfully upgraded your barracks!");

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }

                        break;
                    }

                    case "Archery Range": {

                        if (resources.getWood() >= 40 && resources.getFood() >= 20 && resources.getMetal() >= 10) {

                            buildings.get(userChoice).increaseLevel(); // increase level by 1

                            resources.decreaseWood(40); // decrease resources according to cost
                            resources.decreaseFood(20);
                            resources.decreaseMetal(10);

                            System.out.println("\nYou have successfully upgraded your archery range!");

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }

                        break;
                    }

                    case "Stables": {

                        if (resources.getWood() >= 40 && resources.getFood() >= 30 && resources.getMetal() >= 10) {

                            buildings.get(userChoice).increaseLevel(); // increase level by 1

                            resources.decreaseWood(40); // decrease resources according to cost
                            resources.decreaseFood(30);
                            resources.decreaseMetal(10);

                            System.out.println("\nYou have successfully upgraded your stables!");

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }

                        break;
                    }

                    default: {
                        System.out.println("This should never print");
                    }
                }

            } else {
                System.out.println("This building is already at its max level!");
            }
        } else {

            System.out.println("You currently don't have any buildings in your village!");

        }
    }

    public void trainTroops(Scanner sc) {

        int userChoice;

        outer_loop: while (true) {
            // to check there is at least one troop building
            if (barracks != null || archeryRange != null || stables != null) {

                resources.printResources();

                System.out.println("Which troop would you like to train?");

                if (barracks != null) {
                    System.out.println("1. Swordsman");
                    System.out.println("Cost: 10 wood, 10 food, 20 metal\n");
                }

                if (archeryRange != null) {
                    System.out.println("2. Archer");
                    System.out.println("Cost: 10 wood, 20 food, 5 metal\n");
                }

                if (stables != null) {
                    System.out.println("3. Cavalry");
                    System.out.println("Cost: 10 wood, 40 food, 10 metal\n");
                }

                System.out.println("0. Back");

                while (true) { // input loop
                    try {

                        userChoice = sc.nextInt();

                        if (userChoice < 0 || userChoice > 3) {
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

                    case 1: { // swordsmen

                        resources.printResources();

                        if (barracks != null) {

                            int buildingLevel = barracks.getBuildingLevel();

                            System.out.println(
                                    "How many swordsmen would you like to train? Max: " + (buildingLevel * 10));
                            System.out.println("Cost: 10 wood, 10 food, 20 metal");

                            while (true) { // input loop
                                try {

                                    int amountToTrain = sc.nextInt();

                                    if (amountToTrain < 1 || amountToTrain > (buildingLevel * 10)) {
                                        System.out.println("\nSorry, the maximum amount of troops you can train is "
                                                + (buildingLevel * 10));
                                        break outer_loop;
                                    } else {

                                        if (resources.getWood() >= (10 * amountToTrain)
                                                && resources.getFood() >= (10 * amountToTrain)
                                                && resources.getMetal() >= (20 * amountToTrain)) {

                                            System.out.println("\nYou have successfully trained " + amountToTrain
                                                    + " swordsmen.\n");

                                            resources.decreaseWood(10 * amountToTrain);
                                            resources.decreaseFood(10 * amountToTrain);
                                            resources.decreaseMetal(20 * amountToTrain);

                                            troops.trainSwordsmen(amountToTrain);

                                        } else {
                                            System.out
                                                    .println("\nSorry, you don't have enough resources to do that.\n");

                                        }

                                        break outer_loop;
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Input must be an integer. Please try again.");
                                    sc.nextLine();
                                }
                            }

                        } else {

                            System.out.println("You need to build the barracks first!");

                        }

                        break;

                    }

                    case 2: { // archers

                        resources.printResources();

                        if (archeryRange != null) {

                            int buildingLevel = archeryRange.getBuildingLevel();

                            System.out
                                    .println("How many archers would you like to train? Max: " + (buildingLevel * 10));
                            System.out.println("Cost: 10 wood, 20 food, 5 metal");

                            while (true) { // input loop
                                try {

                                    int amountToTrain = sc.nextInt();

                                    if (amountToTrain < 1 || amountToTrain > (buildingLevel * 10)) {
                                        System.out.println("\nSorry, the maximum amount of troops you can train is "
                                                + (buildingLevel * 10));
                                        break outer_loop;
                                    } else {

                                        if (resources.getWood() >= (10 * amountToTrain)
                                                && resources.getFood() >= (20 * amountToTrain)
                                                && resources.getMetal() >= (5 * amountToTrain)) {

                                            System.out.println(
                                                    "\nYou have successfully trained " + amountToTrain + " archers.\n");

                                            resources.decreaseWood(10 * amountToTrain);
                                            resources.decreaseFood(20 * amountToTrain);
                                            resources.decreaseMetal(5 * amountToTrain);

                                            troops.trainArchers(amountToTrain);

                                        } else {
                                            System.out
                                                    .println("\nSorry, you don't have enough resources to do that.\n");

                                        }

                                        break outer_loop;
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Input must be an integer. Please try again.");
                                    sc.nextLine();
                                }
                            }

                        } else {

                            System.out.println("You need to build the archery range first!");

                        }

                        break;

                    }

                    case 3: { // cavalry

                        resources.printResources();

                        if (stables != null) {

                            int buildingLevel = stables.getBuildingLevel();

                            System.out
                                    .println("How many cavalry would you like to train? Max: " + (buildingLevel * 10));
                            System.out.println("Cost: 10 wood, 40 food, 10 metal");

                            while (true) { // input loop
                                try {

                                    int amountToTrain = sc.nextInt();

                                    if (amountToTrain < 1 || amountToTrain > (buildingLevel * 10)) {
                                        System.out.println("\nSorry, the maximum amount of troops you can train is "
                                                + (buildingLevel * 10));
                                        break outer_loop;
                                    } else {

                                        if (resources.getWood() >= (10 * amountToTrain)
                                                && resources.getFood() >= (40 * amountToTrain)
                                                && resources.getMetal() >= (10 * amountToTrain)) {

                                            System.out.println(
                                                    "\nYou have successfully trained " + amountToTrain + " cavalry.\n");

                                            resources.decreaseWood(10 * amountToTrain);
                                            resources.decreaseFood(40 * amountToTrain);
                                            resources.decreaseMetal(10 * amountToTrain);

                                            troops.trainCavalry(amountToTrain);

                                        } else {
                                            System.out
                                                    .println("\nSorry, you don't have enough resources to do that.\n");

                                        }

                                        break outer_loop;
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Input must be an integer. Please try again.");
                                    sc.nextLine();
                                }
                            }

                        } else {

                            System.out.println("You need to build the stables first!");

                        }

                        break;

                    }

                    case 0: {

                        break outer_loop;
                    }

                    default: {
                        System.out.println("This should never print");
                    }

                }

            } else {
                System.out.println("\nYou don't have any buildings to train your troops in!\n");
                break outer_loop;
            }
        }
    }
}