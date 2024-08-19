
package tetrisblocks;

import tetris.TetrisBlock;


public class IShape  extends TetrisBlock
{
    public IShape()
    {
        super(new int[][]{{1,1,1,1}});
        
    }
    
    @Override
    public void rotate()
    {
        super.rotate();
        
        if(this.getWidth()==1)
        {
            this.setx((this.getx()+1));
            this.sety(this.gety()-1);
        }
        else
        {
            this.setx((this.getx()-1));
            this.sety(this.gety()+1);
        }
    }
    
}
