package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * First world in the game, Extends the general world ShadeWorlds
 * @author M0MAC
 */

public class WorldOne extends ShadeWorlds {

    private Obstacle obstacle;
    private final Door door;
    private static final Color platColour = new Color(255,255,255);
    private static final BodyImage tChest = new BodyImage("data/treasureChest.png", 10);
    private static final BodyImage floorSpike = new BodyImage("data/floorSpikes.png", 10);

    public WorldOne(ShadeGame game) {
        super();
        this.game=game;
        
        {
            Shape shape = new BoxShape(7, 0.5f);
            //starting ground
            Body beginningGround = new StaticBody(this, shape);
            beginningGround.setPosition(new Vec2(-7, -11.5f));
            beginningGround.setFillColor(platColour);
            //ending ground
            Body endGround = new StaticBody(this, shape);
            endGround.setPosition(new Vec2(227, -11.5f));
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
            rightWall.setPosition(new Vec2(233.5f, 24.5f));
            rightWall.setAngleDegrees(90);
            rightWall.setFillColor(platColour);
        }

        {//ceiling
            Shape shape = new BoxShape(124, 0.5f);
            Body ceiling = new StaticBody(this, shape);
            ceiling.setPosition(new Vec2(110, 60));
            ceiling.setFillColor(platColour);
        }
////////////////////////////////////////////////////////////////////////////////
        
        {   //platforms sized (5, 0.5)
            Shape shape = new BoxShape(5, 0.5f);
            //platform1
            Body plat1 = new StaticBody(this, shape);
            plat1.setPosition(new Vec2(17, -10));
            plat1.setFillColor(platColour);
            //platform2
            Body plat2 = new StaticBody(this, shape);
            plat2.setPosition(new Vec2(34, -14.5f));
            plat2.setFillColor(platColour);
            //platform3
            Body plat3 = new StaticBody(this, shape);
            plat3.setPosition(new Vec2(54, -10));
            plat3.setFillColor(platColour);
        }

        {   //Platforms Sized (10, 0.5)
            Shape shape = new BoxShape(10, 0.5f);
            //platform4
            Body plat4 = new StaticBody(this, shape);
            plat4.setPosition(new Vec2(75, -4));
            plat4.setFillColor(platColour);
            //platform6
            Body plat6 = new StaticBody(this, shape);
            plat6.setPosition(new Vec2(70, 10));
            plat6.setFillColor(platColour);
        }

        {   //platform5(with 2 spikes)
            Shape shape = new BoxShape(14, 0.5f);
            Body plat5 = new StaticBody(this, shape);
            plat5.setPosition(new Vec2(110, 4));
            plat5.setFillColor(platColour);
            
            Body plat19 = new StaticBody(this, shape);
            plat19.setPosition(new Vec2(141.5f, 39.5f));
            plat19.setFillColor(platColour);
            plat19.setAngleDegrees(90);
        }

        {   //Platforms Sized (3, 0.5) 
            Shape shape = new BoxShape(3, 0.5f);
            //platform7
            Body plat7 = new StaticBody(this, shape);
            plat7.setPosition(new Vec2(35, 10));
            plat7.setFillColor(platColour);
            //platform8
            Body plat8 = new StaticBody(this, shape);
            plat8.setPosition(new Vec2(15, 17));
            plat8.setFillColor(platColour);
            //platform10
            Body plat10 = new StaticBody(this, shape);
            plat10.setPosition(new Vec2(17, 32));
            plat10.setFillColor(platColour);
            //platform11
            Body plat11 = new StaticBody(this, shape);
            plat11.setPosition(new Vec2(32, 40));
            plat11.setFillColor(platColour);
        }

        {   //platform9(treasure 1)
            Shape shape = new BoxShape(7, 0.5f);
            Body plat9 = new StaticBody(this, shape);
            plat9.setPosition(new Vec2(-4, 25));
            plat9.setFillColor(platColour);
        }
        {   //platform12(key platform)
            Shape shape = new BoxShape(15, 0.5f);
            Body plat12 = new StaticBody(this, shape);
            plat12.setPosition(new Vec2(1, 47));
            plat12.setFillColor(platColour);
        }
        {   //platform13 (Right of Middle Platform)
            Shape shape = new BoxShape(10, 0.5f);
            Body plat13 = new StaticBody(this, shape);
            plat13.setPosition(new Vec2(188, 9));
            plat13.setFillColor(platColour);
        }
        {   //Platforms Sized (8, 0.5)
            Shape shape = new BoxShape(8, 0.5f);
            //platform14
            Body plat14 = new StaticBody(this, shape);
            plat14.setPosition(new Vec2(155, 0));
            plat14.setFillColor(platColour);
            //platform15(treasure 3)
            Body plat15 = new StaticBody(this, shape);
            plat15.setPosition(new Vec2(184, -7));
            plat15.setFillColor(platColour);
            //platform16
            Body plat16 = new StaticBody(this, shape);
            plat16.setPosition(new Vec2(218, 18));
            plat16.setFillColor(platColour);
            //platform17
            Body plat17 = new StaticBody(this, shape);
            plat17.setPosition(new Vec2(190, 26));
            plat17.setFillColor(platColour);
            //platform18(treasure 2)
            Body plat18 = new StaticBody(this, shape);
            plat18.setPosition(new Vec2(150, 26));
            plat18.setFillColor(platColour);
        }
        {   //door
            door = new Door(this, game);
            door.setPosition(new Vec2(229, -8));
            door.addCollisionListener(door);
        }

        {   //key
            Shape shape = new PolygonShape(2.28f, 0.37f, -0.83f, -1.49f, -0.55f,
                                           -0.27f, 1.81f, 1.43f);
            Body key = new DynamicBody(this, shape);
            key.setPosition(new Vec2(-2, 49));
            key.setImage(new BodyImage("data/key.png", 3));
            key.addCollisionListener(new CollectKey(game, door));
        }

        {//first chainSpikes
            obstacle = new Obstacle(this);
            obstacle.setPosition(new Vec2(105, 35));
            obstacle.addCollisionListener(new DestroyPlayer(game));
            this.addStepListener(obstacle);
        }{//second chainSpikes
            obstacle = new Obstacle(this);
            obstacle.setPosition(new Vec2(115, 35));
            obstacle.addCollisionListener(new DestroyPlayer(game));
            this.addStepListener(obstacle);
        }
        
        {   //walls on either side of obstacles   
            Shape shape = new BoxShape(7, 0.5f);
            //ob1Left
            Body ob1Left = new StaticBody(this, shape);
            ob1Left.setPosition(new Vec2(104.5f, 24));
            ob1Left.setAngleDegrees(90);
            ob1Left.setFillColor(platColour);
            //ob1Right
            Body ob1Right = new StaticBody(this, shape);
            ob1Right.setPosition(new Vec2(105.8f, 24));
            ob1Right.setAngleDegrees(90);
            ob1Right.setFillColor(platColour);
            //ob2Left
            Body ob2Left = new StaticBody(this, shape);
            ob2Left.setPosition(new Vec2(114.5f, 24));
            ob2Left.setAngleDegrees(90);
            ob2Left.setFillColor(platColour);
            //ob2Right
            Body ob2Right = new StaticBody(this, shape);
            ob2Right.setPosition(new Vec2(115.8f, 24));
            ob2Right.setAngleDegrees(90);
            ob2Right.setFillColor(platColour);
        }
            
        {   //ground
            Shape shape = new BoxShape(50, 0.3f);
            
            for (int i = 18; i <= 158; i=i+50) {
                Body ground = new StaticBody(this, shape);
                ground.setPosition(new Vec2(i*2-10, -18));
                ground.addCollisionListener(new DestroyPlayer(game));
                ground.setImage(new BodyImage("data/ground.gif", 5));
            }
        }

        {   //floor spikes
            Shape shape = new PolygonShape(-1.16f, 0.76f, -1.5f, -0.34f, 1.5f,
                    -0.32f, 1.1f, 0.78f);
            //spike1
            Body floorSpikes = new StaticBody(this, shape);
            floorSpikes.setPosition(new Vec2(16, -9.3f));
            floorSpikes.addCollisionListener(new DestroyPlayer(game));
            floorSpikes.setImage(floorSpike);

            //spike2
            Body floorSpikes1 = new StaticBody(this, shape);
            floorSpikes1.setPosition(new Vec2(3, 47.5f));
            floorSpikes1.addCollisionListener(new DestroyPlayer(game));
            floorSpikes1.setImage(floorSpike);

            //spike3
            Body floorSpikes2 = new StaticBody(this, shape);
            floorSpikes2.setPosition(new Vec2(153, 26.8f));
            floorSpikes2.addCollisionListener(new DestroyPlayer(game));
            floorSpikes2.setImage(floorSpike);

            //spike4
            Body floorSpikes3 = new StaticBody(this, shape);
            floorSpikes3.setPosition(new Vec2(218, 18.8f));
            floorSpikes3.addCollisionListener(new DestroyPlayer(game));
            floorSpikes3.setImage(floorSpike);
        }

        {   //three treasure chests around world
            Shape shape = new BoxShape(2, 1.5f);
            //treasure1
            Body treasure = new StaticBody(this, shape);
            treasure.setPosition(new Vec2(-6, 26.5f));
            treasure.addCollisionListener(new CollectTreasure(game));
            treasure.setImage(tChest);
            //treasure2
            Body treasure1 = new StaticBody(this, shape);
            treasure1.setPosition(new Vec2(150, 27.5f));
            treasure1.addCollisionListener(new CollectTreasure(game));
            treasure1.setImage(tChest);
            //treasure3
            Body treasure2 = new StaticBody(this, shape);
            treasure2.setPosition(new Vec2(189, -5.7f));
            treasure2.addCollisionListener(new CollectTreasure(game));
            treasure2.setImage(tChest);
        }
    }
}

