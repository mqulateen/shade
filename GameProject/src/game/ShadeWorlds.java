package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * The ShadeWorlds class is a general classes that is extended by all worlds in
 * the game
 * @author M0MAC
 */

public class ShadeWorlds extends World {

    //protected allows access in sub classes
    protected ShadeGame game;
    protected Player player;
    
    public ShadeWorlds(){
        this.game = game;
        
        //make and set position of player
        player = new Player(game, this);
        player.setPosition(new Vec2(-5, -8));
        
    }
    
    //player getter
    public Player getPlayer() {
        return player;
    }
}