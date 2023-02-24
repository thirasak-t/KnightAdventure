
package GameScreen;

import KnightAdventure.Window;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score {
    private JFrame frame  = Window.frame;
    private int score;
    public static JLabel ShowScore = new JLabel();
    public Score(){
        score = 0;
        ShowScore.setFont(new Font("Tahoma", 1, 24));
        ShowScore.setBounds(1050, 0, 300, 30);
        ShowScore.setText("SCORE "+score);
        ShowScore.setForeground ( Color.RED );
        frame.getContentPane().add(ShowScore);
        
    }
    public void setScore(int n){score = n;showScore();}
    public void resetScore(){score-=score;showScore();}
    public void addScore(int n){
        score+=n;
        showScore();
    }
    public void showScore(){ShowScore.setText("SCORE "+score);;}
    public int getScore(){return score;}
    public void destroyScore(){
        setScore(0);frame.getContentPane().remove(ShowScore);
    }
}
