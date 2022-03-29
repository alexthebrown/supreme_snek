package game;

import java.util.Random;
bruh.txt

public class Board{
    private Cell[][] boardTypes = new Cell[32][32];// Creates a cell object in every spot of the array.


    /**
     * Key For Square Types:
     * 1 = Wall
     * 2 = Apple
     * 3 = Head of Snake
     * 4 = Body of Snake
     * 5 = Blank Space
     */
    /**
     * Creates a board that is 32 x 32 and has walls on every side.
     */
    public Board(){
        for(int i = 0; i < 32; i++){ //Sets all cell objects to blank spaces.
            for(int t = 0; t < 32; t++){
                boardTypes[t][i].updateCell(5);
            }
        }
        for(int i = 0; i < 32; i++){ //Adds the walls in
            boardTypes[0][i].updateCell(1);
            boardTypes[31][i].updateCell(1);
            boardTypes[i][0].updateCell(1);
            boardTypes[i][31].updateCell(1);
        }


        
    }
    public void updateSnake(int row, int collum){
        
    }
    public

}