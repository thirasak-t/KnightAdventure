
package GameScreen;


import KnightAdventure.KeyInput;
import KnightAdventure.Window;
import javax.swing.JFrame;


public class Game{
    //gameover
    public static boolean endGame;

    //quitgame
    public static boolean play;
 
    
    private JFrame frame  = Window.frame;
    public static GameScreen gameScreen;
    
    public Game(){
        //frame.addKeyListener(new KeyInput(this));
        gameScreen = new GameScreen(this);
        frame.addKeyListener(new KeyInput(this));
    }
    

    public void changePlayState(){
        play = !play;
    }
    
    public void gameOver(){
        gameScreen.MenuGameOver.showGameOver();
        endGame = true;
    }
    public void VictoryGame(){
        gameScreen.MenuVictoryGame.showVictoryGame();
        endGame = true;
    }
    public void resetGame(){
        endGame = false;
        play = true;
        gameScreen.resetGameScreen();

    }

}
