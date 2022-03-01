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

    private LinkedList<Cell> snakeCells= new LinkedList();
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

    }
    /**
     * A method to 
     */
    public void MoveSnake(){

    }

    /**
     * A method to return if the Snake has crashed or not have crashed
     * 
     * @return isCrashed, true or false if 
     */
    public boolean isCrashed(){
        return isCrashed;
    }

    


}