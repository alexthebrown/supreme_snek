import java.util.LinkedList;
package game;
/**
 * This repersents the Snake character
 */
public class Character {

    /* Maximum size of Board in x-direction */
    static final int BOARD_SIZE_X = 32;
    /* Maximum size of Board in y-direction */
    static final int BOARD_SIZE_Y = 32;
    /* Creats an array list for the Snake Charater */
    private LinkedList<Cell> snakeCells = new LinkedList();
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
    public void MoveSnake(){

        Cell tail = snakeCells.removeLast();
        //tail.setCellType(CellType.EMPTY);
        
        head = nextCell;
        snakeCells.addFirst();
    }

    /**
     * A method to return if the Snake has crashed or not have crashed
     * 
     * @return isCrashed, true or false if the head crashes
     */
    public boolean isCrashed(){

        return isCrashed;
    }

    /**
     * More Methods
     * 1. returns the snake
     * 2. set values in the snake
     * 3. returns the head of the snake
     * 4. sets the head of the snake
     */

}