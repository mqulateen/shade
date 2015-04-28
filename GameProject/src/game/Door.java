package game;

import city.cs.engine.*;
import javax.swing.JOptionPane;

/**
 * The Door class creates doors used in world1/2 
 * @author M0MAC
 */
public class Door extends StaticBody implements CollisionListener{
 
    private ShadeWorlds world;
    private ShadeGame game;
    private boolean open;
    private static final BodyImage openDoor = new BodyImage("data/openDoor.png", 16);
    private static final Shape shape = new PolygonShape(-2.87f, -3.08f, 2.99f,
            -3.08f, 2.92f, 2.84f, 2.33f, 4.30f, -2.09f, 4.30f, -2.79f, 2.81f);


    public Door(ShadeWorlds world, ShadeGame game) {
        super(world, shape);
        this.world = world;
        this.game = game;
        setImage(new BodyImage("data/closedDoor.png", 16));
        open = false;
    }
    
    /*method used in collect key, changes the state of the door to open and 
      replaces the initial image*/
    public void unlockDoor() {
        setImage(openDoor);
        open = true;
    }
    
    //collision method used to change worlds when the player has the key
    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() == world.getPlayer() && open == true && game.getLevelCounter() == 1) {
            game.changeWorld2();
            game.getSound().getCompleteSound().play();
        }else if(e.getOtherBody() == world.getPlayer() && open == true && game.getLevelCounter() == 2) {
            JOptionPane.showMessageDialog(null, "BE WARNED! Platforms disappear 10 Seconds after stepping on them so move fast!");
            game.changeWorld3();
            game.getSound().getCompleteSound().play();
        }else{
            if(e.getOtherBody() == world.getPlayer()){
            JOptionPane.showMessageDialog(null, "The Door is Locked. Find the Key to unlock it.");
            }
        }
    }
}