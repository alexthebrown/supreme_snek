package game;

import java.util.Random;

public class Board{
    private Cell[][] boardTypes = new Cell[32][32];

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
        for(int i = 0; i < 32; i++){
            for(int t = 0; t < 32; t++){
                boardTypes[t][i].updateCell(5);
            }
        }
        for(int i = 0; i < 32; i++){
            boardTypes[0][i].updateCell(1);
            boardTypes[31][i].updateCell(1);
            boardTypes[i][0].updateCell(1);
            boardTypes[i][31].updateCell(1);
        }
        
    }
}