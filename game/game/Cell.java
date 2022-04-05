package game;
public class Cell {

    /**
     * The current Cell Type
     */
    private int cellType;
    /**
     * The current Cell on the row
     */
    private int row;
    /**
     * The current Cell in the column
     */
    private int col;

    /**
     * This is the constructor that set the cell type, the current row and column
     * 
     * @param type, the given cell type
     * @param row, the given row position
     * @param col, the given column position
     */
    public Cell(int row, int col){
        this.row = row;
        this.col = col;

    }

    /**
     * This updates the cell to the new cell type
     * 
     * @param type, The given Cell type
     */
    public void updateCell(int type){ 
        cellType = type;

    }

    /**
     * This method returns the cell type
     * 
     * @return celltype
     */
    public int getCellType(){
        return cellType;

    }

    /**
     * This method returns the current row
     * 
     * @return row
     */
    public int getRow(){
        return row;

    }

    /**
     * This method returns the current column
     * 
     * @return column
     */
    public int getColumn(){
        return col;

    }

}


