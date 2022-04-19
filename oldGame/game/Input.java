package game;

//import java.awt.Color;
//import java.awt.Component;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.Graphics;
//import java.io.Serializable;
//import java.lang.Comparable;


//import javax.swing.*;
//public enum CellType< EMPTY, FOOD extends java.lang.Enum CellType;
enum CellType {FOOD , EMPTY}




    public class Input {
        public static final int MOVE_STOPPED = 0;
        public static final int MOVE_RIGHT = 1;
        public static final int MOVE_LEFT = -1;
        public static final int MOVE_UP = 2;
        public static final int MOVE_DOWN = -2;

        private Character snake;
        private Board board;
        private int movement;
        private boolean gameEnded;

        public Input(Character snake, Board board) {
            this.snake = snake;
            this.board = board;
        }

        public Character getSnake() {
            return snake;
        }

        public void setSnake(Character snake) {
            this.snake = snake;
        }

        public Board getBoard() {
            return board;
        }

        public void setBoard(Board board) {
            this.board = board;
        }

        public boolean isGameEnded() {
            return gameEnded;
        }

        public int getMovement() {
            return movement;
        }

        public void setDirection(int movement) 
	    { 
		this.movement = movement; 
	    } 

        public void updateSnake() {
            if (!isGameEnded()) {
                if(movement != MOVE_STOPPED) {
                    Cell moveCell = getSnakesCells(snake.getHead());

                    if (snake.isCrashed(moveCell)) {
                        setDirection(movement);
                        gameEnded = true;
                    }
                    else {
                        snake.MoveSnake(moveCell);
                        if(moveCell.getCellType() == CellType.FOOD) {
                            snake.growSnake();
                            board.generateFood();
                        }
                    }
                }
            }
        }

        private Cell getSnakesCells(Cell currentPosition) {
            int row = currentPosition.getRow();
            int col = currentPosition.getColumn();

            if(movement == MOVE_RIGHT){
                col++;
            }
            else if(movement == MOVE_LEFT){
                col--;
            }
            else if(movement == MOVE_DOWN){
                row++;
            }
            else if(movement == MOVE_UP){
                row--;
            }
            Cell moveCell = board.getCells()[row][col];

            return moveCell;
        }

    public static void main(String args[]) {
        Cell initalPositionCell = new Cell(0,0);
        Character initialSnake = new Character(initalPositionCell);
        Board board = new Board(32, 32);
        Input newGame = new Input(initialSnake, board);
        newGame.gameEnded = false;
        newGame.movement = MOVE_RIGHT;

        for(int i = 0; i < 5; i++) {
            if(i == 2) {
                newGame.board.generateFood();
            }
            newGame.updateSnake();
            if(i == 3) {
                newGame.movement = MOVE_RIGHT;
            }
            if(newGame.gameEnded == true) {
                break;
            }
        }
    }
 }


    








