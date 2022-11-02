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
};