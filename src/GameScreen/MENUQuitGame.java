
package GameScreen;



import KnightAdventure.Window;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MENUQuitGame {
    private JFrame frame  = Window.frame;
    //quitgame
    private ImageIcon yesButtonBasic = new ImageIcon(getClass().getResource("/images/button/yesButtonBasic.png"));
    private ImageIcon yesButtonEntered = new ImageIcon(getClass().getResource("/images/button/yesButtonEntered.png"));
    private ImageIcon noButtonBasic = new ImageIcon(getClass().getResource("/images/button/noButtonBasic.png"));
    private ImageIcon noButtonEntered = new ImageIcon(getClass().getResource("/images/button/noButtonEntered.png"));
    private JLabel quitLabel = new JLabel(new ImageIcon(getClass().getResource("/images/label/TabQuitGame.png")));
    private JButton yesButton = new JButton(yesButtonBasic);
    private JButton noButton = new JButton(noButtonBasic);
    private Game game;
    public MENUQuitGame(Game g){
        game = g;
        yesButton.setBounds(1280/2-150, 300, 100, 50);
        yesButton.setVisible(false);
        frame.getContentPane().add(yesButton);
        yesButton.setBorderPainted(false);
        yesButton.setContentAreaFilled(false);
        yesButton.setFocusPainted(false);
        yesButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                yesButton.setIcon(yesButtonEntered);
                yesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                yesButton.setIcon(yesButtonBasic);
                yesButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        noButton.setBounds(1280/2+50, 300, 100, 50);
        frame.getContentPane().add(noButton);
        noButton.setVisible(false);
        noButton.setBorderPainted(false);
        noButton.setContentAreaFilled(false);
        noButton.setFocusPainted(false);
        noButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                noButton.setIcon(noButtonEntered);
                noButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                noButton.setIcon(noButtonBasic);
                noButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                menuQuitGame();
                game.changePlayState();
            }
        });
        quitLabel.setBounds(640-400/2, 720/2-180, 400, 200);
        quitLabel.setVisible(false);
        frame.getContentPane().add(quitLabel);
    }

        
    private void showMenuQuitGame(){
        yesButton.setVisible(true);
        noButton.setVisible(true);
        quitLabel.setVisible(true);
    }
    private void dontShowMenuQuitGame(){
        quitLabel.setVisible(false);
        yesButton.setVisible(false);
        noButton.setVisible(false);
    }
    public void menuQuitGame(){
        if(game.play)showMenuQuitGame();
        else dontShowMenuQuitGame();
    }
}
