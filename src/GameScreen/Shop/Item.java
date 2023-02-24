
package GameScreen.Shop;

import GameScreen.Game;
import GameScreen.GameScreen;
import KnightAdventure.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


abstract public class Item {
    protected ImageIcon canBuy;
    protected ImageIcon canntBuy;
    protected int price;
    protected JLabel item = new JLabel();
    protected JFrame frame  = Window.frame;
    protected GameScreen gameScreen = Game.gameScreen;
    public Item(){
        
        //dontShowItem();
    }
    public abstract void buyItem();
    public abstract boolean canBuyItem();
    public void purchaseStatus(){
        if(canBuyItem())item.setIcon(canBuy);
        else item.setIcon(canntBuy);
    }
    public void showItem(){
        purchaseStatus();
        
        item.setVisible(true);
    }
    public void dontShowItem(){
        item.setVisible(false);
    }
}
