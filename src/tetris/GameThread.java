
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;


public class GameThread extends Thread
{
    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level =1;
    private int scorePerLevel=3;
    private int pause=1000;
    private int speedPerLevel=100;
    
    public GameThread(GameArea ga,GameForm gf)
    {
        this.ga=ga;
        this.gf=gf;
        
        gf.updateScore(score);
        gf.updateLevel(level);
    }

   
    
    @Override
    public void run()
    {
        //ga.moveBlockDown();
        while(true)
        {
        ga.spawnBlock();
        while (ga.moveBlockDown()==true)
        {
        
        
        try {
            
            
            Thread.sleep(pause);
        } catch (InterruptedException ex) {
           // Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
           return;
        }
        }
        if(ga.isBlockOutOfBound())
        {
            //System.out.println("Game Over ");
            Tetris.gameOver(score);
            break;
        }
        
        ga.moveBlockToBackground();
        score+=ga.clearLines();
        gf.updateScore(score);
        
        int lvl=score/scorePerLevel+1;
        if(lvl>level)
        {
            level=lvl;
            gf.updateLevel(level);
            pause-= speedPerLevel;
            
        }
        
        }
    }
}
