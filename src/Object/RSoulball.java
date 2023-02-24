
package Object;

import javax.swing.ImageIcon;


public class RSoulball extends RXAxisObstacle  {
    public RSoulball(int y){
        this.y = y;
        f_speed = 3;
        f_damage = 2;
    }
    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/RSoulball.png")));
    }
    
}
