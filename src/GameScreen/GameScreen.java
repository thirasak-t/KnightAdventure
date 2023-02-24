
package GameScreen;


import GameScreen.Shop.Shop;
import Object.Player;


public class GameScreen {


    public static Score score;
    public static Player player;
    public static Shop shop;
    public static Stage STAGE;
    
    public static MEMUGameOver MenuGameOver;
    public static MENUQuitGame MenuQuitGame;
    public static MENUVictoryGame MenuVictoryGame;
    
    private Game game;
    public GameScreen(Game g){
        game = g; 
        //gameover
        MenuGameOver = new MEMUGameOver(game);
        
        //exit
        MenuQuitGame = new MENUQuitGame(game);
        
        //victory
        MenuVictoryGame = new MENUVictoryGame(game);
        
        shop = new Shop();
        score = new Score();
        STAGE = new Stage(game);
        player = new Player(game, this);
        STAGE.setBackground();
    }
    
    public void resetGameScreen(){
        player.resetPlayer();
        score.resetScore();
        STAGE.resertStage();

    }
    

}
