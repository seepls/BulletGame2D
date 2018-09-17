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
      
      private boolean firing ;
      private long firingTimer ;
      private long firingDelay ;
      
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
            
            firing = false ;
            firingTimer = System.nanoTime() ;
            firingDelay = 200 ;
            
            
            
           }
      //FUNCTIONS 
      public int getx(){ return x ; }
      public int gety(){ return y;}
      public int getr(){ return r ;}
      
      public int getLives(){return lives;}
      
      public void setLeft(boolean b){left = b ;}
      public void setRight(boolean b){right = b ;}
      public void setDown(boolean b){down = b ;}
      public void setUp(boolean b){up = b ;}
      
      public void setFiring (boolean b){firing = b ;}
      
      
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
            
            
            if(firing){
                  long elapsed = (System.nanoTime() -firingTimer )/1000000;
                  if(elapsed >firingDelay){
                         GamePanel.bullets.add(new Bullet(270 , x, y ));
                         firingTimer = System.nanoTime();
                        
                  }
                  
            }
            
            
            
      }
      public void draw (Graphics2D g){
            g.setColr(color1);
            g.fillOval(x-r,y-r,2*r,2*r);
            g.setStroke(new BasicStroke(3));
            g.setColor(color1.darker());
            g.drawOval(x-r,y-r,2*r,2*r); //boundary 
            g.setStroke(new BasicStroke(1));
            
      }
}
