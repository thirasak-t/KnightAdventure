
package GameScreen;

import KnightAdventure.Window;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class MEMUGameOver {
    private JFrame frame  = Window.frame;
    //gameover
    private ImageIcon playButtonBasic = new ImageIcon(getClass().getResource("/images/button/playButtonBasic.png"));
    private ImageIcon playButtonEntered = new ImageIcon(getClass().getResource("/images/button/playButtonEntered.png"));
    private ImageIcon QuitButtonBasic = new ImageIcon(getClass().getResource("/images/button/quitTapButtonBasic.png"));
    private ImageIcon QuitButtonEntered = new ImageIcon(getClass().getResource("/images/button/quitTapButtonEntered.png"));
    private JLabel gameOverLabel = new JLabel(new ImageIcon(getClass().getResource("/images/label/GameOver.png")));
    private JButton playButton = new JButton(playButtonBasic);
    private JButton QuitButton = new JButton(QuitButtonBasic);
    
    private HighScore highS;
    private int highScore = 0;
    private JLabel ShowHighScore = new JLabel();
    private JLabel ShowLastScore = new JLabel();
    private Game game;
    public MEMUGameOver(Game g){
        game = g;
        ShowLastScore.setFont(new Font("Tahoma", 1, 36));
        ShowLastScore.setBounds(1280/2-200, 415, 400, 30);
        ShowLastScore.setText(String.valueOf(0));
        ShowLastScore.setHorizontalAlignment ( SwingConstants.CENTER );
        ShowLastScore.setForeground ( Color.RED );
        ShowLastScore.setVisible(false);
        frame.getContentPane().add(ShowLastScore);
        
        highS = new HighScore();
        highScore = highS.getHighScore();
        
        ShowHighScore.setFont(new Font("Tahoma", 1, 36));
        ShowHighScore.setBounds(1280/2-200, 300, 400, 30);
        ShowHighScore.setText(String.valueOf(highScore));
        ShowHighScore.setHorizontalAlignment ( SwingConstants.CENTER );
        ShowHighScore.setForeground ( Color.blue );
        ShowHighScore.setVisible(false);
        frame.getContentPane().add(ShowHighScore);
        playButton.setBounds(1280/2-150, 500, 100, 50);
        playButton.setVisible(false);
        frame.getContentPane().add(playButton);
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setFocusPainted(false);
        playButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                playButton.setIcon(playButtonEntered);
                playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                playButton.setIcon(playButtonBasic);
                playButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                 game.resetGame();
                 dontShowGameOver();
                 
            }
        });
        QuitButton.setBounds(1280/2+50, 500, 100, 50);
        frame.getContentPane().add(QuitButton);
        QuitButton.setVisible(false);
        QuitButton.setBorderPainted(false);
        QuitButton.setContentAreaFilled(false);
        QuitButton.setFocusPainted(false);
        QuitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                QuitButton.setIcon(QuitButtonEntered);
                QuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                QuitButton.setIcon(QuitButtonBasic);
                QuitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                 try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();  
                }
                System.exit(0);
            }
        });
        gameOverLabel.setBounds(640-400/2, 100, 400, 500);
        gameOverLabel.setVisible(false);
        frame.getContentPane().add(gameOverLabel);
    }
    public void showGameOver(){
        setlLastScore();
        calHighScore();
        highS.setHighScore(highScore);
        playButton.setVisible(true);
        QuitButton.setVisible(true);
        gameOverLabel.setVisible(true);
        ShowHighScore.setVisible(true);
        ShowLastScore.setVisible(true);
    }
    private void dontShowGameOver(){
        Game.endGame = false;
        playButton.setVisible(false);
        QuitButton.setVisible(false);
        gameOverLabel.setVisible(false);
        ShowHighScore.setVisible(false);
        ShowLastScore.setVisible(false);
    }
    private void calHighScore(){
        if (GameScreen.score.getScore()>highScore)highScore=GameScreen.score.getScore();
        ShowHighScore.setText(String.valueOf(highScore));
    }
    private void setlLastScore(){
        ShowLastScore.setText(String.valueOf(GameScreen.score.getScore()));
    }
}
