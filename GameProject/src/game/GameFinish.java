package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.io.IOException;

/**
 * The GameFinish class implements collisionlistener and show ending page when
 * player collides with the portal
 *
 * @author M0MAC
 */
class GameFinish implements CollisionListener {

    private Player player;
    private ShadeGame game;

    public GameFinish(ShadeGame game, Player player) {
        this.game = game;
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == player) {
            //destory player
            player.destroy();
            //print statement to console
            System.out.println("Great Job, you've completed the game :D");

            //write message to the .txt file
            try {
                game.getGameLog().writeToFile("Great Job, You've Completed the Game :D");
            } catch (IOException ex) {
                System.out.println(ex);
            }

            game.gameComplete();
        }
    }

}
