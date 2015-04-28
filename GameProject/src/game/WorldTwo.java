package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Second world in the game, Extends the general world ShadeWorlds
 * @author M0MAC
 */

public class WorldTwo extends ShadeWorlds {

    private final Door door;
    private final MovingPlatform movingPlt;
    private static final Color platColour = new Color(255, 0, 0);
    private static final BodyImage tChest = new BodyImage("data/treasureChest.png", 10);
    private final L2Obstacle obstacle;

    public WorldTwo(ShadeGame game) {
        super();
        this.game = game;
        
        {
            Shape shape = new BoxShape(7, 0.5f);
            //starting ground
            Body beginningGround = new StaticBody(this, shape);
            beginningGround.setPosition(new Vec2(-7, -12));
            beginningGround.setFillColor(platColour);
            //ending ground
            Body endGround = new StaticBody(this, shape);
            endGround.setPosition(new Vec2(141, -12));
            endGround.setFillColor(platColour);
        }

        {
            Shape shape = new BoxShape(36, 0.5f);
            //leftWall
            Body leftWall = new StaticBody(this, shape);
            leftWall.setPosition(new Vec2(-13.5f, 24.5f));
            leftWall.setAngleDegrees(90);
            leftWall.setFillColor(platColour);
            //rightWall
            Body rightWall = new StaticBody(this, shape);
            rightWall.setPosition(new Vec2(147.5f, 24.5f));
            rightWall.setAngleDegrees(90);
            rightWall.setFillColor(platColour);
        }

        {   //ceiling
            Shape shape = new BoxShape(80, 0.5f);
            Body ceiling = new StaticBody(this, shape);
            ceiling.setPosition(new Vec2(67, 60));
            ceiling.setFillColor(platColour);
        }
////////////////////////////////////////////////////////////////////////////////

        {//platforms
            Shape shape = new BoxShape(10, 0.5f);
            //platform1
            Body plat1 = new StaticBody(this, shape);
            plat1.setPosition(new Vec2(23, -5));
            plat1.setFillColor(platColour);
            //platform2
            Body plat2 = new StaticBody(this, shape);
            plat2.setPosition(new Vec2(59.4f, -10));
            plat2.setFillColor(platColour);
            //platform4
            Body plat4 = new StaticBody(this, shape);
            plat4.setPosition(new Vec2(59.4f, 10));
            plat4.setFillColor(platColour);
            //platform5
            Body plat5 = new StaticBody(this, shape);
            plat5.setPosition(new Vec2(23, 15));
            plat5.setFillColor(platColour);
        }

        {   //moving platform w/steplistener
            movingPlt = new MovingPlatform(this);
            movingPlt.setPosition(new Vec2(80, 5));
            movingPlt.setFillColor(platColour);
            this.addStepListener(movingPlt);
        }

        {   //movingplt rightwall (platform3)
            Shape shape = new BoxShape(7.5f, 0.5f);
            Body movinPltWall = new StaticBody(this, shape);
            movinPltWall.setPosition(new Vec2(68.9f, 11));
            movinPltWall.setAngleDegrees(90);
            movinPltWall.setFillColor(platColour);
        }

        {   //platform6(treasure 1)
            Shape shape = new BoxShape(7, 0.5f);
            Body plat6 = new StaticBody(this, shape);
            plat6.setPosition(new Vec2(-4, 23));
            plat6.setFillColor(platColour);
        }

        {   //Platforms Sized (10, 0.5)
            Shape shape = new BoxShape(10, 0.5f);
            //platform4
            Body plat10 = new StaticBody(this, shape);
            plat10.setPosition(new Vec2(23, 32));
            plat10.setFillColor(platColour);
        }

        {   //platform9
            Shape shape = new BoxShape(7, 0.5f);
            Body plat9 = new StaticBody(this, shape);
            plat9.setPosition(new Vec2(50, 40));
            plat9.setFillColor(platColour);

            Body plat19 = new StaticBody(this, shape);
            plat19.setPosition(new Vec2(77, 45));
            plat19.setFillColor(platColour);
        }

        {   //Middle Walls
            Shape shape = new BoxShape(25, 0.5f);
            //bigWallRight
            Body bigWallRight = new StaticBody(this, shape);
            bigWallRight.setPosition(new Vec2(90, 15));
            bigWallRight.setAngleDegrees(90);
            bigWallRight.setFillColor(platColour);
            //bigWallLeft
            Body bigWallLeft = new StaticBody(this, shape);
            bigWallLeft.setPosition(new Vec2(120, 15));
            bigWallLeft.setAngleDegrees(90);
            bigWallLeft.setFillColor(platColour);
        }
        {
            Shape shape = new BoxShape(4, 0.5f);

            //two loops to create platforms on the same x axis
            for (int i = 35; i > -10; i = i - 20) {
                Body rightSteps = new StaticBody(this, shape);
                rightSteps.setPosition(new Vec2(94, i));
                rightSteps.setFillColor(platColour);
            }
            for (int i = 25; i > 0; i = i - 20) {
                Body leftSteps = new StaticBody(this, shape);
                leftSteps.setPosition(new Vec2(116, i));
                leftSteps.setFillColor(platColour);
            }
        }

        {   //three TreasureChests Around the World
            Shape shape = new BoxShape(2, 1.5f);
            //Treasure1
            Body treasure = new StaticBody(this, shape);
            treasure.setPosition(new Vec2(-6, 24.5f));
            treasure.setImage(tChest);
            treasure.addCollisionListener(new CollectTreasure(game));
            //Treasure2
            Body treasure1 = new StaticBody(this, shape);
            treasure1.setPosition(new Vec2(117, 26.5f));
            treasure1.setImage(tChest);
            treasure1.addCollisionListener(new CollectTreasure(game));
            //Treasure3
            Body treasure2 = new StaticBody(this, shape);
            treasure2.setPosition(new Vec2(67, 11.5f));
            treasure2.setImage(tChest);
            treasure2.addCollisionListener(new CollectTreasure(game));
        }

        {   //Obstacle double sided spikes
            obstacle = new L2Obstacle(this);
            obstacle.setPosition(new Vec2(105, -15));
            obstacle.addCollisionListener(new DestroyPlayer(game));
            this.addStepListener(obstacle);
        }

        {   //Door
            door = new Door(this, game);
            door.setPosition(new Vec2(143, -9));
            door.addCollisionListener(door);
        }

        {   //Key
            Shape shape = new PolygonShape(2.28f, 0.37f, -0.83f, -1.49f, -0.55f,
                    -0.27f, 1.81f, 1.43f);
            Body key = new DynamicBody(this, shape);
            key.setPosition(new Vec2(90, 29));
            key.setImage(new BodyImage("data/key.png", 3));
            key.addCollisionListener(new CollectKey(game, door));
        }

        {   //Ground
            Shape shape = new BoxShape(90, 0.3f);
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(70, -18));
            ground.setFillColor(platColour);
        }

    }

}

