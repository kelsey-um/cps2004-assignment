public class Map {
    int rows = 15;
    int columns = 15;
    String[][] map = new String[rows][columns];

    void initMap(){

        for (int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                map[i][j] = "--";
            }
        }

    }

    void printMap(){

        //corner
        System.out.print("--  ");

        //display numbers on top
        for(int i = 0 ; i < rows ; i++){
            if(i < 10){
                System.out.print("0" + i + "  ");
            } else {
                System.out.print(i + "  ");
            }

        }

        System.out.println();

        for(int i = 0 ; i < rows ; i++){

            //numbers on side
            if(i < 10){
                System.out.print("0" + i + "  ");
            } else {
                System.out.print(i + "  ");
            }


            for(int j = 0 ; j < columns ; j++){
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

    }

}
