

import javax.swing.JFrame;
import javax.swing.border.Border;
import java.awt.Toolkit;

public class GameFrame extends JFrame{

	GameFrame(){
		GamePanel panel = new GamePanel();
		this.add(panel);
		this.setTitle("Supreme Snek");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.gif")));
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(panel);
	}
}
