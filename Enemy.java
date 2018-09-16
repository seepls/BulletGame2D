import java.awt.*;
public class Enemy{
   //FEILDS
   private double x;
   private double y;
   private int r ;
   
   private double dx;
   private double dy;
   private double rad;
   private double speed ;
   
   private int health ;
   private int type ;
   private int rank ;
   
   private Color color1;
   
   private boolean ready ;
   private boolean dead;
   
   
   //CONSTRUCTOR 
   public Enemy(int type , int rank ){
      this.type= type ;
      this.rank = rank ;
      if(type == 1 ){
         color1 = Color.BLUE ;
         if(rank == 1){
            speed = 2 ;
            r = 5 ;
            health = 1 ;   
         }
      }
      x = Math.random()*GamePanel.WIDTH /2  + GamePanel.WIDTH / 4 ;
      y = -r ;
      
      double angle = Math.random()*140 + 20 ;
      rad = Math.toRadians(angle);
      dx = Math.cos(rad)*speed;
      dy = Math.sin(rad)*speed;
      ready = false ;
      dead = false ;
   }
   
   //FUNCTIONS
   public double getx(){return x ;}
   public double gety(){return y ;}  
   public double getr(){return r ;} 
   
   
}
