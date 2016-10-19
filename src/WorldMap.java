import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.JPanel;  
import javax.swing.Timer;  
  
/** 
 *  
  */  
  
public class WorldMap extends JPanel {  
  
  
    private final int width = 20;  
  
    private final int height = 20;  
  
    private final int CELL_DIE='0';
    private final int CELL_ALIVE='1';
    private Timer timer;
    private final int DELAY_TIME = 1200; 
    /*定义初始图案
     * 
     */
    private final char [][]world={
    		{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    		{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    		{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
        	{'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'1','1','1','1','0','1','1','1','1','0','0','1','0','0','1','1','1','1','0','0'},
        	{'0','0','0','1','0','1','0','0','1','0','1','1','0','0','1','0','0','0','0','0'},
        	{'0','0','0','1','0','1','0','0','1','0','0','1','0','0','1','0','0','0','0','0'},
            {'0','0','0','1','0','1','0','0','1','0','0','1','0','0','1','0','0','0','0','0'},
            {'1','1','1','1','0','1','0','0','1','0','0','1','0','0','1','1','1','1','0','0'},
            {'1','0','0','0','0','1','0','0','1','0','0','1','0','0','1','0','0','1','0','0'},
            {'1','0','0','0','0','1','0','0','1','0','0','1','0','0','1','0','0','1','0','0'},
            {'1','0','0','0','0','1','0','0','1','0','0','1','0','0','1','0','0','1','0','0'},
            {'1','1','1','1','0','1','1','1','1','0','1','1','1','0','1','1','1','1','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
    };
    /** 
     * 开始动画 
     *  
         */  
    public WorldMap() {  
        timer = new Timer(DELAY_TIME, new ActionListener() {  
        	  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	ChangeStatus();
                repaint();  
            }  
        });  
        // 开启计时器  
        timer.start(); 
    }  
    /*画图
     * 
     */
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        for (int i = 0; i < width; i++) {  
            for (int j = 0; j < height; j++) {  
                if (world[i][j] == CELL_ALIVE) {  
                    g.fillRect( j * width, i * height, width, height);  
                   
                } else {  
                	 g.drawRect( j * width, i * height, width, height); 
                }  
            }  
        }  
    } 
    /*获取细胞周围的活细胞数
     * 记录细胞的下一状态
     * 
     */
    protected void ChangeStatus()
    {

    	for(int r=0;r<width;r++)
    		for(int c=0;c<height;c++)
    		{
    			switch(GetNextStatus(r,c))
    			{
    			case 0:
    			case 1:
    			case 4:
    			case 5:
    			case 6:
    			case 7:
    			case 8:world[r][c]=CELL_DIE;
    			break;
    			case 3:world[r][c]=CELL_ALIVE;
    			break;
    			case 2:world[r][c]=world[r][c];
    			break;
    			}
    		}
    }
    
    
    
    protected int GetNextStatus(int row,int col)
    {
    	int r=0,c=0;
    	int cnt=0;
    	for(r=row-1;r<=row+1;r++)
    		for(c=col-1;c<=col+1;c++)
    		{
    			if (r < 0 || r >=width || c < 0  
                        || c >=height) {  
                    continue;  
                }  
    			
    			if(world[r][c]==CELL_ALIVE)
    				cnt++;
    		}
        if (world[row][col]==CELL_ALIVE) cnt--;
		return cnt;
    }
    


  

    
   
    
}  
