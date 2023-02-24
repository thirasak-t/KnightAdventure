
package Object;

import javax.swing.ImageIcon;


public class LSoulball extends LXAxisObstacle {
    public LSoulball(int y){
        this.y = y;
        f_speed = 3;
        f_damage = 2;
        
    }

    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/LSoulball.png")));
    }
}
