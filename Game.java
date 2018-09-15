import javax.swing.JFrame ;
public class Game{
public static void main(String args[]){
Jframe window = new Jframe("shooter"); // setting title 
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the cross at the  top
window.pack();
window.setVisible(true);
window.setContentPane(new GamePanel());

}
}
