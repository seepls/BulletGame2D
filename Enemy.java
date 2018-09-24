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
      //default enemy 
      if(type == 1 ){
         color1 = Color.BLUE ;
         if(rank == 1){
            speed = 2 ;
            r = 5 ;
            health = 1 ;   
         }
         if(rank ==2){
            speed = 2 ;
            r = 10 ; 
            health = 2 ;
         }
         if(rank ==3){
            speed = 1.5 ;
            r =15;
            health = 3 ;
         }
         
         if(rank ==4 ){
            speed = 1.5 ;
            r =25;
            health = 4 ;
            
         }
      }
      //stronger and faster default
      if(type == 2 ){
         color1= Color.RED;
         if(rank == 1){
            speed = 3 ;
            r = 6 ;
            health = 2 ;
            
         }
      }
      
      //slow but hard to kill enemy 
      if(type==3){
         color1 = Color.GREEN ;
         if(rank == 1){
            speed =1.5;
            r =5 ;
            health = 5 ;
            
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
   
   public int getType(){return type;}
   public int getRank(){return rank ;}
   
   public boolean isDead(){
      return dead;
   }
   
   public void explode(double x , double y){
      if(rank >1){
         int amount = 0;
         if( type ==1){
            amount =3 ;
         }
         for(int i = 0 ; i <amount ; i++){
            Enemy e = new Enemy(getType(), getRank()-1);
            e.x = this.x ; e.y = this.y ;
            
            double angle = 0 ;
            if(!ready){
               angle = Math.Random() *140 + 20 ;
            }else {
               angle = Math.Random()*360 ;
            }
            e.rad = Math.toRadians(angle);
            
            GamePanel.enemies.add(e);
            
            
         }
      }
   }
   
   public void hit(){
      health--;
      if(health <= 0 ) {dead = true ;}
   }
   
   public void update(){
      x+= dx ;
      y+= dy ;
      if(!ready){
         if(x>r && x <GamePanel.WIDTH -r && y>r && y<GamePanel.HEIGHT -r ){
            ready = true ;
         }
      }
          
      if(x <r  && dx <0 )dx = -dx ;
      if(y <r && dy <0) dy= - dy ;
      if(x > GamePanel.WIDTH -r  && dx > 0) dx = -dx ;
      if(y > GamePanel.HEIGHT - r && dy > 0 ) dy = -dy ;
      
   }
   
   public void draw(Graphics2D g){
      g.setColor(color1);
      g.fillOval( (int)(x-r),(int)(y-r),@*r ,2*r );
      g.setStroke(new BasicStroke(3));
      g.setColor(color1.darker());
      g.drawOval( (int)(x-r),(int)(y-r),@*r ,2*r );
       g.setStroke(new BasicStroke(1));
   }
   
   
   
   
}
