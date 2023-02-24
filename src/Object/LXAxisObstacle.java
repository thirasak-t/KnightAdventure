
package Object;


abstract public class LXAxisObstacle extends XAxisObstacle {
    public LXAxisObstacle(){
        f_x = 896;
    }

    @Override
    public boolean isEndOfShooting() {
        return x<320;
    }

    @Override
    public void move() {
        x-=speed;
        xAxisObstacle.setLocation(x,y);
    }

    @Override
    public void resetLocation() {
        x = 896;
        xAxisObstacle.setLocation(x,y);
    }

    @Override
    public void setDefaultXObstacle() {
        x = f_x;
        speed = f_speed;
        damage = f_damage;
        shooting = f_shooting;
        setIconObstacle();
        xAxisObstacle.setBounds(x, y, 64, 64);
        xAxisObstacle.setVisible(false);
    }
    protected abstract void setIconObstacle();
    
}