
package GameScreen;


import KnightAdventure.Window;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameMenuScreen {
    public static Game game;
    private JLabel Background = new JLabel(new ImageIcon(getClass().getResource("/images/background/Background_menu.png")));
    
    private ImageIcon playgameButtonBasic = new ImageIcon(getClass().getResource("/images/button/playgameButtonBasic.png"));
    private ImageIcon playgameButtonEntered = new ImageIcon(getClass().getResource("/images/button/playgameButtonEntered.png"));
    private ImageIcon quitButtonBasic = new ImageIcon(getClass().getResource("/images/button/quitButtonBasic.png"));
    private ImageIcon quitButtonEntered = new ImageIcon(getClass().getResource("/images/button/quitButtonEntered.png"));
    private JButton playgameButton = new JButton(playgameButtonBasic);
    private JButton quitButton = new JButton(quitButtonBasic);
    
    JFrame frame  = Window.frame;
    public GameMenuScreen(){

        
        frame.getContentPane().add(playgameButton);
        playgameButton.setBounds(1280/2-400/2, 380, 400, 120);
        playgameButton.setBorderPainted(false);
        playgameButton.setContentAreaFilled(false);
        playgameButton.setFocusPainted(false);
        playgameButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                playgameButton.setIcon(playgameButtonEntered);
                playgameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                playgameButton.setIcon(playgameButtonBasic);
                playgameButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                exitMainMenu();
                game = new Game();
            }
        });
        
        
         Window.frame.getContentPane().add(quitButton);
        quitButton.setBounds(1280/2-250/2, 530, 250, 85);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                quitButton.setIcon(quitButtonEntered);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                quitButton.setIcon(quitButtonBasic);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                //Music buttonEnteredMusic = new Music("clickMouse.mp3", false);
                //buttonEnteredMusic.start(); 
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();  
                }
                System.exit(0);
            }
        });
        frame.getContentPane().add(Background);
        Background.setBounds(0, 0, 1280, 720);

    }
    private void exitMainMenu(){
        frame.getContentPane().remove(playgameButton);
        frame.getContentPane().remove(quitButton);
        frame.getContentPane().remove(Background);
    }

}
