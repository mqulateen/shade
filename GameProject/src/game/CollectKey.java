package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.io.IOException;

/**
 * The CollectKey class implements collisionlistener used to unlock the locked
 * door in the world
 * @author M0MAC
 */

public class CollectKey implements CollisionListener {

    private Door door;
    private ShadeGame game;
    
    public CollectKey(ShadeGame game, Door door) {
        this.door = door;
        this.game = game;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        //only responds when the player collides with the Key 
        if (e.getOtherBody() == game.getWorld().getPlayer()) {
            //destroy key
            e.getReceivingBody().destroy();
            
            //write message to .txt file
            try {
                game.getGameLog().writeToFile("You Have Collected the Key." + " "
                                                     + "The Door is Unlocked!");
            } catch (IOException ex) {
                System.out.println(ex);
            }
            
            //give player the key
            game.getWorld().getPlayer().giveKey();
            //unlock the door
            door.unlockDoor();
            //play soundclip
            game.getSound().getDoorSound().play();
        }
    }
}


