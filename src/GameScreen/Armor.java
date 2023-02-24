
package GameScreen;

import KnightAdventure.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Armor {
    private ImageIcon iconArmor = new ImageIcon(getClass().getResource("/images/icon/64Pixel-Armor.png"));
    private int numArmor ,maxArmor = 6;
    //public static JLabel[] armor = new JLabel[6];
    private JLabel[] armor = new JLabel[6];
    private JFrame frame  = Window.frame;
    public Armor(){
        numArmor = 0;
        for (int i = 0 ; i <maxArmor; i++){
            armor[i] = new JLabel(iconArmor);
            armor[i].setBounds(0+48*i,130,48,64);
            frame.getContentPane().add(armor[i]);
            if(i>=numArmor)armor[i].setVisible(false);
        }
    }
    public int getNumArmor(){return numArmor;}
    public int getMaxArmor(){return maxArmor;}
    public void increaseArmor(){numArmor ++;}
    public void decreaseArmor(){numArmor --;}
    public void increaseIconArmor(){armor[numArmor].setVisible(true);}
    public void decreaseIconArmor(){armor[numArmor].setVisible(false);}
    public void resertArmor(){
        numArmor = 0;
        for(int i = 0; i < 6;i++)armor[i].setVisible(false);
    }
}
