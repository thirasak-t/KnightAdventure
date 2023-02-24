
package Object;

import javax.swing.ImageIcon;


public class RFireball extends RXAxisObstacle {
    public RFireball(int y){
        this.y = y;
        f_speed = 4;
        f_damage = 2;
        
    }
    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/RFireball.png")));
    }
    
}
