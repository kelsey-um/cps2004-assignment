import java.util.*;

public class Village {
    
    int health;
    Resources resources;
    Troops troops;
    
    ArrayList<Building> buildings = new ArrayList<Building>();


    public Village(){
        this.health = 100;
        this.troops = new Troops(); 
        this.resources = new Resources();
    }

    public void buildBuilding(){

        Scanner sc = new Scanner(System.in);

        int userChoice;

        outer_menu:
            while(true){
            System.out.println("\nWhat type of building would you like to build?");
            System.out.println("1. Resource Generator");
            System.out.println("2. Troop Generator");
            System.out.println("3. Back");

            while(true){
                try{
                    
                    userChoice = sc.nextInt();
                    
                    if(userChoice < 1 || userChoice > 3){
                        System.out.println("That is not a valid choice. Please try again.");
                    } else {
                        break;
                    }


                } catch(InputMismatchException e){
                    System.out.println("Input must be an integer. Please try again.");
                    sc.nextLine();
                }
            }

            switch(userChoice){
                
                case 1: { //resource generator
                    
                    resources.displayResources(); //display resources
                    
                    System.out.println("\nWhich building would you like to build?\n");

                    System.out.println("1. Farm");
                    System.out.println("Cost: 10 wood, 10 food, 5 metal\n");

                    System.out.println("2. Lumber Mill");
                    System.out.println("Cost: 10 wood, 5 food, 10 metal\n");

                    System.out.println("3. Forge");
                    System.out.println("Cost: 5 wood, 5 food, 20 metal\n");

                    System.out.println("4. Back");

                    while(true){ //user input loop
                        try{
                            
                            userChoice = sc.nextInt();
                            
                            if(userChoice < 1 || userChoice > 4){
                                System.out.println("That is not a valid choice. Please try again.");
                            } else {
                                break;
                            }
            
            
                        } catch(InputMismatchException e){
                            System.out.println("Input must be an integer. Please try again.");
                            sc.nextLine();
                        }
                    }

                    inner_switch:
                        switch(userChoice){

                            case 1:{ //farm

                                if(resources.wood >= 10 && resources.food >= 10 && resources.metal >= 5){
                                    
                                    Building tempBuild = new Building("Farm");
                                    buildings.add(tempBuild);

                                    resources.decreaseWood(10);
                                    resources.decreaseFood(10);
                                    resources.decreaseMetal(5);

                                    System.out.println("\nYou have successfully built a new farm!");
                                    break outer_menu;

                                } else {

                                    System.out.println("Sorry, you don't have enough resources to do that.");

                                }
                                
                                break;

                            }

                            case 2:{ //lumber mill
    
                                if(resources.wood >= 10 && resources.food >= 5 && resources.metal >= 10){
                                    
                                    Building tempBuild = new Building("Lumber Mill");
                                    buildings.add(tempBuild);
                                    
                                    resources.decreaseWood(10);
                                    resources.decreaseFood(5);
                                    resources.decreaseMetal(10);

                                    System.out.println("\nYou have successfully built a new lumber mill!");
                                    break outer_menu;
                                } else {

                                    System.out.println("\nSorry, you don't have enough resources to do that.");

                                }
                                
                                break;

                            }

                            case 3: { //forge

                                if(resources.wood >= 5 && resources.food >= 5 && resources.metal >= 20){
                                    
                                    Building tempBuild = new Building("Forge");
                                    buildings.add(tempBuild);

                                    resources.decreaseWood(5);
                                    resources.decreaseFood(5);
                                    resources.decreaseMetal(20);

                                    System.out.println("You have successfully built a new forge!");
                                    break outer_menu;
                                } else {

                                    System.out.println("Sorry, you don't have enough resources to do that.");

                                }
                                
                                break;
                            } 

                            case 4: { //goes back a step in the menu
                                break inner_switch;

                            } // back

                            default: {
                                System.out.println("This should never be printed");
                            }

                        }

                    break;
                }

                case 2:{ //troop generator
                    
                    resources.displayResources(); //display resources
                    
                    System.out.println("\nWhich building would you like to build?\n");

                    System.out.println("1. Barracks");
                    System.out.println("Cost: 10 wood, 40 food, 20 metal\n");

                    System.out.println("2. Archery Range");
                    System.out.println("Cost: 40 wood, 20 food, 10 metal\n");

                    System.out.println("3. Stables");
                    System.out.println("Cost: 40 wood, 30 food, 10 metal\n");

                    System.out.println("4. Back");

                    while(true){ //user input loop
                        try{
                            
                            userChoice = sc.nextInt();
                            
                            if(userChoice < 1 || userChoice > 4){
                                System.out.println("That is not a valid choice. Please try again.");
                            } else {
                                break;
                            }
            
            
                        } catch(InputMismatchException e){
                            System.out.println("Input must be an integer. Please try again.");
                            sc.nextLine();
                        }
                    }

                    inner_switch:
                        switch(userChoice){

                            case 1:{ //barracks

                                if(resources.wood >= 10 && resources.food >= 40 && resources.metal >= 20){
                                    
                                    Building tempBuild = new Building("Barracks");
                                    buildings.add(tempBuild);

                                    resources.decreaseWood(10);
                                    resources.decreaseFood(40);
                                    resources.decreaseMetal(20);

                                    System.out.println("\nYou have successfully built new barracks!");
                                    break outer_menu;
                                    
                                } else {

                                    System.out.println("Sorry, you don't have enough resources to do that.");

                                }
                                
                                break;

                            }

                            case 2:{ //archery range
    
                                if(resources.wood >= 40 && resources.food >= 20 && resources.metal >= 10){
                                    
                                    Building tempBuild = new Building("Archery Range");
                                    buildings.add(tempBuild);

                                    resources.decreaseWood(40);
                                    resources.decreaseFood(20);
                                    resources.decreaseMetal(10);

                                    System.out.println("\nYou have successfully built a new archery range!");
                                    break outer_menu;
                                } else {

                                    System.out.println("\nSorry, you don't have enough resources to do that.");

                                }
                                
                                break;

                            }

                            case 3: { //stables

                                if(resources.wood >= 40 && resources.food >= 30 && resources.metal >= 10){
                                    
                                    Building tempBuild = new Building("Stables");
                                    buildings.add(tempBuild);

                                    resources.decreaseWood(40);
                                    resources.decreaseFood(30);
                                    resources.decreaseMetal(10);

                                    System.out.println("You have successfully built new stables!");
                                    break outer_menu;
                                } else {

                                    System.out.println("Sorry, you don't have enough resources to do that.");

                                }
                                
                                break;
                            } 

                            case 4: { //goes back a step in the menu
                                break inner_switch;

                            } // back

                            default: {
                                System.out.println("This should never be printed");
                            }
                        }

                    break;
                }

                case 3:{ // back
                    break outer_menu;
                }

                default:{
                    System.out.println("This should never print");
                }

            }
        
        }

        sc.close();
        
    }
    

}
