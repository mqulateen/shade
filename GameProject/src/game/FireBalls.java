package game;

import city.cs.engine.*;

/**
 * FireBalls used in worldThree as enemies. Shooting (collision) works but 
 * comment for the submission
 * @author M0MAC
 */

public class FireBalls extends DynamicBody{ //implements CollisionListener {

    private ShadeWorlds world;
    //private Bullet bullet;
    
    //create a new image
    private BodyImage img = new BodyImage("data/L3Ball.gif", 5);
    //create a new shape
    private static final Shape shape = new CircleShape(2);

    public FireBalls(ShadeWorlds world) {
        super(world);
        this.world = world;
        //set the image on the Body
        this.setImage(img);
        //set new fixture to the body    
        SolidFixture balls = new SolidFixture(this, shape);
        //sets restitution
        balls.setRestitution(1.0f);
        //prevents spinning
        this.setFixedRotation(true);

    }

    /*
     *Destorys bullet and fireball when they collide
     public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Bullet) {
            e.getReceivingBody().destroy();
            this.destroy();
            System.out.println("You've killed an enemy");
        }
     }
    */
}
