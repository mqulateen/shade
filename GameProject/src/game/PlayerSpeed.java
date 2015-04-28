package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * The PlayerSpeed class moves the player by setting velocity
 * @author M0MAC
 */

public class PlayerSpeed implements StepListener {

    private ShadeGame game;
    private float speed;
    
    PlayerSpeed(ShadeGame game, float speed) {
        this.game = game;
        this.speed = speed;
    }
    
    /* method used to set linear velocity of player at a speed specified in 
       the keyhandler class */
    @Override
    public void preStep(StepEvent e) {
        Vec2 v = game.getWorld().getPlayer().getLinearVelocity();
        game.getWorld().getPlayer().setLinearVelocity(new Vec2(speed, v.y));
    }

    //unused
    @Override
    public void postStep(StepEvent e) {
    }
}
