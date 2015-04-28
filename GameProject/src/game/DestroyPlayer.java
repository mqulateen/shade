package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.io.IOException;
import org.jbox2d.common.Vec2;

/**
 * The DestoryPlayer class implements a collisionlistener used to destroy player
 *
 * @author M0MAC
 */
public class DestroyPlayer implements CollisionListener {

    private ShadeGame game;

    public DestroyPlayer(ShadeGame game) {
        this.game = game;
    }

    //collision method
    @Override
    public void collide(CollisionEvent e) {
        //check if contacting body is player before reacting
        if (e.getOtherBody() == game.getWorld().getPlayer()) {
            //calls method from player that decrements heart by one
            game.getWorld().getPlayer().takeHealth();
            
            //writes message to .txt file
            try {
                game.getGameLog().writeToFile("You Died and have: " + game.getWorld().getPlayer().getLives() + "/3 Lives Left");
            } catch (IOException ex) {
                System.out.println(ex);
            }


            /*checks weather the player has lives more than zero then sets the
             players position*/
            if (game.getWorld().getPlayer().getLives() > 0) {
                game.getWorld().getPlayer().setPosition(new Vec2(-5, -8));
            } else {
                
                try {
                    game.getGameLog().writeToFile("You've Died too many times. Game Over!");
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
            }
        }
    }
}