//a moving platform for world two
class MovingPlatform extends DynamicBody implements StepListener {

    //make the platform
    private static final Shape shape = new BoxShape(10, 0.5f);

    public MovingPlatform(ShadeWorlds world) {
        super(world);
        //sets fixture on platform
        SolidFixture fixture = new SolidFixture(this, shape, 100);
        //prevents rotation
        this.setFixedRotation(true);
    }

    @Override
    public void preStep(StepEvent e) {
        //check if Y-Axis of obstacle is more than 40 and sets LinVelocity
        if (this.getPosition().y > 40) {
            this.setLinearVelocity(new Vec2(0, 30));
            //check if Y-Axis of obstacle is less than -10 and sets LinVelocity
        } else if (this.getPosition().y < -10) {
            this.setLinearVelocity(new Vec2(0, 25));
        }
    }

    @Override
    //not needed
    public void postStep(StepEvent e) {
    }
}

//inner class obstacle for world two
class L2Obstacle extends DynamicBody implements StepListener {

    //declare and initalise obstacle dimensions
    private static final float topWidth = 5;
    private static final float topHeight = 2;
    private static final float bottomWidth = 5;
    private static final float bottomHeight = 2;

    //image
    private BodyImage img = new BodyImage("data/twoSpikes.png", 10);

    //join the shapes together
    private Shape topSpike = new BoxShape(topWidth, topHeight,
            new Vec2(0, -bottomHeight));
    private Shape bottomSpike = new BoxShape(bottomWidth, bottomHeight,
            new Vec2(0, topHeight));

    public L2Obstacle(ShadeWorlds world) {
        super(world);
        //set image to the body
        this.setImage(img);
        //create fixture for top spike and set density     
        SolidFixture top = new SolidFixture(this, topSpike, 50);
        //set restitution on bottonSpike
        top.setRestitution(1.0f);
        //create fixture for bottom spike and set density
        SolidFixture bottom = new SolidFixture(this, bottomSpike, 50);
        //set restitution on bottonSpike
        bottom.setRestitution(1.0f);
        //prevents the obstacle from spinning when it collides with something
        this.setFixedRotation(true);
    }

    @Override
    public void preStep(StepEvent e) {
        //check if Y-Axis of ostacle is more than 40 and sets LinVelocity
        if (this.getPosition().y > 40) {
            this.setLinearVelocity(new Vec2(0, 20));
            //check if Y-Axis of obstacle is less than -10 and sets LinVelocity
        } else if (this.getPosition().y < -10) {
            this.setLinearVelocity(new Vec2(0, 30));
        }
    }

    @Override
    //has to be overriden but not needed
    public void postStep(StepEvent e) {
    }
}
