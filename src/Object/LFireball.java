
package Object;

import javax.swing.ImageIcon;


public class LFireball extends LXAxisObstacle {
    public LFireball(int y){
        this.y = y;
        f_speed = 4;
        f_damage = 2;
    }

    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/LFireball.png")));
    }
}
