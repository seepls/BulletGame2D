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
      
      //CONSTRUCTOR
      public player{
            x = GamePanel.WIDTH/2; //thats why we made WIDTH and HEIGHT as public so that public functions like the one now can use them 
            y =GamePanel.HEIGHT/2 ;
            r =5 ;
            dx = 0 ; 
            dy =0;
            speed = 5 ;
            lives = 3 ;
           }
      //FUNCTIONS 
      public void update(){
            
      }
      public void draw (Graphics2D g){
      }
}
