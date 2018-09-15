import java.awt.*; // for the graphics 
public class Player{
      //FEILDS
      private int x;
      private int y ;
      private int r ; // radius
      
      private int dx;
      private int dy ;
      private int speed;
      private boolean left;
      private boolean right;
      private boolean up;
      private boolean down;
      private int lives;
      private Color color1;
      private Color color2;
      
      //CONSTRUCTOR
      public player{
            x = GamePanel.WIDTH/2; //thats why we made WIDTH and HEIGHT as public so that public functions like the one now can use them 
            y =GamePanel.HEIGHT/2 ;
            r =5 ;
            dx = 0 ; 
            dy =0;
            speed = 5 ;
            lives = 3 ;
            color1 =Color.WHITE ;
            color2 = Color.RED; // the color when we are hit 
           }
      //FUNCTIONS 
      public void update(){
            if(left){
                  dx = -speed ;
            }
            if(right){
                  dx= +speed;
            }
            if(up){
                  dy = -speed;
            }
            if(down){
                  dy= +speed;
            }
            x+=dx;
            y+=dy;
            // now check balance
            if(x<r)x =r ;
            if(y<r)y=r;
            if(x > GamePanel.WIDTH -r) x= GamePanel.WIDTH -r ;
            if(y> GamePanel.HEIGHT -r) y = GamePanel.HEIGHT -r ;
            dx =0 ;
            dy = 0;
            
            
            
      }
      public void draw (Graphics2D g){
            g.setColr(color1);
            g.fillOval(x-r,y-r,2*r,2*r);
            g.setStroke(new BasicStroke(3));
            
                
            
            
      }
}
