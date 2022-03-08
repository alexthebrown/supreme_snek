package game;
public class Cell {

    private int cellType;
    private int rowPos;
    private int collumPos;

    public Cell(int type, int row, int collum){
        cellType = type;
        rowPos = row;
        collumPos =  collum;
    }
    public void updateCell(int type){ 
        cellType = type;
    }
    public int getCellType(){
        return cellType;
    }
    public int getRow(){
        return rowPos;
    }
    public int getCollum(){
        return collumPos;
    }

}


