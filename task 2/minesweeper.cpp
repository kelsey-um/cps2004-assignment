#include "header.hpp"

int main(){
    
    Minesweeper game;

    game.generateGridValues();

    while(game.getCellsOpened() < (game.getTotalCells()-game.getNoMines()) && game.getGameCheck() == 0){
        game.userInput();
        
        if(game.gameCheck == 2){
            cout << "You hit a bomb! You've lost the game.\n";
            break;
        }

    }

    if (game.getGameCheck() == 1){
        cout << "Good job! You've won the game.\n";
    }

    system("pause");

    return 0;
}