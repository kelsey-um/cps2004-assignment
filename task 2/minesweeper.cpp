#include "header.hpp"

int main(){
    
    Minesweeper game;

    game.generateGridValues();

    while(game.cellsOpened < (game.totalCells-game.noMines) && game.gameCheck == 0){
        game.userInput();
        
        if(game.gameCheck == 2){
            cout << "You hit a bomb! You've lost the game.\n";
            break;
        }

    }

    if (game.gameCheck == 1){
        cout << "Good job! You've won the game.\n";
    }

    system("pause");

    return 0;
}