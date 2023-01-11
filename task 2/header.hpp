#include <iostream>
#include <string>
using namespace std;

class Cell
{
public:
    string value = "00";  // holds the value of the cell
    bool isHidden = true; // DEFAULT = TRUE
};

class Minesweeper
{
    static const int size = 16; // size of grid

public:
    Cell grid[size][size];
    int totalCells = size * size; // total cells in grid
    int cellsOpened = 0;          // cells that have been unhidden and shown to the player
    const int noMines = 40;       // DEFAULT = 40
    int gameCheck = 0;            // 0 - game is ongoing, 1 - win, 2 - lose

    int getCellsOpened()
    {
        return cellsOpened;
    }

    int getTotalCells()
    {
        return totalCells;
    }

    int getNoMines()
    {
        return noMines;
    }

    int getGameCheck()
    {
        return gameCheck;
    }

    void generateGridValues()
    { // to generate grid values at the start of the game

        srand((unsigned)time(NULL)); // to always generate new random numbers

        int mineCount = 0; // to check how many mines have been generated
        int randY, randX;

        while (mineCount < noMines)
        {

            randY = rand() % size; // random x and y coordinate
            randX = rand() % size;

            if ((grid[randY][randX].value) != "XX")
            { // check if coordinate generated is not already mine

                grid[randY][randX].value = "XX"; // set to mine
                mineCount++;

                // to increment adjacent mines

                // x-1 y-1
                if (!((randY - 1 < 0) || (randX - 1 < 0)) && !(checkMine(randY - 1, randX - 1)))
                {
                    incrementValue(randY - 1, randX - 1);
                }

                // x-1 y
                if (!(randX - 1 < 0) && !(checkMine(randY, randX - 1)))
                {
                    incrementValue(randY, randX - 1);
                }

                // x-1 y+1
                if (!((randY + 1 > 15) || (randX - 1 < 0)) && !(checkMine(randY + 1, randX - 1)))
                {
                    incrementValue(randY + 1, randX - 1);
                }

                // x y-1
                if (!(randY - 1 < 0) && !(checkMine(randY - 1, randX)))
                {
                    incrementValue(randY - 1, randX);
                }

                // x y+1
                if (!(randY + 1 > 15) && !(checkMine(randY + 1, randX)))
                {
                    incrementValue(randY + 1, randX);
                }

                // x+1 y-1
                if (!((randY - 1 < 0) || (randX + 1 > 15)) && !(checkMine(randY - 1, randX + 1)))
                {
                    incrementValue(randY - 1, randX + 1);
                }

                // x+1 y
                if (!(randX + 1 > 15) && !(checkMine(randY, randX + 1)))
                {
                    incrementValue(randY, randX + 1);
                }

                // x+1 y+1
                if (!((randY + 1 > 15) || (randX + 1 > 15)) && !(checkMine(randY + 1, randX + 1)))
                {
                    incrementValue(randY + 1, randX + 1);
                }
            }
        }

        displayGrid();
    }

    void userInput()
    {

        int userX, userY;

        while (true)
        {
            cout << "Enter x coordinate between 0 and 15" << endl;
            cin >> userX;

            // input validation
            while (cin.fail() || ((userX < 0 || userX > 15)))
            {

                cout << "Only integers between 0 and 15 are accepted. Please try again." << endl;
                cin.clear();
                cin.ignore(256, '\n');
                cin >> userX;
            }

            cout << "Enter y coordinate" << endl;
            cin >> userY;

            // input validation
            while (cin.fail() || ((userY < 0 || userY > 15)))
            {

                cout << "Only integers between 0 and 15 are accepted. Please try again." << endl;
                cin.clear();
                cin.ignore(256, '\n');
                cin >> userY;
            }

            if (grid[userY][userX].isHidden == false)
            { // to check if cell is already showing
                cout << "This cell is already showing. Please try again" << endl;
            }
            else
            {
                break;
            }
        }

        checkConditions(userX, userY);
    }

private:
    void displayGrid()
    {

        cout << "-- "; // corner

        // display numbers on top
        for (int i = 0; i < size; i++)
        {
            if (i < 10)
            { // to add 0 in front of single digit numbers
                cout << "0" << i << " ";
            }
            else
            {
                cout << i << " ";
            }
        }

        cout << endl;

        for (int i = 0; i < size; i++)
        {

            // display numbers on side
            if (i < 10)
            { // to add 0 in front of single digit numbers
                cout << "0" << i << " ";
            }
            else
            {
                cout << i << " ";
            }

            for (int j = 0; j < size; j++)
            {

                // display cell
                if (grid[i][j].isHidden == false)
                { // show grid value or -- if cell is still hidden
                    cout << grid[i][j].value << " ";
                }
                else
                {
                    cout << "-- ";
                }
            }

            cout << endl;
        }
        cout << endl;
    }

    bool checkMine(int y, int x)
    { // to check if cell is a mine

        if (grid[y][x].value == "XX")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void incrementValue(int y, int x)
    { // to change string to int, increment and then back to string
        int tempInt = 0;

        tempInt = stoi(grid[y][x].value);
        tempInt++;
        grid[y][x].value = "0" + to_string(tempInt);
    }

    void showCell(int y, int x)
    { // show cell

        if (grid[y][x].isHidden == true)
        { // in case cell is already showing, so cellsOpened does not get incremented when it shouldnt
            grid[y][x].isHidden = false;
            cellsOpened++;
        }

        if (cellsOpened == (totalCells - noMines))
        {
            gameCheck = 1;
        }
    }

    void checkConditions(int x, int y)
    {

        if (grid[y][x].value == "XX")
        { // mine is hit

            // set every cell to show
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    grid[i][j].isHidden = false;
                }
            }

            displayGrid();

            gameCheck = 2;
        }
        else if (grid[y][x].value == "00")
        { // 00 is hit and 8 adjacent open

            showCell(y, x);

            if (!((y - 1 < 0) || (x - 1 < 0)) && !(checkMine(y - 1, x - 1)))
            {
                showCell(y - 1, x - 1);
            }

            if (!(x - 1 < 0) && !(checkMine(y, x - 1)))
            {
                showCell(y, x - 1);
            }

            if (!((y + 1 > 15) || (x - 1 < 0)) && !(checkMine(y + 1, x - 1)))
            {
                showCell(y + 1, x - 1);
            }

            if (!(y - 1 < 0) && !(checkMine(y - 1, x)))
            {
                showCell(y - 1, x);
            }

            if (!(y + 1 > 15) && !(checkMine(y + 1, x)))
            {
                showCell(y + 1, x);
            }

            if (!((y - 1 < 0) || (x + 1 > 15)) && !(checkMine(y - 1, x + 1)))
            {
                showCell(y - 1, x + 1);
            }

            if (!(x + 1 > 15) && !(checkMine(y, x + 1)))
            {
                showCell(y, x + 1);
            }

            if (!((y + 1 > 15) || (x + 1 > 15)) && !(checkMine(y + 1, x + 1)))
            {
                showCell(y + 1, x + 1);
            }

            displayGrid();
        }
        else
        { // cell has numerical value
            showCell(y, x);
            displayGrid();
        }
    }
};