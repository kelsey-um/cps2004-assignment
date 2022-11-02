#include "header.hpp"

int main(){

    bool win = false;

    Minesweeper game;

    game.generateGridValues();

    while(game.cellsOpened < (game.totalCells-game.noMines)){
        game.userInput();
        win = true;
    }

    if (win = true){
        cout << "Good job! You've won the game.";
    }



    return 0;
}