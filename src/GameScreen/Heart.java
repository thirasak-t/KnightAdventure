
package GameScreen;

import KnightAdventure.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Heart {
    private ImageIcon iconHeart = new ImageIcon(getClass().getResource("/images/icon/64Pixel-Heart.png"));
    private int numHeart ,maxHeart = 4;
    //public static JLabel[] heart = new JLabel[4];
    private JLabel[] heart = new JLabel[4];
    private JFrame frame  = Window.frame;
    public Heart(){
        numHeart = 3;
        for (int i = 0 ; i <maxHeart; i++){
            heart[i] = new JLabel(iconHeart);
            heart[i].setBounds(6+72*i,60,64,64);
            frame.getContentPane().add(heart[i]);
            if(i>=numHeart)heart[i].setVisible(false);
        }
    }
    public int getNumHeart(){return numHeart;}
    public int getMaxHeart(){return maxHeart;}
    public void increaseHeart(){numHeart++;}
    public void decreaseHeart(){numHeart--;}
    public void increaseIconHeart(){heart[numHeart].setVisible(true);}
    public void decreaseIconHeart(){heart[numHeart].setVisible(false);}
    public void resertHeart(){
        numHeart = 3;
        for(int i = 0; i < numHeart;i++)
            heart[i].setVisible(true);
    }
}
