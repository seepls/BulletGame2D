import java.awt.*;
public class Text{

   private double x ;
   private double y ;
   private long time ;
   private String s ;
   
   private long start ;
   
   //CONSTRUCTOR 
   public Text(double x , double y ,long time ,String s ){
   this. x = x ;
   this.y = y ;
   this.time = time ;
   this.s = s ;
   start = System.nanoTime();
   
   }
   
   public void update(){
   long elapsed = (System.nanoTime() - start )/1000000;
   
   if (elapsed >time ){
   return   true ;
   }return false ;
   
   }
   
   public void draw(Graphics2D g){
   g.setFont(new Font("Century Gothic", Font.PLAIN, 12));
   g.setColor(Color.WHITE);
   g.drawString(s ,(int ) x ,(int) y );
   
   
   }
   
}
