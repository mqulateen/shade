package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * The Bullet class implements collisionlistner, it creates bullets used in the 
 * third world to destroy enemies and them selves upon collision.
 * @author M0MAC
 */
public class Bullet extends DynamicBody implements CollisionListener {

    private ShadeGame game;
    private static final Shape shape = new CircleShape(0.2f);

    public Bullet(ShadeGame game) {
        super(game.getWorld(), shape);
        this.game = game;
        setFillColor(Color.RED); //
        this.addCollisionListener(this); //listener for collision
    }

    public void collide(CollisionEvent e) {
        this.destroy(); //destroys bullet
    }

}
