import java.util.*;

public class Village {

    private int health;
    private Resources resources;
    private Troops troops;

    private ArrayList<Building> resourceBuildings = new ArrayList<Building>();
    private TroopBuilding barracks = null;
    private TroopBuilding archeryRange = null;
    private TroopBuilding stables = null;

    private Boolean troopBuildingFound = false;

    public Village() {
        this.health = 100;
        this.troops = new Troops();
        this.resources = new Resources();
    }

    private void printNumberedBuildings() {
        for (int i = 0; i < resourceBuildings.size() ; i++) {
            System.out.println(
                    (i + 1) + ". " + resourceBuildings.get(i).getBuildingType() + " " + resourceBuildings.get(i).getBuildingID());
            System.out.println("Level: " + resourceBuildings.get(i).getBuildingLevel() + "\n");
        }
    }

    public void buildBuilding(Scanner sc) {

        int userChoice;

        outer_menu: while (true) { // 1st menu
            System.out.println("\nWhat type of building would you like to build?");
            System.out.println("1. Resource Generator");
            System.out.println("2. Troop Generator");
            System.out.println("3. Back");

            while (true) { // input loop
                try {

                    userChoice = sc.nextInt();

                    if (userChoice < 1 || userChoice > 3) {
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

                case 1: { // resource generator

                    resources.printResources(); // display resources

                    // 2nd menu
                    System.out.println("\nWhich building would you like to build?\n");

                    System.out.println("1. Farm");
                    System.out.println("Cost: 20 wood, 20 food, 10 metal\n");

                    System.out.println("2. Lumber Mill");
                    System.out.println("Cost: 20 wood, 10 food, 20 metal\n");

                    System.out.println("3. Forge");
                    System.out.println("Cost: 10 wood, 10 food, 40 metal\n");

                    System.out.println("4. Back");

                    while (true) { // user input loop
                        try {

                            userChoice = sc.nextInt();

                            if (userChoice < 1 || userChoice > 4) {
                                System.out.println("That is not a valid choice. Please try again.");
                            } else {
                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Input must be an integer. Please try again.");
                            sc.nextLine();
                        }
                    }

                    inner_switch: switch (userChoice) {

                        case 1: { // farm

                            if (resources.getWood() >= 20 && resources.getFood() >= 20 && resources.getMetal() >= 10) {

                                Building tempBuild = new Building("Farm", (resourceBuildings.size() + 1));
                                resourceBuildings.add(tempBuild);

                                resources.decreaseWood(20);
                                resources.decreaseFood(20);
                                resources.decreaseMetal(10);

                                System.out.println("\nYou have successfully built a new farm!");
                                break outer_menu;

                            } else {

                                System.out.println("Sorry, you don't have enough resources to do that.");

                            }

                            break;

                        }

                        case 2: { // lumber mill

                            if (resources.getWood() >= 20 && resources.getFood() >= 10 && resources.getMetal() >= 20) {

                                Building tempBuild = new Building("Lumber Mill", (resourceBuildings.size() + 1));
                                resourceBuildings.add(tempBuild);

                                resources.decreaseWood(20);
                                resources.decreaseFood(10);
                                resources.decreaseMetal(20);

                                System.out.println("\nYou have successfully built a new lumber mill!");
                                break outer_menu;
                            } else {

                                System.out.println("\nSorry, you don't have enough resources to do that.");

                            }

                            break;

                        }

                        case 3: { // forge

                            if (resources.getWood() >= 10 && resources.getFood() >= 10 && resources.getMetal() >= 40) {

                                Building tempBuild = new Building("Forge", (resourceBuildings.size() + 1));
                                resourceBuildings.add(tempBuild);

                                resources.decreaseWood(10);
                                resources.decreaseFood(10);
                                resources.decreaseMetal(40);

                                System.out.println("You have successfully built a new forge!");
                                break outer_menu;
                            } else {

                                System.out.println("Sorry, you don't have enough resources to do that.");

                            }

                            break;
                        }

                        case 4: { // goes back a step in the menu

                            break inner_switch;

                        } // back

                        default: {
                            System.out.println("This should never be printed");
                        }

                    }

                    break;
                }

                case 2: { // troop generator

                    resources.printResources(); // display resources

                    // 2nd menu
                    System.out.println("\nWhich building would you like to build?\n");

                    System.out.println("1. Barracks");
                    System.out.println("Cost: 20 wood, 80 food, 40 metal\n");

                    System.out.println("2. Archery Range");
                    System.out.println("Cost: 80 wood, 40 food, 20 metal\n");

                    System.out.println("3. Stables");
                    System.out.println("Cost: 80 wood, 60 food, 20 metal\n");

                    System.out.println("4. Back");

                    while (true) { // user input loop
                        try {

                            userChoice = sc.nextInt();

                            if (userChoice < 1 || userChoice > 4) {
                                System.out.println("That is not a valid choice. Please try again.");
                            } else {
                                break;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Input must be an integer. Please try again.");
                            sc.nextLine();
                        }
                    }

                    inner_switch: switch (userChoice) {

                        case 1: { // barracks

                            if (resources.getWood() >= 20 && resources.getFood() >= 80 && resources.getMetal() >= 40) {

                                Building tempBuild = new Building("Barracks", (resourceBuildings.size() + 1));
                                resourceBuildings.add(tempBuild);

                                resources.decreaseWood(20);
                                resources.decreaseFood(80);
                                resources.decreaseMetal(40);

                                System.out.println("\nYou have successfully built new barracks!");
                                break outer_menu;

                            } else {

                                System.out.println("Sorry, you don't have enough resources to do that.");

                            }

                            break;

                        }

                        case 2: { // archery range

                            if (resources.getWood() >= 80 && resources.getFood() >= 40 && resources.getMetal() >= 20) {

                                Building tempBuild = new Building("Archery Range", (resourceBuildings.size() + 1));
                                resourceBuildings.add(tempBuild);

                                resources.decreaseWood(80);
                                resources.decreaseFood(40);
                                resources.decreaseMetal(20);

                                System.out.println("\nYou have successfully built a new archery range!");
                                break outer_menu;
                            } else {

                                System.out.println("\nSorry, you don't have enough resources to do that.");

                            }

                            break;

                        }

                        case 3: { // stables

                            if (resources.getWood() >= 80 && resources.getFood() >= 60 && resources.getMetal() >= 20) {

                                Building tempBuild = new Building("Stables", (resourceBuildings.size() + 1));
                                resourceBuildings.add(tempBuild);

                                resources.decreaseWood(80);
                                resources.decreaseFood(60);
                                resources.decreaseMetal(20);

                                System.out.println("You have successfully built new stables!");
                                break outer_menu;
                            } else {

                                System.out.println("Sorry, you don't have enough resources to do that.");

                            }

                            break;
                        }

                        case 4: { // goes back a step in the menu
                            break inner_switch;

                        } // back

                        default: {
                            System.out.println("This should never be printed");
                        }
                    }

                    break;
                }

                case 3: { // goes back a step in the menu
                    break outer_menu;
                }

                default: {
                    System.out.println("This should never print");
                }

            }

        }

    }

    public void upgradeBuilding(Scanner sc) {

        int userChoice;

        if (resourceBuildings.size() > 0) { // to check there are buildings

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

                    if (userChoice < 1 || userChoice > (resourceBuildings.size() + 1)) {
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

            if (resourceBuildings.get(userChoice).getBuildingLevel() < 5) { // check if building is at max level

                String buildingType = resourceBuildings.get(userChoice).getBuildingType();

                switch (buildingType) {
                    case "Farm": {

                        if (resources.getWood() >= 10 && resources.getFood() >= 10 && resources.getMetal() >= 5) {

                            resourceBuildings.get(userChoice).increaseLevel(); // increase level by 1

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

                            resourceBuildings.get(userChoice).increaseLevel(); // increase level by 1

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

                            resourceBuildings.get(userChoice).increaseLevel(); // increase level by 1

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

                            resourceBuildings.get(userChoice).increaseLevel(); // increase level by 1

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

                            resourceBuildings.get(userChoice).increaseLevel(); // increase level by 1

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

                            resourceBuildings.get(userChoice).increaseLevel(); // increase level by 1

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

        while (troopBuildingFound == false && resourceBuildings.size() > 0){ //to make sure there is one troop building, will not execute once a building has been found
            for (int i = 0 ; i < resourceBuildings.size() ; i++){
                if(resourceBuildings.get(i).getBuildingType().equals("Barracks") || resourceBuildings.get(i).getBuildingType().equals("Archery Range") || resourceBuildings.get(i).getBuildingType().equals("Stables")){
                    troopBuildingFound = true;
                    break;
                }
            }
        }

        if(troopBuildingFound == true){

            System.out.println("What type of troop would you like to train?");


        } else {

            System.out.println("You don't have any buildings that can train troops!");

        }

    }

}