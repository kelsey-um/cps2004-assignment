import java.util.*;

public class Map {
    int size = 15;
    String[][] map = new String[size][size];

    private Boolean validatePos(int x, int y, int size){

        if(x < 0 || y < 0 || x > size - 1 || y > size - 1){
            return false;
        }

        return true;

    }

    ArrayList<Integer> initMap(int totalPlayers){

        Random rand = new Random();

        ArrayList<Integer> locations = new ArrayList<Integer>();

        for (int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size; j++){
                map[i][j] = "--";
            }
        }

        for(int i = 0; i < totalPlayers ; i++){  
            
            printMap();

            boolean adjacent = false;
            int randY = rand.nextInt(size);
            int randX = rand.nextInt(size);

            if(map[randY][randX] == "--"){ //to check theres not village
                
                //x-1 y-1
                if(validatePos(randX-1, randY-1, size) && adjacent == false) {
                    if(map[randY-1][randX-1] != "--"){
                        adjacent = true;
                    }
                }

                //x-1 y
                if(validatePos(randX-1, randY, size) && adjacent == false) {
                    if(map[randY][randX-1] != "--"){
                        adjacent = true;
                    }
                }

                //x-1 y+1
                if(validatePos(randX-1, randY+1, size) && adjacent == false) {
                    if(map[randY+1][randX-1] != "--"){
                        adjacent = true;
                    }
                }

                //x y-1
                if(validatePos(randX, randY-1, size) && adjacent == false) {
                    if(map[randY-1][randX] != "--"){
                        adjacent = true;
                    }
                }

                //x y+1
                if(validatePos(randX, randY+1, size) && adjacent == false) {
                    if(map[randY+1][randX] != "--"){
                        adjacent = true;
                    }
                }

                //x+1 y-1
                if(validatePos(randX+1, randY-1, size) && adjacent == false) {
                    if(map[randY-1][randX+1] != "--"){
                        adjacent = true;
                    }
                }

                //x+1 y
                if(validatePos(randX+1, randY, size) && adjacent == false) {
                    if(map[randY][randX+1] != "--"){
                        adjacent = true;
                    }
                }

                //x+1 y+1
                if(validatePos(randX+1, randY+1, size) && adjacent == false) {
                    if(map[randY+1][randX+1] != "--"){
                        adjacent = true;
                    }
                }
                
                if(adjacent == false){
                    map[randY][randX] = "V" + (i+1);

                    locations.add(randY);
                    locations.add(randX);
                }else{
                    i--;
                }
            
            } else {
                i--;
            }

        }

        return locations;
    }

    void printMap(){

        //corner
        System.out.print("--  ");

        //display numbers on top
        for(int i = 0 ; i < size ; i++){
            if(i < 10){
                System.out.print("0" + i + "  ");
            } else {
                System.out.print(i + "  ");
            }

        }

        System.out.println();

        for(int i = 0 ; i < size ; i++){

            //numbers on side
            if(i < 10){
                System.out.print("0" + i + "  ");
            } else {
                System.out.print(i + "  ");
            }


            for(int j = 0 ; j < size ; j++){
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

    }

}
