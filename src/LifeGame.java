import javax.swing.JFrame;  


  
    
/** 
 * 生命游戏 
 *  
 */  
  
public class LifeGame extends JFrame{  
  
      
  LifeGame(){  
        this.setSize(430,480);  
        this.setTitle("生命游戏");  
        this.add(new WorldMap());  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
    }  
      
    public static void main(String[] args){  
        LifeGame game = new LifeGame();  
        game.setVisible(true);  
    }  
  
}
