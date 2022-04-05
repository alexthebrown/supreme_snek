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


    































/*
public class Input implements ActionListener {
    Timer time = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0;
    public Input() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
        

        JPanel panel = new JPanel();
        JLabel up = new JLabel();
        JLabel down = new JLabel();
        JLabel left = new JLabel();
        JLabel right = new JLabel();

        panel.add(up);
        panel.add(down);
        panel.add(left);
        panel.add(right);

        up.setText("Up : 0");
        down.setText("Down : 0");
        left.setText("Left : 0");
        right.setText("Right : 0");

        
    
        time.start();

        frame.addKeyListener(new KeyListener(){

            int upCount = 0;
            int downCount = 0;
            int leftCount = 0;
            int rightCount = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch(keyCode) {
                    case KeyEvent.VK_UP:
                        velX = 0;
                        velY += 1;
                        break;
                    case KeyEvent.VK_DOWN:
                        velX = 0;
                        velY += -1;
                        break;
                    case KeyEvent.VK_LEFT:
                        velX += -1;
                        velY = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        velX += 1;
                        velY = 0;
                        break;
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });

        frame.add(panel);
    }

    public void rectangleCharacter(Graphics g) {
        rectangleCharacter(g);
        g.setColor(Color.BLUE);
        g.fillRect(x,y, 50, 30);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(x < 0 || x > 350) {
           velX = 0;
       }
       if (y < 0 || y > 350) {
           velY = 0;
       }
       
        x += velX;
        y += velY;
        
    }*/
