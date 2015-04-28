package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.io.IOException;

/**
 * The CollectTreasure class increments int variable treasure in the player
 * class using a collisionlistener
 *
 * @author M0MAC
 */
public class CollectTreasure implements CollisionListener {

    private ShadeGame game;

    public CollectTreasure(ShadeGame game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        //only reacts when the other body is the player
        if (e.getOtherBody() == game.getWorld().getPlayer()) {
            //destroy treasure
            e.getReceivingBody().destroy();

            //calls method from player that increments treasure by one
            game.getWorld().getPlayer().plusTreasure();
            //play soundclip
            game.getSound().getCollectSound().play();

            //writes message to .txt file
            try {
                game.getGameLog().writeToFile("You Have Collected: " + 
                        game.getWorld().getPlayer().getTreasureAmount() + 
                        "/3 Treasure Chests");
            } catch (IOException ex) {
                System.out.println(ex);
            }

        }
    }

}
