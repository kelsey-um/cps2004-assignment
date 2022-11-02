#include <iostream>
#include <string>
using namespace std;

class Cell{
    public:
        string value = "00"; //holds the value of the cell
        bool isHidden = true; //USE TO DEBUG - DEFAULT = TRUE
};

class Minesweeper{

    //according to assignment
    static const int size = 16;
    
    public:
        Cell grid[size][size];       
        int totalCells = size*size;
        int cellsOpened = 0;
        const int noMines = 40; //DEFAULT = 40

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
        cout << endl;
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

        displayGrid();
    }

    void userInput(){

        int userX, userY;

        //check if cell is hidden
        while(true){
            cout << "Enter x coordinate between 0 and 15" << endl;
            cin >> userX;

            //input validation
            while(cin.fail() || ((userX < 0 || userX > 15))){ 
            
            cout << "Only integers between 0 and 15 are accepted. Please try again." << endl;
            cin.clear();
            cin.ignore(256,'\n');
            cin >> userX;

        }
       
            cout << "Enter y coordinate" << endl;
            cin >> userY;

            //input validation
            while(cin.fail() || ((userY < 0 || userY > 15))){ 
            
            cout << "Only integers between 0 and 15 are accepted. Please try again." << endl;
            cin.clear();
            cin.ignore(256,'\n');
            cin >> userY;

        }

        
            if(grid[userY][userX].isHidden == false){
                cout << "This cell is already showing. Please try again" << endl;
            } else {
                break;
            }
        }

        checkConditions(userX, userY);

    }

    void showCell(int y, int x){

        if(grid[y][x].isHidden == true){    //so theres no duplicate  
            grid[y][x].isHidden = false;
            cellsOpened++;
        }
    
    }
    
    void checkConditions(int x, int y){
        
        if(grid[y][x].value == "XX"){ //mine is hit -- tested

            //set every cell to show
           for(int i = 0 ; i < size ; i++){
                for(int j = 0 ; j < size ; j++){
                    grid[i][j].isHidden = false;
                }
           }

           displayGrid();

           cout << "You have hit a mine. Game Over!";

        } else if(grid[y][x].value == "00"){ //00 is hit and 8 adjacent open
            
            showCell(y,x);

            if(!((y-1 < 0) || (x-1 <0)) && !(checkMine(y-1, x-1))){
                showCell(y-1, x-1);
            }

            if(!(x-1 < 0) && !(checkMine(y,x-1))){
                showCell(y, x-1);
            }

            if(!((y+1 > 15) || (x-1 < 0)) && !(checkMine(y+1, x-1))){
                showCell(y+1, x-1);
            }

            if(!(y-1 < 0) && !(checkMine(y-1, x))){
                showCell(y-1, x);
            }

            if(!(y+1 > 15) && !(checkMine(y+1, x))){
                showCell(y+1, x);
            }

            if(!((y-1 < 0) || (x+1 > 15)) && !(checkMine(y-1, x+1))){
                showCell(y-1, x+1);
            }
            
            if(!(x+1 > 15) && !(checkMine(y, x+1))){
                showCell(y, x+1);
            }

            if(!((y+1 > 15) || (x+1 > 15)) && !(checkMine(y+1, x+1))){
                showCell(y+1, x+1);
            }
            
            displayGrid();



        } else { //cell has numerical value
            showCell(y,x);
            displayGrid();
        }

        

    }

};