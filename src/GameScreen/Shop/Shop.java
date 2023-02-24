
package GameScreen.Shop;


import GameScreen.Game;
import GameScreen.Stage;
import KnightAdventure.Window;
import Object.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Shop implements Runnable{
    private Thread thread;
    private JFrame frame  = Window.frame;
    public static boolean SHOWSHOP;
    private JLabel shop = new JLabel(new ImageIcon(getClass().getResource("/images/shop/SHOP.png")));
    private JButton exitShop = new JButton(new ImageIcon(getClass().getResource("/images/shop/exitButtonEnered.png")));
    private JLabel coin = new JLabel();
    private boolean isExitShop = true;
    public static Item itemHeart;
    public static Item itemArmorLv1;
    public static Item itemArmorLv2;
    public static Item itemArmorLv3;
    public static Item itemArmorLv4;
    public static Item itemArmorLv5;
    public static Item itemArmorLv6;
    private JLabel num[] = new JLabel[7];
    public Shop(){
        thread = new Thread(this);
        thread.start();
        for (int i = 0;i<7;i++){
            num[i] = new JLabel();
            num[i].setText(String.valueOf(i+1));
            num[i].setFont(new Font("Tahoma", 1, 24));
            num[i].setBounds(255, 135+64*i, 64, 64);
            num[i].setForeground ( Color.white );
            frame.getContentPane().add(num[i]);
            num[i].setVisible(false);
        }
        itemHeart = new ItemHeart(280,135,10);
        itemArmorLv1 = new ItemArmor(1,280,135+64*1,10);
        itemArmorLv2 = new ItemArmor(2,280,135+64*2,15);
        itemArmorLv3 = new ItemArmor(3,280,135+64*3,20);
        itemArmorLv4 = new ItemArmor(4,280,135+64*4,30);
        itemArmorLv5 = new ItemArmor(5,280,135+64*5,40);
        itemArmorLv6 = new ItemArmor(6,280,135+64*6,50);
        exitShop.setBounds(1009, 120, 32, 32);
        exitShop.setBorderPainted(false);
        exitShop.setContentAreaFilled(false);
        exitShop.setFocusPainted(false);
        exitShop.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mousePressed(MouseEvent e){
                dontShowShop();
            }
        });
        frame.getContentPane().add(exitShop);
        
        coin.setFont(new Font("Tahoma", 1, 24));
        coin.setBounds(820, 545, 100, 30);
        coin.setForeground ( Color.RED );
        frame.getContentPane().add(coin);
        
        shop.setBounds(640-400, 720/2-240, 800, 480);
        frame.getContentPane().add(shop);
        dontShowShop();
        
    }
    @Override
    public void run(){
        while(true){
            try{
                if(isShowShop()&&isExitShop)showShop();
                else if(SHOWSHOP){
                    itemArmorLv1.purchaseStatus();
                    itemArmorLv2.purchaseStatus();
                    itemArmorLv3.purchaseStatus();
                    itemArmorLv4.purchaseStatus();
                    itemArmorLv5.purchaseStatus();
                    itemArmorLv6.purchaseStatus();
                    itemHeart.purchaseStatus();
                    coin.setText(String.valueOf(Player.coin.getCoin()));
                }
       
                else if (isShowShop() == false) isExitShop = true;
                Thread.sleep(50);
            }catch(InterruptedException e){
                //e.printStackTrace(); 
            }
        }
        
    }
    private boolean isShowShop(){
        return Stage.stage%5==0&&Stage.stage!=0;
    }
    private void showShop(){
        SHOWSHOP = true;
        Game.play=false;
        isExitShop = false;
        for(int i = 0;i<7;i++)num[i].setVisible(true);
        itemArmorLv1.showItem();
        itemArmorLv2.showItem();
        itemArmorLv3.showItem();
        itemArmorLv4.showItem();
        itemArmorLv5.showItem();
        itemArmorLv6.showItem();
        itemHeart.showItem();
        coin.setVisible(true);
        shop.setVisible(true);
        exitShop.setVisible(true);
        
    }
    public void dontShowShop(){
        for(int i = 0;i<7;i++)num[i].setVisible(false);
        itemArmorLv1.dontShowItem();
        itemArmorLv2.dontShowItem();
        itemArmorLv3.dontShowItem();
        itemArmorLv4.dontShowItem();
        itemArmorLv5.dontShowItem();
        itemArmorLv6.dontShowItem();
        itemHeart.dontShowItem();
        SHOWSHOP = false;
        Game.play=true;
        coin.setVisible(false);
        exitShop.setVisible(false);
        shop.setVisible(false);
        
    }
}
