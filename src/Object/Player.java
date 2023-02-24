
package Object;

import GameScreen.Armor;
import GameScreen.Charecter;
import GameScreen.Coin;
import GameScreen.Game;
import GameScreen.GameScreen;
import GameScreen.Heart;
import javax.swing.JLabel;


public class Player {
    public static Heart HEART;
    public static Armor ARMOR;
    public static Charecter charecter;
    public static Coin coin;
    private int x ,y;
    private JLabel PlAYER;
    private Game game;
    private GameScreen gameScreen;
    public Player(Game game, GameScreen gs){
        this.game = game;
        x = 640;
        y = 616;
        gameScreen = gs;
        HEART = new Heart();
        ARMOR = new Armor();
        coin = new Coin();
        charecter = new Charecter(ARMOR.getNumArmor());
        PlAYER = charecter.charecterPlayer;
        PlAYER.setBounds(x, y, 64, 64);
        
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean isDied(){
        return HEART.getNumHeart() == 0;
    }
    public void damaged(int n){
        if(ARMOR.getNumArmor()>0){
            if(n>ARMOR.getNumArmor())loseHeart();
            for(int i = 0; i<n&&ARMOR.getNumArmor()!=0;i++){
                ARMOR.decreaseArmor();
                ARMOR.decreaseIconArmor();
            } 
        }
        else loseHeart();
        charecter.changeImageAction(ARMOR.getNumArmor());
        charecter.changeImagePlayer();
    }
    public void addArmor(){
        if(ARMOR.getNumArmor()<6){
            ARMOR.increaseIconArmor();
            ARMOR.increaseArmor();
            charecter.changeImageAction(ARMOR.getNumArmor());
            charecter.changeImagePlayer();}
     }
    public void receiveHeart(){
        if(HEART.getNumHeart()<HEART.getMaxHeart()){
            HEART.increaseIconHeart();
            HEART.increaseHeart();}
    }
    public void loseHeart(){
        if(HEART.getNumHeart()>0){
            HEART.decreaseHeart();
            HEART.decreaseIconHeart();}
        if(isDied())game.gameOver();
        else resetLocationPlayer();
        
    }
    public void playerMoveUp(){
        if(y>40){y-=64;PlAYER.setLocation(x, y);}
        else {
            if(gameScreen.STAGE.stage!=50)resetLocationPlayer();
            gameScreen.STAGE.passStage();}
    }
    public void playerMoveDown(){
        if(y<616)y+=64;
        PlAYER.setLocation(x, y);
    }
    public void playerMoveLeft(){
        if(x>384)x-=64;
        PlAYER.setLocation(x, y);
    }   
    public void playerMoveRight(){
        if(x<832)x+=64;
        PlAYER.setLocation(x, y);
    }
    public void resetLocationPlayer(){
        y = 616;
        charecter.changeImageActionToUp();
        PlAYER.setLocation(x, y);
    }
    public void resetPlayer(){
        x = 640 ;
        y = 616;
        PlAYER.setLocation(x, y);
        HEART.resertHeart();
        ARMOR.resertArmor();
        charecter.resetCharecter();
        coin.resetCoin();
    }

}
