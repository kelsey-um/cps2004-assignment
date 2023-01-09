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
        resources.startingResources();
    }

    private void printNumberedBuildings() { //print buildings
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + buildings.get(i).getBuildingType() + " "
                            + buildings.get(i).getBuildingID());
            System.out.println("Level: " + buildings.get(i).getBuildingLevel() + "\n");
        }
    }

    public int getHealth() {
        return health;
    }

    public Troops getTroops(){
        return troops;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decreaseHealth(int health){
        this.health -= health;
    }

    public Resources getResources(){
        return resources;
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


            // to check if these buildings have already been built
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

                        //creating building and decreasing resources it required

                        ResourceBuilding tempBuild = new ResourceBuilding("Farm", (buildings.size() + 1));
                        buildings.add(tempBuild);

                        resources.decreaseWood(20);
                        resources.decreaseFood(20);
                        resources.decreaseMetal(10);

                        System.out.println("\nYou have successfully built a new farm!");

                    } else {

                        System.out.println("\nSorry, you don't have enough resources to do that.");

                    }

                    break outer_loop;
                }

                case 2: { // lumber mill

                    if (resources.getWood() >= 20 && resources.getFood() >= 10 && resources.getMetal() >= 20) {

                        ResourceBuilding tempBuild = new ResourceBuilding("Lumber Mill", (buildings.size() + 1));
                        buildings.add(tempBuild);

                        resources.decreaseWood(20);
                        resources.decreaseFood(10);
                        resources.decreaseMetal(20);

                        System.out.println("\nYou have successfully built a new lumber mill!");

                    } else {

                        System.out.println("\nSorry, you don't have enough resources to do that.");

                    }

                    break outer_loop;

                }

                case 3: { // forge

                    if (resources.getWood() >= 10 && resources.getFood() >= 10 && resources.getMetal() >= 40) {

                        ResourceBuilding tempBuild = new ResourceBuilding("Forge", (buildings.size() + 1));
                        buildings.add(tempBuild);

                        resources.decreaseWood(10);
                        resources.decreaseFood(10);
                        resources.decreaseMetal(40);

                        System.out.println("\nYou have successfully built a new forge!");

                    } else {

                        System.out.println("\nSorry, you don't have enough resources to do that.");

                    }

                    break outer_loop;
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

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }
                    } else {
                        System.out.println("\nThe barracks have already been built!");

                    }

                    break outer_loop;
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

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }
                    } else {
                        System.out.println("\nThe archery range has already been built!");

                    }

                    break outer_loop;
                }

                case 6: { // stables
                    if (stables == null) {
                        if (resources.getWood() >= 80 && resources.getFood() >= 60 && resources.getMetal() >= 20) {

                            stables = new TroopBuilding("Stables", (buildings.size() + 1));
                            buildings.add(stables);

                            resources.decreaseWood(80);
                            resources.decreaseFood(60);
                            resources.decreaseMetal(20);

                            System.out.println("\nYou have successfully built the stables!");

                        } else {

                            System.out.println("\nSorry, you don't have enough resources to do that.");

                        }
                    } else {

                        System.out.println("\nThe stables have already been built!");

                    }

                    break outer_loop;
                }

                case 0: { // back
                    break outer_loop;
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
            System.out.println("0. Back");

            while (true) { // input loop
                try {

                    userChoice = sc.nextInt();

                    if (userChoice < 0 || userChoice > (buildings.size() + 1)) {
                        System.out.println("That is not a valid choice. Please try again.");
                    } else {

                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input must be an integer. Please try again.");
                    sc.nextLine();
                }
            }

            if (userChoice != 0) {

                userChoice--; // since arraylist starts from 0

                if (buildings.get(userChoice).getBuildingLevel() < 5) { // check if building is at max level

                    String buildingType = buildings.get(userChoice).getBuildingType();

                    switch (buildingType) {
                        case "Farm": {

                            if (resources.getWood() >= 10 && resources.getFood() >= 10 && resources.getMetal() >= 5) {
                                //upgrading building and decreasing resource it required

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

                        
                    }

                } else {
                    System.out.println("This building is already at its max level!");
                }

            } else {

                System.out.println("You currently don't have any buildings in your village!");

            }
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

                            System.out.println("How many swordsmen would you like to train? Max: " + (buildingLevel * 10));
                            System.out.println("Cost: 10 wood, 10 food, 20 metal");

                            while (true) { // input loop
                                try {

                                    int amountToTrain = sc.nextInt();

                                    if (amountToTrain < 1 || amountToTrain > (buildingLevel * 10)) {
                                        System.out.println("\nSorry, the maximum amount of troops you can train is "+ (buildingLevel * 10));
                                        break outer_loop;
                                    } else {

                                        if (resources.getWood() >= (10 * amountToTrain)
                                                && resources.getFood() >= (10 * amountToTrain)
                                                && resources.getMetal() >= (20 * amountToTrain)) {

                                            System.out.println("\nYou have successfully trained " + amountToTrain+ " swordsmen.");

                                            resources.decreaseWood(10 * amountToTrain);
                                            resources.decreaseFood(10 * amountToTrain);
                                            resources.decreaseMetal(20 * amountToTrain);

                                            troops.increaseSwordsmen(amountToTrain);

                                        } else {
                                            System.out.println("\nSorry, you don't have enough resources to do that.");

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

                            System.out.println("How many archers would you like to train? Max: " + (buildingLevel * 10));
                            System.out.println("Cost: 10 wood, 20 food, 5 metal");

                            while (true) { // input loop
                                try {

                                    int amountToTrain = sc.nextInt();

                                    if (amountToTrain < 1 || amountToTrain > (buildingLevel * 10)) {
                                        System.out.println("\nSorry, the maximum amount of troops you can train is " + (buildingLevel * 10));
                                        break outer_loop;
                                    } else {

                                        if (resources.getWood() >= (10 * amountToTrain) && resources.getFood() >= (20 * amountToTrain) && resources.getMetal() >= (5 * amountToTrain)) {

                                            System.out.println("\nYou have successfully trained " + amountToTrain + " archers.");

                                            resources.decreaseWood(10 * amountToTrain);
                                            resources.decreaseFood(20 * amountToTrain);
                                            resources.decreaseMetal(5 * amountToTrain);

                                            troops.increaseArchers(amountToTrain);

                                        } else {
                                            System.out.println("\nSorry, you don't have enough resources to do that.");

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

                            System.out.println("How many cavalry would you like to train? Max: " + (buildingLevel * 10));
                            System.out.println("Cost: 10 wood, 40 food, 10 metal");

                            while (true) { // input loop
                                try {

                                    int amountToTrain = sc.nextInt();

                                    if (amountToTrain < 1 || amountToTrain > (buildingLevel * 10)) {
                                        System.out.println("\nSorry, the maximum amount of troops you can train is "+ (buildingLevel * 10));
                                        break outer_loop;
                                    } else {

                                        if (resources.getWood() >= (10 * amountToTrain) && resources.getFood() >= (40 * amountToTrain) && resources.getMetal() >= (10 * amountToTrain)) {

                                            System.out.println("\nYou have successfully trained " + amountToTrain + " cavalry.");

                                            resources.decreaseWood(10 * amountToTrain);
                                            resources.decreaseFood(40 * amountToTrain);
                                            resources.decreaseMetal(10 * amountToTrain);

                                            troops.increaseCavalry(amountToTrain);

                                        } else {
                                            System.out.println("\nSorry, you don't have enough resources to do that.\n");

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

                }

            } else {
                System.out.println("\nYou don't have any buildings to train your troops in!\n");
                break outer_loop;
            }
        }
    }

    public void createArmy(Scanner sc, ArrayList<HumanPlayer> humanPlayerList, Player owner, Map map) {

        int amount;
        Army army = new Army(owner);

        System.out.println("Creating an army.\n");

        System.out.println("How many swordsmen would you like to include? Available: " + troops.getSwordsmen().getAmount());

        while (true) { // input loop
            try {

                amount = sc.nextInt();

                if (amount < 0 || amount > troops.getSwordsmen().getAmount()) {
                    System.out.println("\nSorry, you don't have enough swordsmen to do that");
                } else {

                    System.out.println("\nYou've added " + amount + " swordsmen to your army");

                    army.increaseSwordsmen(amount);
                    troops.decreaseSwordsmen(amount);

                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine();
            }
        }

        System.out.println("\nHow many archers would you like to include? Available: " + troops.getArchers().getAmount());

        while (true) { // input loop
            try {

                amount = sc.nextInt();

                if (amount < 0 || amount > troops.getArchers().getAmount()) {
                    System.out.println("\nSorry, you don't have enough archers to do that");
                } else {

                    System.out.println("\nYou've added " + amount + " archers to your army");

                    army.increaseArchers(amount);
                    troops.decreaseArchers(amount);

                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine();
            }
        }

        System.out.println("\nHow many cavalry would you like to include? Available: " + troops.getCavalry().getAmount());

        while (true) { // input loop
            try {

                amount = sc.nextInt();

                if (amount < 0 || amount > troops.getCavalry().getAmount()) {
                    System.out.println("\nSorry, you don't have enough cavalry to do that");
                } else {

                    System.out.println("\nYou've added " + amount + " cavalry to your army");

                    army.increaseCavalry(amount);
                    troops.decreaseCavalry(amount);

                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine();
            }
        }

        System.out.println("\nWhich player would you like to attack?");

        for (int i = 0; i < humanPlayerList.size(); i++) {

            if (humanPlayerList.get(i).getVillage().getHealth() > 0 && !(humanPlayerList.get(i).getPlayerID() == owner.getPlayerID())) {

                System.out.println((i + 1) + ". " + humanPlayerList.get(i).getPlayerName());

            }

        }

        Player chosenPlayer;
        int userChoice;

        while (true) { // input loop
            try {

                userChoice = sc.nextInt();

                if (userChoice < 0 || userChoice > humanPlayerList.size() || userChoice == owner.getPlayerID()) {
                    System.out.println("Sorry, that is not a valid choice");
                } else {

                    chosenPlayer = (HumanPlayer) humanPlayerList.get(userChoice - 1);
                    break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine();
            }
        }

        army.updateStats(); //calculating stats
        army.setTargets(chosenPlayer); //setting the target
        map.addArmy(army); //adding army to map

        System.out.println("\nYour army has been sent to attack");

    }

    public void resourceLoop() { //looping through each building allowing it to generate it resource

        Building currentBuilding;

        for (int i = 0; i < buildings.size(); i++) {

            currentBuilding = buildings.get(i);

            if (currentBuilding instanceof ResourceBuilding) { //only ResourceBuildings can generate resources

                ResourceBuilding currentResource = (ResourceBuilding) currentBuilding;
                currentResource.generateResource(resources);

            }
        }

    }

    public void armyArrival(Army army) { //army arrived back to village

        Resources armyResource = army.getResources();

        // collecting resources
        resources.increaseWood(armyResource.getWood());
        resources.increaseFood(armyResource.getFood());
        resources.increaseMetal(armyResource.getMetal());

        // putting back troops
        troops.increaseSwordsmen(army.getSwordsmen().getAmount());
        troops.increaseArchers(army.getArchers().getAmount());
        troops.increaseCavalry(army.getCavalry().getAmount());

    }

}