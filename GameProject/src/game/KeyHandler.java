package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DebugViewer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 * The KeyHandler class assigns keys to move player
 * @author M0MAC
 */
public class KeyHandler extends KeyAdapter {

    //initalise the jumping and walking speeds
    private static final float JUMPING_SPEED = 13.5f;
    private static final float WALKING_SPEED = 15;

    private PlayerSpeed walkLeft;
    private PlayerSpeed walkRight;
    private ShadeGame game;
    private Player player;
    private PlayerSpeed currentWalker;
    private static final BodyImage jump = new BodyImage("data/playerJump.gif", 7);
    private static final BodyImage standLeft = new BodyImage("data/standLeft.gif", 7);
    private static final BodyImage standRight = new BodyImage("data/standRight.gif", 7);
    private static final BodyImage moveRight = new BodyImage("data/moveRight.gif", 7);
    private static final BodyImage moveLeft = new BodyImage("data/moveLeft.gif", 7);

    public KeyHandler(ShadeGame game) {
        this.game = game;
        this.player = game.getWorld().getPlayer();
        this.walkLeft = new PlayerSpeed(game, -WALKING_SPEED);
        this.walkRight = new PlayerSpeed(game, WALKING_SPEED);
        this.currentWalker = null;
    }

    //method to allocate key to a certian movement
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        /**
        ***Shooting, Works perfectly well but commented for now.
        if (code == java.awt.event.KeyEvent.VK_X && game.getLevelCounter() == 3) {
        Bullet bullet = new Bullet(game);
        bullet.setLinearVelocity(new Vec2(70, 0));
        bullet.addCollisionListener(bullet);
        bullet.setPosition(game.getWorld().getPlayer().getPosition().add(new Vec2(2,0)));
        }
        if (code == java.awt.event.KeyEvent.VK_Z && game.getLevelCounter() == 3) {
        Bullet bullet = new Bullet(game);
        bullet.setLinearVelocity(new Vec2(-70, 0));
        bullet.addCollisionListener(bullet);
        bullet.setPosition(game.getWorld().getPlayer().getPosition().add(new Vec2(-2,0)));
        }
        */
        
        // Space = Jump        
        if (code == KeyEvent.VK_SPACE) {
            //change image on player
            game.getWorld().getPlayer().setImage(jump);
            Vec2 v = game.getWorld().getPlayer().getLinearVelocity();
            //only jump if not already jumping
            if (Math.abs(v.y) < 0.01f) {
                game.getWorld().getPlayer().setLinearVelocity(new Vec2(v.x, JUMPING_SPEED));
            }

        // Right Key = Move Right     
        } else if (code == KeyEvent.VK_RIGHT) {
            //movement
            setWalker(walkRight);
            //change image on player
            game.getWorld().getPlayer().setImage(moveRight);
            
        // Left Key = Move Left           
        } else if (code == KeyEvent.VK_LEFT) {
            //movement
            setWalker(walkLeft);
            //change image on player
            game.getWorld().getPlayer().setImage(moveLeft);
            
        // Q = Opens Debug View
        } else if (code == KeyEvent.VK_Q) {
            JFrame debugView = new DebugViewer(game.getWorld(), 800, 600);
        }

    }

    //method used to stop movement when keyreleased
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            clearWalker(walkLeft);
            game.getWorld().getPlayer().setImage(standLeft);
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            clearWalker(walkRight);
            game.getWorld().getPlayer().setImage(standRight);
        }
    }

    //set the walker, unless already walking
    void setWalker(PlayerSpeed w) {
        if (currentWalker == null) {
            currentWalker = w;
            game.getWorld().addStepListener(currentWalker);
        }
    }

    //clear the walker, if this is the one in effect.
    void clearWalker(PlayerSpeed w) {
        if (currentWalker == w) {
            game.getWorld().removeStepListener(currentWalker);
            currentWalker = null;
        }
    }
}
