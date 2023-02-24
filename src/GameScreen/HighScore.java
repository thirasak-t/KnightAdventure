
package GameScreen;


import java.io.*;

public class HighScore {
    private int highScore;String s;
    public HighScore(){
        try{
            File file = new File("C:\\Users\\ACER Nitro5\\Documents\\KnightAdventure");
            if (!file.exists())file.mkdir() ;
            FileReader r = new FileReader("C:\\Users\\ACER Nitro5\\Documents\\KnightAdventure\\HighScore.txt");
            int data,i=1;
            highScore = 0;
            while((data = r.read())!=-1){
               highScore = highScore*i+(data-48);
               if(i==1)i*=10;
            }
            r.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void setHighScore(int n) {
        try{
            FileWriter w = new FileWriter("C:\\Users\\ACER Nitro5\\Documents\\KnightAdventure\\HighScore.txt");
            w.write(String.valueOf(n));
            w.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public int getHighScore(){return highScore;}
}
