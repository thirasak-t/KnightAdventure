
package Object;

import javax.swing.ImageIcon;


public class RMagicball extends RXAxisObstacle {
    public RMagicball(int y){
        this.y = y;
        f_speed = 4;
        f_damage = 1;
        
    }

    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/RMagicball.png")));
    }
}
