

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Toolkit;
import java.awt.event.*;


	public class GameFrame extends JFrame implements ActionListener{
	    GamePanel panel;
	    JButton resetButton;
	    
		GameFrame(){
			this.setTitle("Supreme Snek");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setSize(600,500);
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon.gif")));
			
			
			resetButton = new JButton();
			resetButton.setText("Reset");
			resetButton.setSize(100,50);
			resetButton.setLocation(330,450);
			resetButton.addActionListener(this);
			
			panel = new GamePanel();
			this.add(resetButton);
			this.add(panel);
			
		
			this.pack();
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==resetButton) {
				this.remove(panel);
				panel = null;
				panel = new GamePanel();
				this.add(panel);
				panel.requestFocusInWindow();
				SwingUtilities.updateComponentTreeUI(this);
				
			}
			
			
		}

}


	



