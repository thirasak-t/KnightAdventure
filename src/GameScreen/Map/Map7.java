
package GameScreen.Map;

import GameScreen.Stage;
import Object.LMagicball;
import Object.LSoulball;
import Object.RMagicball;
import Object.RSoulball;




public class Map7 extends Map{
    public Map7(Stage s){
        STAGE = s;
        numMap = 7;
        
    }
    @Override
    protected void createXObstacle() {
        for(int i = 0; i<6;i++){
            xObstacle[0][i] = new LMagicball(552-64*0);
            xObstacle[1][i] = new LMagicball(552-64*1);
            xObstacle[2][i] = new RSoulball(552-64*2);
            xObstacle[3][i] = new RMagicball(552-64*3);
            xObstacle[4][i] = new RSoulball(552-64*4);
            xObstacle[5][i] = new LMagicball(552-64*5);
            xObstacle[6][i] = new RSoulball(552-64*6);
            xObstacle[7][i] = new LSoulball(552-64*7);
        }
    }
    @Override
    protected void setObstacles(){
        
        for(int i = 0; i< 8;i++){
            NoPointShot[i]=3;
            int num1,num2,num3;
            num1 = (int)((Math.random())*100)%8;
            do { num2 = (int)((Math.random())*100)%8;
            }while(num1-1<=num2&&num1+1>=num2);
            do { num3 = (int)((Math.random())*100)%8;
            }while(num1-1<=num3&&num1+1>=num3&&num2-1<=num3&&num2+1>=num3);
            xObstacle[i][0].setX(384+(num1*64));
            xObstacle[i][1].setX(384+(num2*64));
            xObstacle[i][2].setX(384+(num3*64));
            xObstacle[i][0].setLocationObstacle();
            xObstacle[i][1].setLocationObstacle();
            xObstacle[i][2].setLocationObstacle();
            xObstacle[i][0].setShooting();
            xObstacle[i][1].setShooting();
            xObstacle[i][2].setShooting();
        } 
     
    }
    protected void setRow1(){
        shotSequenceRow1.add(1);
        shotSequenceRow1.add(0);
        shotSequenceRow1.add(1);
        shotSequenceRow1.add(1);
        shotSequenceRow1.add(0);
        shotSequenceRow1.add(0);
        shotSequenceRow1.add(1);
    }
    protected void setRow2(){

        shotSequenceRow2.add(0);
        shotSequenceRow2.add(1);
        shotSequenceRow2.add(1);
        shotSequenceRow2.add(0);
        shotSequenceRow2.add(1);
    }
    protected void setRow3(){
        shotSequenceRow3.add(1);
        shotSequenceRow3.add(0);
        shotSequenceRow3.add(0);
        shotSequenceRow3.add(1);
        shotSequenceRow3.add(0);
        
    }
    protected void setRow4(){
        shotSequenceRow4.add(0);
        shotSequenceRow4.add(1);
        shotSequenceRow4.add(0);
        shotSequenceRow4.add(0);
        shotSequenceRow4.add(1);
        shotSequenceRow4.add(0);
        shotSequenceRow4.add(1);
        
    }
    protected void setRow5(){
        shotSequenceRow5.add(1);
        shotSequenceRow5.add(0);
        shotSequenceRow5.add(1);
        shotSequenceRow5.add(1);
        shotSequenceRow5.add(0);
    }
    protected void setRow6(){
        shotSequenceRow6.add(1);
        shotSequenceRow6.add(0);
        shotSequenceRow6.add(1);
        shotSequenceRow6.add(1);
        shotSequenceRow6.add(0);
        shotSequenceRow6.add(1);
        shotSequenceRow6.add(1);
        shotSequenceRow6.add(1);
        shotSequenceRow6.add(0);
        shotSequenceRow6.add(1);
    }
    protected void setRow7(){
        shotSequenceRow7.add(1);
        shotSequenceRow7.add(0);
        shotSequenceRow7.add(1);
        shotSequenceRow7.add(1);
        shotSequenceRow7.add(0);
        shotSequenceRow7.add(0);
        shotSequenceRow7.add(1);
        shotSequenceRow7.add(1);
        shotSequenceRow7.add(0);
        
    }
    protected void setRow8(){
        shotSequenceRow8.add(0);
        shotSequenceRow8.add(1);
        shotSequenceRow8.add(0);
        shotSequenceRow8.add(1);
        shotSequenceRow8.add(1);
        shotSequenceRow8.add(1);
        shotSequenceRow8.add(0);
        shotSequenceRow8.add(1);
        shotSequenceRow8.add(0);
        shotSequenceRow8.add(1);
        shotSequenceRow8.add(1);
    }
}
