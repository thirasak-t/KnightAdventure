
package GameScreen;

import KnightAdventure.Window;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Coin {
    private ImageIcon iconCoin = new ImageIcon(getClass().getResource("/images/icon/64Pixel-Coin.png"));
    public static JLabel COIN;
    private int numCoin;
    public static JLabel ShowCoin = new JLabel();
    private JFrame frame  = Window.frame;
    public Coin(){
        numCoin = 0;
        COIN = new JLabel(iconCoin);
        frame.getContentPane().add(COIN);
        COIN.setBounds(6, 200, 64, 64);
        ShowCoin.setText(String.valueOf("X "+numCoin));
        ShowCoin.setBounds(80, 200, 200, 64);
        ShowCoin.setFont(new Font("Tahoma", 1, 40));
        ShowCoin.setForeground ( Color.blue );
        frame.getContentPane().add(ShowCoin);
    }
    public void addCoin(int n){numCoin+=n;showCoin();}
    public void subCoin(int n){numCoin-=n;showCoin();}
    public void reduceCoin(int n){numCoin-=n;showCoin();}
    public int getCoin(){return numCoin;}
    public void showCoin(){
        ShowCoin.setText(String.valueOf("X "+numCoin));
    }
    public void resetCoin(){
        numCoin = 0;
        ShowCoin.setText(String.valueOf("X "+numCoin));
    }
}