//inner class creating obstacles for world one
class Obstacle extends DynamicBody implements StepListener {
  
    //declare and initalise the dimensions for shapes
    private static final float spikesWidth = 1.4f;
    private static final float spikesHeight = 0.5f;
    private static final float chainWidth = 0.1f;
    private static final float chainHeight = 11.7f;
    
    //create new image
    private BodyImage img = new BodyImage("data/obstacle.png", 25);
    
     //join spikes with chain
    private Shape spikesShape = new BoxShape(spikesWidth, spikesHeight,
                new Vec2(0, -chainHeight));
    private Shape chainShape = new BoxShape(chainWidth, chainHeight,
                new Vec2(0, spikesHeight));

    public Obstacle(ShadeWorlds world){
        super(world);
        //set image to obstacle 
        this.setImage(img);
        //create fixture and set density to spikes      
        SolidFixture spikes = new SolidFixture(this, spikesShape, 100);
        //set restitution
        spikes.setRestitution(1.0f);
        //create ficture and set density to chain
        SolidFixture chain = new SolidFixture(this, chainShape, 1);
        //set friction to chain
        chain.setFriction(10);
        //prevent rotation
        this.setFixedRotation(true);
   }
    
    @Override
    public void preStep(StepEvent e){
        //check if Y-Axis of obstacle is more than 40 and sets LinVelocity
        if(this.getPosition().y>40){
        this.setLinearVelocity(new Vec2(0,20));
        //check if Y-Axis of obstacle is less than 18 and sets LinVelocity
        }else if(this.getPosition().y<18){
        this.setLinearVelocity(new Vec2(0,20));
        }
    }
     
    @Override
    //overridden but not used
    public void postStep(StepEvent e){
    }
}

