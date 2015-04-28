package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;

/**
 * The PlayerTracker class centres the view on the player
 * @author M0MAC
 */

public class PlayerTracker implements StepListener {
   
    private UserView view;
    private ShadeGame game;

    public PlayerTracker(UserView view, ShadeGame game) {
        this.view = view;
        this.game = game;
    }
    
    //unused
    public void preStep(StepEvent e){
    }

    //centre camera on player using players position
    public void postStep(StepEvent e){
        view.setCentre(new Vec2(game.getWorld().getPlayer().getPosition()));
    }

}
