
package Object;

import javax.swing.ImageIcon;


public class LArrow extends LXAxisObstacle{
        public LArrow(int y){
        this.y = y;
        f_speed = 3;
        f_damage = 1;
        
    }
    @Override
    protected void setIconObstacle() {
        xAxisObstacle.setIcon(new ImageIcon(getClass().getResource("/images/obstacles/ArrowLLv1.png")));
    }
    
}