
package GameScreen.Shop;


import GameScreen.GameScreen;
import Object.Player;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class ItemArmor extends Item{
    private int LvArmor;
    public ItemArmor(int i, int x, int y, int price){
        LvArmor = i;
        super.price = price;
        canBuy =  new ImageIcon(getClass().getResource("/images/shop/ITEEM-ARMOR-T"+i+".png"));
        canntBuy =  new ImageIcon(getClass().getResource("/images/shop/ITEEM-ARMOR-F"+i+".png"));
        
        item = new JLabel(canBuy);
        item.setBounds(x, y, 480, 64);
        frame.getContentPane().add(item);
    }

    @Override
    public void buyItem() {
        //System.out.println("AA Pass");
        Player.coin.subCoin(price);
        GameScreen.player.addArmor();
    }
    @Override
    public boolean canBuyItem(){
        //System.out.println("A Pass");
        return Player.ARMOR.getNumArmor()+1==LvArmor&&Player.coin.getCoin()>= price;
    }
}
