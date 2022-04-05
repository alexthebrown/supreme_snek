
package game;
import java.util.LinkedList;
/**
 * This repersents the Snake character
 */
public class Character {

    /* Maximum size of Board in x-direction */
    static final int BOARD_SIZE_X = 32;
    /* Maximum size of Board in y-direction */
    static final int BOARD_SIZE_Y = 32;
    /* Creats an array list for the Snake Charater */
    private LinkedList<Cell> snakeCells = new LinkedList<>();
    /* The first pixel for the snake character */
    private Cell head;
    /* True of false statement if the Snake is crashed or not*/
    private boolean isCrashed;

    /**
     * Constructor that initialise the snake with the head
     */
    public Character(Cell initialPosition) {

        head = initialPosition; 
        snakeCells.add(head);
        //head.setCellType(CellType.SNAKE_NODE);
    }
    
    /**
     * A method to grow the length of the Snake
     */
    public void growSnake(){

        snakeCells.add(head);
    }
    /**
     * A method to move the snake
     */
    public void MoveSnake(Cell nextCell){

        Cell tail = snakeCells.removeLast();
        tail.updateCell(CellType.EMPTY);
        
        head = nextCell;
        //head.setCellType(CellType.SNAKE_NODE);
        snakeCells.addFirst(head);
    }

    /**
     * A method to return if the Snake has crashed or not have crashed
     * 
     * @return isCrashed, true or false if the head crashes
     */
    public boolean isCrashed(Cell nextCell){
        isCrashed = false;

        for(Cell cell: snakeCells){
            if(cell == nextCell){
                isCrashed = true;

            }
        }
        return isCrashed;
    }
    /**
     * returns the snake
     * 
     * @return snakeCells which is the the values of the snake in the LinkedList
     */
    public LinkedList<Cell> getSnakeCells() {

        return snakeCells;
    }
    /**
     * This method sets values of the snake
     * 
     * @param snakeCells, all the cells in the linkedlist for the snake
     */
    public void setSnakeCells(LinkedList<Cell> snakeCells) {

        this.snakeCells = snakeCells;
    }
    /**
     * This method returns the head of the snake
     * 
     * @return head, which is the cell head
     */
    public Cell getHead() {
        return head;

    }

    /**
     * This medoth sets the head of the snake
     * 
     * @param head cell loaction of the snake head
     */
    public void setHead(Cell head) {
        this.head = head;

    }


}