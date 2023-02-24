
package GameScreen.Shop;


import GameScreen.GameScreen;
import Object.Player;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ItemHeart extends Item{
    public ItemHeart(int x, int y, int price){
        super.price = price;
        canBuy  =  new ImageIcon(getClass().getResource("/images/shop/ITEEM-HEART-T.png"));
        canntBuy  =  new ImageIcon(getClass().getResource("/images/shop/ITEEM-HEART-F.png"));
        item = new JLabel(canBuy);
        item.setBounds(x, y, 480, 64);
        frame.getContentPane().add(item);
    }

    @Override
    public void buyItem() {
        //System.out.println("H Pass");
        Player.coin.subCoin(price);
        GameScreen.player.receiveHeart();
    }
    @Override
    public boolean canBuyItem(){
        //System.out.println("H Pass");
        return Player.HEART.getNumHeart()!=4&&Player.coin.getCoin()>= price;
    }
    
}
