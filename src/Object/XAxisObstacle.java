
package Object;

import GameScreen.Game;
import GameScreen.GameScreen;
import KnightAdventure.Window;
import javax.swing.JFrame;
import javax.swing.JLabel;

abstract public class XAxisObstacle {
    protected GameScreen gameScreen= Game.gameScreen;
    protected JLabel xAxisObstacle = new JLabel();
    protected JFrame frame  = Window.frame;
    protected int damage, speed, x, y;boolean shooting;
    protected int f_damage, f_speed, f_x;boolean f_shooting;
    public XAxisObstacle(){
        xAxisObstacle = new JLabel();
        f_shooting = false;
        frame.getContentPane().add(xAxisObstacle);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getDamage(){
        return damage;
    }
    public boolean getShooting(){
        return shooting;
    }
    public void setShooting(){
        shooting = true;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setLocationObstacle(){
        xAxisObstacle.setLocation(x, y);
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void addDamage(){
        damage++;
    }
    public void addSpeed(){
        speed++;
    }
    public void addSpeed(int n){
        speed+=n;
    }
    public void hitShot(){
        shooting = false;
        gameScreen.player.damaged(damage);
        resetLocation();
        dontShowArrow();
        
    }
    public void endOfShooting(){
        shooting = false;
        resetLocation();
        dontShowArrow();
    }
    public void showArrow(){
        xAxisObstacle.setVisible(true);
    }
    public void dontShowArrow(){
        xAxisObstacle.setVisible(false);
    }
    public abstract void setDefaultXObstacle();
    public abstract boolean isEndOfShooting();
    public abstract void move();
    public abstract void resetLocation();
    public boolean isHitShot(){
        return (x+56>GameScreen.player.getX()&& x<GameScreen.player.getX()+56 &&y == GameScreen.player.getY());
    }
}

