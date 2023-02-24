
package KnightAdventure;


import GameScreen.GameScreen;
import GameScreen.Game;
import GameScreen.Shop.Shop;
import Object.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Game game;
    private boolean A = false, N= false, P= false, L =false;
    public KeyInput(Game g){//frame.addKeyListener(this);
        game = g;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        if(Game.endGame ){
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (Shop.SHOWSHOP==false)GameScreen.MenuQuitGame.menuQuitGame();
        }
        else if (Shop.SHOWSHOP){
            //System.out.println(e.getKeyCode());
            if(e.getKeyCode() == KeyEvent.VK_1||e.getKeyCode() == KeyEvent.VK_NUMPAD1)
                if(Shop.itemHeart.canBuyItem())
                    Shop.itemHeart.buyItem();
            if(e.getKeyCode() == KeyEvent.VK_2||e.getKeyCode() == KeyEvent.VK_NUMPAD2)
                if(Shop.itemArmorLv1.canBuyItem())
                    Shop.itemArmorLv1.buyItem();
            if(e.getKeyCode() == KeyEvent.VK_3||e.getKeyCode() == KeyEvent.VK_NUMPAD3)
                if(Shop.itemArmorLv2.canBuyItem())
                    Shop.itemArmorLv2.buyItem();
            if(e.getKeyCode() == KeyEvent.VK_4||e.getKeyCode() == KeyEvent.VK_NUMPAD4)
                if(Shop.itemArmorLv3.canBuyItem())
                    Shop.itemArmorLv3.buyItem();
            if(e.getKeyCode() == KeyEvent.VK_5||e.getKeyCode() == KeyEvent.VK_NUMPAD5)
                if(Shop.itemArmorLv4.canBuyItem())
                    Shop.itemArmorLv4.buyItem();
            if(e.getKeyCode() == KeyEvent.VK_6||e.getKeyCode() == KeyEvent.VK_NUMPAD6)
                if(Shop.itemArmorLv5.canBuyItem())
                    Shop.itemArmorLv5.buyItem();
            if(e.getKeyCode() == KeyEvent.VK_7||e.getKeyCode() == KeyEvent.VK_NUMPAD7)
                if(Shop.itemArmorLv6.canBuyItem())
                    Shop.itemArmorLv6.buyItem();
        }
        else if (Game.play){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                case KeyEvent.VK_UP:
                    Player.charecter.changeImageActionToUp();
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    Player.charecter.changeImageActionToDown();
                    break;
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    Player.charecter.changeImageActionToLeft();
                    break;
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    Player.charecter.changeImageActionToRight();
                    break;
                default:
                    break;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        if(Game.endGame){
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (Shop.SHOWSHOP==false)game.changePlayState();
            if (Shop.SHOWSHOP)GameScreen.shop.dontShowShop();
        }
        
        else if (Game.play){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                case KeyEvent.VK_UP:
                    GameScreen.player.playerMoveUp();
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    GameScreen.player.playerMoveDown();
                    break;
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    GameScreen.player.playerMoveLeft();
                    break;
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    GameScreen.player.playerMoveRight();
                    break;
                default:
                    break;
            }
            
            
            if (e.getKeyCode() == KeyEvent.VK_A&&A==false)A = true;
            else if (e.getKeyCode() == KeyEvent.VK_N && A&&N==false) N = true;
            else if (e.getKeyCode() == KeyEvent.VK_P && N&&P==false) P = true;
            else if (e.getKeyCode() == KeyEvent.VK_L && P &&L==false ) L = true;
            else if (e.getKeyCode() == KeyEvent.VK_J&& L) {GameScreen.player.damaged(1);}
            else if (e.getKeyCode() == KeyEvent.VK_K&& L) {GameScreen.player.receiveHeart();}
            else if (e.getKeyCode() == KeyEvent.VK_L&& L) {GameScreen.player.addArmor();}
            else if (e.getKeyCode() == KeyEvent.VK_U&& L) {GameScreen.player.damaged(2);}
            else if (e.getKeyCode() == KeyEvent.VK_I&& L) {GameScreen.STAGE.passStage();}
            else if (e.getKeyCode() == KeyEvent.VK_O&& L) {Player.coin.addCoin(500);}
            else{
                A = false;
                N = false;
                P = false;
                L = false;
            }
        }
    }

    
}