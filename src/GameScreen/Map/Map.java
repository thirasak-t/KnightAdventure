
package GameScreen.Map;

import GameScreen.Game;
import GameScreen.Stage;
import Object.XAxisObstacle;
import java.util.ArrayList;
import javax.swing.ImageIcon;



abstract public class Map implements Runnable{
    protected Thread thread;
    protected int numMap;
    protected Stage STAGE;
    protected XAxisObstacle[][] xObstacle = new XAxisObstacle[8][6];
    protected int NoPointShot[] = new int[8];
    protected ArrayList<Integer> shotSequenceRow1 = new ArrayList<Integer>();
    protected ArrayList<Integer> shotSequenceRow2 = new ArrayList<Integer>();
    protected ArrayList<Integer> shotSequenceRow3 = new ArrayList<Integer>();
    protected ArrayList<Integer> shotSequenceRow4 = new ArrayList<Integer>();
    protected ArrayList<Integer> shotSequenceRow5 = new ArrayList<Integer>();
    protected ArrayList<Integer> shotSequenceRow6 = new ArrayList<Integer>();
    protected ArrayList<Integer> shotSequenceRow7 = new ArrayList<Integer>();
    protected ArrayList<Integer> shotSequenceRow8 = new ArrayList<Integer>();
    protected boolean show = false;
    private int time = 25;int maxTime = 60,Cooldown=50;
    public Map(){
        thread = new Thread(this);
        thread.start(); 
        createXObstacle();
        setObstacles();
        setRow1();
        setRow2();
        setRow3();
        setRow4();
        setRow5();
        setRow6();
        setRow7();
        setRow8();
    }
    @Override
    public void run(){
        while(true){
            try{
                calShow();
                if(operateObstacles(1)&&Game.play && Game.endGame==false ){
                    runObstacles();
                    nextObstacles();
                    //System.out.println(time);
                    time+=1;}
                Thread.sleep(Cooldown);
            }catch(Exception e){
                //e.printStackTrace();
            }
        }
    }
    private void calShow(){
        if (operateObstacles()&&show==false)show = true;
        else if (operateObstacles()==false && show){
            show = false;
            dontShowObstacles();
        }
    }
    private void nextObstacles(){
        if(time >=maxTime ){
            time = 0;
            if(shotSequenceRow1.get(0)==1){
                //System.out.println("shoot"+shotSequenceRow1.get(0));
                int j = NoPointShot[0];
                xObstacle[0][j].setShooting();
                NoPointShot[0]=(j+1)%6;
                shotSequenceRow1.remove(0);
                shotSequenceRow1.add(1);
            }
            else{
                //System.out.println("don't shoot"+shotSequenceRow1.get(0));
                shotSequenceRow1.remove(0);
                shotSequenceRow1.add(0);
            }
            //System.out.println(numMap+"row 1 "+shotSequenceRow1);
            if(shotSequenceRow2.get(0)==1){
                int j = NoPointShot[1];
                xObstacle[1][j].setShooting();
                NoPointShot[1]=(j+1)%6;
                shotSequenceRow2.remove(0);
                shotSequenceRow2.add(1);
            }
            else{
                shotSequenceRow2.remove(0);
                shotSequenceRow2.add(0);
            }
            //System.out.println(numMap+"row 2 "+shotSequenceRow2);
            if(shotSequenceRow3.get(0)==1){
                int j = NoPointShot[2];
                xObstacle[2][j].setShooting();
                NoPointShot[2]=(j+1)%6;
                shotSequenceRow3.remove(0);
                shotSequenceRow3.add(1);
            }
            else{
                shotSequenceRow3.remove(0);
                shotSequenceRow3.add(0);
            }
            //System.out.println(numMap+"row 3 "+shotSequenceRow3);
            if(shotSequenceRow4.get(0)==1){
                int j = NoPointShot[3];
                xObstacle[3][j].setShooting();
                NoPointShot[3]=(j+1)%6;
                shotSequenceRow4.remove(0);
                shotSequenceRow4.add(1);
            }
            else{
                shotSequenceRow4.remove(0);
                shotSequenceRow4.add(0);
            }
            //System.out.println(numMap+"row 4 "+shotSequenceRow4);
            if(shotSequenceRow5.get(0)==1){
                int j = NoPointShot[4];
                xObstacle[4][j].setShooting();
                NoPointShot[4]=(j+1)%6;
                shotSequenceRow5.remove(0);
                shotSequenceRow5.add(1);
            }
            else{
                shotSequenceRow5.remove(0);
                shotSequenceRow5.add(0);
            }
            //System.out.println(numMap+"row 5 "+shotSequenceRow5);
            if(shotSequenceRow6.get(0)==1){
                int j = NoPointShot[5];
                xObstacle[5][j].setShooting();
                NoPointShot[5]=(j+1)%6;
                shotSequenceRow6.remove(0);
                shotSequenceRow6.add(1);
            }
            else{
                shotSequenceRow6.remove(0);
                shotSequenceRow6.add(0);
            }
            //System.out.println(numMap+"row 6 "+shotSequenceRow6);
            if(shotSequenceRow7.get(0)==1){
                int j = NoPointShot[6];
                xObstacle[6][j].setShooting();
                NoPointShot[6]=(j+1)%6;
                shotSequenceRow7.remove(0);
                shotSequenceRow7.add(1);
            }
            else{
                shotSequenceRow7.remove(0);
                shotSequenceRow7.add(0);
            }
            //System.out.println(numMap+"row 7 "+shotSequenceRow7);
            if(shotSequenceRow8.get(0)==1){
                int j = NoPointShot[7];
                xObstacle[7][j].setShooting();
                NoPointShot[7]=(j+1)%6;
                shotSequenceRow8.remove(0);
                shotSequenceRow8.add(1);
            }
            else{
                shotSequenceRow8.remove(0);
                shotSequenceRow8.add(0);
            }
            //System.out.println(numMap+"row 8 "+shotSequenceRow8);
        }
                    
    }
    private void runObstacles(){
        for(int i = 0; i < 8;i++){
                    for(int j = 0; j < 6;j++){
                        if(xObstacle[i][j].getShooting()){
                            xObstacle[i][j].move();
                            if(operateObstacles())xObstacle[i][j].showArrow();
                            //System.out.println("1");
                            
                            //System.out.println("2");
                        }
                        if(xObstacle[i][j].isHitShot()&&operateObstacles()){
                            //System.out.println("3");
                             xObstacle[i][j].hitShot();
                             //System.out.println("4");
                        }

                        if(xObstacle[i][j].isEndOfShooting()){
                            //System.out.println("5");
                            xObstacle[i][j].endOfShooting();
                            //System.out.println("6");
                        }      
                    }
                }
    }
    protected abstract void createXObstacle();
    protected abstract void setObstacles();
    protected abstract void setRow1();
    protected abstract void setRow2();
    protected abstract void setRow3();
    protected abstract void setRow4();
    protected abstract void setRow5();
    protected abstract void setRow6();
    protected abstract void setRow7();
    protected abstract void setRow8();
    public void  setDefaultMap(){
        time = 25;
        maxTime =65;
        Cooldown = 30;
        for(int i = 0; i < 8;i++)
            for(int j = 0; j < 6;j++)
                xObstacle[i][j].setDefaultXObstacle();
        setObstacles();
    }
    public void increasingDifficulty(){
        if(maxTime>50)maxTime-=7;
        else if(maxTime>30) maxTime-=3;
        if(maxTime>25)Cooldown-=4;
        else if(maxTime<15) Cooldown-=2;
        for(int i = 0; i < 8&&Cooldown>24;i++)
            for(int j = 0; j < 6;j++)
                xObstacle[i][j].addSpeed();
    }
    public void dontShowObstacles(){
        for(int i = 0; i < 8;i++)
                    for(int j = 0; j < 6;j++)
                        xObstacle[i][j].dontShowArrow();
    }
    
    private boolean operateObstacles(){
        return ((STAGE.stage)%10)==numMap%10;
    }
    private boolean operateObstacles(int i){
        return ((STAGE.stage)%10)==numMap%10||((STAGE.stage+1)%10)==(numMap)%10;
    }
    public void setMap(){
        STAGE.Background.setIcon(new ImageIcon(getClass().getResource("/images/background/Map/map"+numMap+".png")));
    }
}
