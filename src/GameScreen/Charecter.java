
package GameScreen;

import KnightAdventure.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Charecter {
    private int lv_armor = 0;
    private char playerAction = 'u';
    private ImageIcon playerU = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-iii"+lv_armor+".png"));
    private ImageIcon playerD = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-i"+lv_armor+".png"));
    private ImageIcon playerL = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-ii"+lv_armor+".png"));
    private ImageIcon playerR = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-iv"+lv_armor+".png"));
    public static JLabel charecterPlayer;

    private JFrame frame  = Window.frame;
    public Charecter(int numArmor){
        charecterPlayer = new JLabel(playerU);
        lv_armor = numArmor;
        frame.getContentPane().add(charecterPlayer);
    }
    public void changeImageAction(int n){
        playerU = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-iii"+n+".png"));
        playerD = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-i"+n+".png"));
        playerL = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-ii"+n+".png"));
        playerR = new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-iv"+n+".png"));
    }
    public void changeImagePlayer(){
        if(playerAction=='u')charecterPlayer.setIcon(playerU);
        else if(playerAction=='d')charecterPlayer.setIcon(playerD);
        else if(playerAction=='l')charecterPlayer.setIcon(playerL);
        else if(playerAction=='r')charecterPlayer.setIcon(playerR);
    }
    public void changeImageActionToUp(){
        charecterPlayer.setIcon(playerU);playerAction='u'; 
    }
    public void changeImageActionToDown(){
        charecterPlayer.setIcon(playerD); playerAction='d'; 
    }

    public void changeImageActionToLeft(){
        charecterPlayer.setIcon(playerL); playerAction='l'; 
    }
    public void changeImageActionToRight(){
        charecterPlayer.setIcon(playerR); playerAction='r'; 
    }
    public void resetCharecter(){
        playerU =  new ImageIcon(getClass().getResource("/images/charecter/64Pixel-knight-iii"+lv_armor+".png"));
        changeImageActionToUp();
    }
}
