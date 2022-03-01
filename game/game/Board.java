package game;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;



public class Board extends JFrame { //Alex's Work

private int Collums;
private int rows;

    public Board(){
        setTitle("Supreme Snek");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,100,720,720);
        setIconImage(game\game\icon.png);

        JPanel pane = new JPanel();


        pane.setBackground(new Color(66,245,99) );
        pane.setLayout(null);

        setContentPane(pane);

        JLabel label = new JLabel("Supreme Snek Game");
        label.setForeground(new Color(245,66,230));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Comic Sans",Font.BOLD, 20));
        label.setBounds(0,0,720,47);

        pane.add(label);

        JPanel setupPane = new JPanel();

        setupPane.setBackground(new Color(66,245,99) );
        setupPane.setLayout(null);

        setContentPane(setupPane);


        int[][] gameGrid = new int[this.Collums][this.rows];

    }

}