

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	
	static int screen_width = 750;
	static int screen_height = 750;
	static final int UNIT_SIZE = 15;
	static final int GAME_UNITS = (screen_width * screen_height) / UNIT_SIZE;
	static int delay = 60;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten = 0;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean reset = false;
	boolean running = false;
    Color background;
	Timer timer;
	Random random;
	
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(screen_width, screen_height));
        background = Color.black;
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(delay, this);
		timer.start();
	
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		if(running) {
			for(int i = 0; i < screen_height / UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, screen_height);
				g.drawLine(0, i*UNIT_SIZE, screen_width, i*UNIT_SIZE);
			}
            
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE + 5, UNIT_SIZE + 5);
			
			for(int i = 0; i < bodyParts; i++) {
				if(i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.red);
			g.setFont(new Font("Impact", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (screen_width - metrics.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());
			
		}
		else {
			gameOver(g);
			if(reset) {
				startGame();
			}
		}
		
	}
	public void newApple() {
		appleX = random.nextInt((int)(screen_width / (UNIT_SIZE + 5)))*UNIT_SIZE;
		appleY = random.nextInt((int)(screen_height / (UNIT_SIZE + 5)))*UNIT_SIZE;
	}
	public void move() {
		for(int i = bodyParts; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
            delay = delay-5;
            background = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
            this.setBackground(background);
            screen_height = screen_height - 50;
            screen_width = screen_width - 50;
			newApple();
		}
	}
	public void checkCollisions() {
		//Self-Collision Check
		for(int i = bodyParts; i > 0; i--) {
			if((x[0] == x[i])&&(y[0]==y[i])) {
				running = false;
			}
		}
		//Check for wall Left Wall
		if(x[0] < 0) {
			running = false;
		}
		//Right wall
		if(x[0] > screen_width - 1) {
			running = false;
		}
		//Top Check
		if(y[0] < 0) {
			running = false;
		}
		//Bottom Check
		if(y[0] > screen_height - 1) {
			running = false;
		}
		if(!running) {
			timer.stop();
		}
		
	}
	public void gameOver(Graphics g) {
		//Game Over text
		g.setColor(Color.red);
		g.setFont(new Font("Impact", Font.BOLD, 80));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (screen_width - metrics.stringWidth("Game Over"))/2, screen_height / 2);
		if(reset) {
			startGame();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();		
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction ='L';
					break;
				}
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction ='R';
					break;
				}
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction ='U';
					break;
				}
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction ='D';
					break;
				}
			case KeyEvent.VK_ESCAPE:
				if(!running) {
					reset = true;
				}

				break;
			}
		}
	}

}
