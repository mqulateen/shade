package game;

import city.cs.engine.UserView;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 * The MyView class is used to display information on the foreground of the view
 * @author M0MAC
 */
public class MyView extends UserView {

    private ShadeGame game;
    
    //initalise images
    private static final ImageIcon threeLives = new ImageIcon("data/3lives.png");
    private static final ImageIcon twoLives = new ImageIcon("data/2lives.png");
    private static final ImageIcon oneLive = new ImageIcon("data/1live.png");
    private static final ImageIcon gameOver = new ImageIcon("data/gameover.png");

    public MyView(ShadeGame game, int w, int h) {
        super(game.getWorld(), w, h);
        this.game = game;

    }

    //override userview method paintforeground to display stuff on the foreground 
    @Override
    protected void paintForeground(Graphics2D g) {
        
        //calls a method from player and compares value to show an image 
        if (game.getWorld().getPlayer().getLives() == 3) {
            g.drawImage(threeLives.getImage(), 10, 0, this);
            
        } else if (game.getWorld().getPlayer().getLives() == 2) {
            g.drawImage(twoLives.getImage(), 10, 0, this);
            
        } else if (game.getWorld().getPlayer().getLives() == 1) {
            g.drawImage(oneLive.getImage(), 10, 0, this);
            
        } else if(game.getWorld().getPlayer().getLives() == 0){
            game.getWorld().setPaused(true);
        
            /*the game over image may cause the game to lag so I made a string 
            to replace it if it does lag. Just comment out the image below and 
            uncomment the string*/
            g.drawImage(gameOver.getImage(), 0, 0,this);
            //g.drawString("GAME OVER", 425, 155);
        
        }
        

          /*displays the amount of treasure the player has as a string on the 
          foreground*/
        g.drawString("Treasure Found: " + 
                game.getWorld().getPlayer().getTreasureAmount() + "/3", 10, 60);
        
    }

}

