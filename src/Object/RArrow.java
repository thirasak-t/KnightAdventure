
package Object;

import javax.swing.ImageIcon;


public class RArrow extends RXAxisObstacle {
    public RArrow(int y){
        this.y = y;
        f_speed = 3;
        f_damage = 1;
    }

    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/ArrowRLv1.png")));
    }
}
