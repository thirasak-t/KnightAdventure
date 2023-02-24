
package KnightAdventure;

import javax.swing.JFrame;
import java.awt.Color;


public class Window{
    public static JFrame frame;
    public Window() {
        frame = new JFrame ();
        frame.setTitle("Knight Adventure");
        frame.setSize(KnightAdventure.SCREEN_WIDTH, KnightAdventure.SCREEN_HIGHT);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(new Color(0));
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new java.awt.Dimension(1280, 720));
        frame.getContentPane().setLayout(null);
        frame.pack();
    }   
}