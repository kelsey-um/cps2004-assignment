import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int numberOfPlayers;
        int numberOfAI;

        System.out.println("-- Village War Game --\n");

        //number of players input
        System.out.println("Enter the number of players");
        while (true){ //loop to allow user to try again
            try{
                numberOfPlayers = sc.nextInt();
                
                if(numberOfPlayers < 1){ // at least 1 player
                    System.out.println("There must be at least 1 player. Please try again.");
                } else { //input is all valid
                    break;
                }
            }
            catch(InputMismatchException e){ // catch non-integes     
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine(); // skip line
            }
        }
        
        // number of ai players input
        System.out.println("\nEnter number of AI players");
        while (true){ //loop to allow user to try again
            try{
                numberOfAI = sc.nextInt();
                break;
            }
            catch(InputMismatchException e){ // catch non-integes     
                System.out.println("Input must be an integer. Please try again.");
                sc.nextLine(); // skip line
            }
        }

        Player[] playerList = new Player[numberOfPlayers+numberOfAI];

        // declaring each player and their villages
        for (int i = 0 ; i < numberOfPlayers ; i++){
            System.out.println("\nEnter the name of player "+ (i+1)); //+1 so output is done properly
            String playerName = sc.next();

            playerList[i] = new Player(playerName, false);
        }

        // creating ai players
        for(int i = numberOfPlayers ; i < (numberOfAI+numberOfPlayers) ; i++){ // i set to numberOfPlayers to keep proper count in array
            String playerName = "Computer " + (i-numberOfPlayers+1);
            
            playerList[i] = new Player(playerName, true);
        }


        sc.close();
    }

}