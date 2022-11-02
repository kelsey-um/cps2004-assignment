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

    void generateGridValues(){

        int mineCount = 0; //to check how many mines have been generated
        int randX, randY, tempInt;

        while(mineCount < noMines){
            randX = rand() % size;  //random x and y coordinate
            randY = rand() % size;

            if((grid[randX][randY].value) != "XX"){ //check if coordinate generated is not already mine
                
                grid[randX][randY].value = "XX";
                mineCount++;

                // to increment adjacent mines

                //x-1 y-1
                if(!(randX-1 < 0) || !(randY-1 < 0)){
                    tempInt = stoi(grid[randX-1][randY-1].value);
                    tempInt++;
                    grid[randX-1][randY-1].value = to_string(tempInt);
                }

                // //x y-1
                // if(!(randY < 0)){}
            
                // //x+1 y-1
                // if(!(randX > 15) || !(randY < 0)){}

                // //x-1 y
                // if(!(randX < 0)){}

                // //x+1 y
                // if(!(randX > 15)){}

                // //x-1 y+1 
                // if(!(randX < 0) || !(randY > 15)){}

                // //x y+1 
                // if(!(randY > 15)){}

                // //x+1 y+1
                // if(!(randX > 15) || !(randY > 15)){}
            
            }
        }

        
    
    }

    


};