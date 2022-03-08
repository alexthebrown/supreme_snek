package game;

import java.util.Random;

public class Board{
    private Cell[][] boardTypes = new Cell[32][32];

    public Board(){
        for(int i = 0; i < 32; i++){
            for(int t = 0; t < 32; t++){
                boardTypes[t][i].updateCell(5);
            }
        }
        for(int i = 0; i < 32; i++){
            
        }
    }
}