package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import java.io.IOException;

/**
 * The Player class creates the player by setting various things on it
 * @author M0MAC
 */
public class Player extends DynamicBody {

    private final ShadeGame game;
    private int count, health;
    private boolean hasKey;

    //player shape
    private static final Shape shape = new BoxShape(0.85f, 3.3f);

    public Player(ShadeGame game, ShadeWorlds world) {
        super(world);
        this.game = game;
        //make fixture
        SolidFixture fixture = new SolidFixture(this, shape);
        //add friction to player
        fixture.setFriction(300);
        //set an image on player
        setImage(new BodyImage("data/standRight.gif", 7));
        //prevent rotation
        setFixedRotation(true);
        //initialise boolean varible hasKey
        hasKey = false;
        //initialise treasure count and lives
        count = 0;
        health = 3;
    }

    //increments count by one
    public void plusTreasure() {
        count++;  
    }
    
    //decrements heart by one
    public void takeHealth() {
        health--;
    }
    
    //sets haskey to true when called
    public void giveKey() {
        this.hasKey = true;
    }

    //getters
    public int getTreasureAmount() {
        return count;
    }

    public int getLives() {
        return health;
    }

    public boolean hasKey() {
        return true;
    }
    
}
