#include <iostream>
#include <string>
using namespace std;

class Cell{
    public:
        string value = "00"; //holds the value of the cell
        bool isHidden = false; //USE TO DEBUG
};

class Minesweeper{

    //according to assignment
    static const int size = 16;
    static const int noMines = 40;

    public:
        Cell grid[size][size];       

    void displayGrid(){

        cout << "-- "; //corner 

        //display numbers on top
        for(int i = 0 ; i < size ; i++){
            if(i < 10){ //to add 0 in front of single digit numbers
                cout << "0" << i << " ";
            } else {
                cout << i << " ";
            }
        }

        cout << endl;

        for(int i = 0 ; i < size ; i++){

            //display numbers on side
            if(i < 10){ //to add 0 in front of single digit numbers
                cout << "0" << i << " ";
            } else {
                cout << i << " ";
            }

            for(int j = 0 ; j < size ; j++){ 

                //display cell

                if (grid[i][j].isHidden == false){
                    cout << grid[i][j].value << " ";
                } else {
                    cout << "-- ";
                }

            }
            
            cout << endl;

        }
    }

    bool checkMine(int y, int x){
        
        if(grid[y][x].value == "XX"){
            return true;
        } else {
            return false;
        }
    
    }

    void incrementValue(int y, int x){
        int tempInt = 0;

        tempInt = stoi(grid[y][x].value);
        tempInt++;
        grid[y][x].value = "0" + to_string(tempInt);
    }

    void generateGridValues(){

        srand((unsigned) time(NULL)); //to always generate new numbers

        int mineCount = 0; //to check how many mines have been generated
        int randY, randX;

        while(mineCount < noMines){

            randY = rand() % size;  //random x and y coordinate
            randX = rand() % size;

            if((grid[randY][randX].value) != "XX"){ //check if coordinate generated is not already mine
                
                grid[randY][randX].value = "XX";
                mineCount++;

                // to increment adjacent mines

                //x-1 y-1
                if(!((randY-1 < 0) || (randX-1 < 0)) && !(checkMine(randY-1, randX-1))){
                
                    incrementValue(randY-1, randX-1);

                }

                //x y-1
                if(!(randX-1 < 0) && !(checkMine(randY, randX-1))){

                    incrementValue(randY, randX-1);

                }

                //x+1 y-1
                if(!((randY+1 > 15) || (randX-1 < 0)) && !(checkMine(randY+1, randX-1))){

                    incrementValue(randY+1, randX-1);

                }

                //x-1 y
                if(!(randY-1 < 0) && !(checkMine(randY-1, randX))){
                    
                    incrementValue(randY-1, randX);

                }

                //x+1 y
                if(!(randY+1 > 15) && !(checkMine(randY+1, randX))){

                    incrementValue(randY+1, randX);

                }

                //x-1 y+1 
                if(!((randY-1 < 0) || (randX+1 > 15)) && !(checkMine(randY-1, randX+1))){

                    incrementValue(randY-1, randX+1);

                }

                //x y+1 
                if(!(randX+1 > 15) && !(checkMine(randY, randX+1))){
                
                    incrementValue(randY, randX+1);

                }

                //x+1 y+1
                if(!((randY+1 > 15) || (randX+1 > 15)) && !(checkMine(randY+1, randX+1))){

                    incrementValue(randY+1, randX+1);

                }

            }

        }
    }
};