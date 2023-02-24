
package Object;

import javax.swing.ImageIcon;


public class LMagicball extends LXAxisObstacle {
    public LMagicball(int y){
        this.y = y;
        f_speed = 4;
        f_damage = 1;
        
    }
    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/LMagicball.png")));
    }
    
}
