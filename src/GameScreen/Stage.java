
package GameScreen;

import KnightAdventure.Window;
import GameScreen.Map.Map;
import GameScreen.Map.Map1;
import GameScreen.Map.Map2;
import GameScreen.Map.Map3;
import GameScreen.Map.Map4;
import GameScreen.Map.Map5;
import GameScreen.Map.Map6;
import GameScreen.Map.Map7;
import GameScreen.Map.Map8;
import GameScreen.Map.Map9;
import GameScreen.Map.Map10;
import Object.Player;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Stage{
    public static JLabel Background;
    private Game game;
    private JFrame frame  = Window.frame;
    private JLabel tabNextStage = new JLabel(new ImageIcon(getClass().getResource("/images/label/TabNextStage.png")));
        //stage
    public static int stage = 0,level = 0;
    private String difficulty[] = {"Very Easy", "Easy","Normal","Hard","Very Hard"};
    private JLabel levelDifficulty = new JLabel();
    private JLabel TextStage = new JLabel();
    private Map map[] = new Map[10];
    public Stage(Game g){
        game = g;
        level = 0;
        stage = 0;
        Background = new JLabel();
        map[0] = new Map1(this);
        map[1] = new Map2(this);
        map[2] = new Map3(this);
        map[3] = new Map4(this);
        map[4] = new Map5(this);
        map[5] = new Map6(this);
        map[6] = new Map7(this);
        map[7] = new Map8(this);
        map[8] = new Map9(this);
        map[9] = new Map10(this);
        levelDifficulty.setBounds(1280/2-100,40,200,30);
        levelDifficulty.setFont(new Font("Tahoma", 1, 24));
        levelDifficulty.setForeground ( Color.RED );
        levelDifficulty.setHorizontalAlignment ( SwingConstants.CENTER );
        tabNextStage.setBounds(0, 0, 1280, 60);
        TextStage.setFont(new Font("Tahoma", 1, 24)); 
        TextStage.setBounds(1280/2-100, 0, 200, 30);
        TextStage.setHorizontalAlignment ( SwingConstants.CENTER );
        setStage();
        
    }
    public int getStage(){return stage;}
    private void setStage(){
        frame.getContentPane().add(levelDifficulty);
        frame.getContentPane().add(TextStage);
        frame.getContentPane().add(tabNextStage);
        setTextLevel();
        stage = 1;
        TextStage.setText("Stage "+stage);
        for(int i = 0; i< 10;i++)map[i].setDefaultMap();
    }
    public void setBackground(){
        map[0].setMap();
        frame.getContentPane().add(Background);
        Background.setBounds(0, 0, 1280, 720);
    }
    public void passStage(){
        if(stage==50)game.VictoryGame();
        else{
            GameScreen.score.addScore((Player.coin.getCoin())*10+100);
            if(stage%10==0)nextLevel();
            Player.coin.addCoin(stage);
            stage+=1;
            TextStage.setText("Stage "+stage);
            map[(stage-1)%10].setMap();
        }
    }
    private void setTextLevel(){
        levelDifficulty.setText(difficulty[level]);
    }
    private void nextLevel(){
        level++;
        setTextLevel();
        for(int i = 0; i< 10;i++)map[i].increasingDifficulty();
        
    }
    public void resertStage(){
        stage = 1;
        map[0].setMap();
        TextStage.setText("Stage "+stage);
        level = 0;
        setTextLevel();
        for(int i = 0; i< 10;i++)map[i].setDefaultMap();
    }
    
}
