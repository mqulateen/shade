package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Third world in the game, Extends the general world ShadeWorlds
 *
 * @author M0MAC
 */
public class WorldThree extends ShadeWorlds {

    private static final Color platColour = new Color(0, 204, 204);
    private FireBalls fireBalls;

    public WorldThree(ShadeGame game) {
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
            endGround.setPosition(new Vec2(-7, 70));
            endGround.setFillColor(platColour);
        }

        {
            Shape shape = new BoxShape(48.5f, 0.5f);
            //leftWall
            Body leftWall = new StaticBody(this, shape);
            leftWall.setPosition(new Vec2(-13.5f, 36));
            leftWall.setAngleDegrees(90);
            leftWall.setFillColor(platColour);
            //rightWall
            Body rightWall = new StaticBody(this, shape);
            rightWall.setPosition(new Vec2(147.5f, 36));
            rightWall.setAngleDegrees(90);
            rightWall.setFillColor(platColour);
        }

        {//ceiling
            Shape shape = new BoxShape(81, 0.5f);
            Body ceiling = new StaticBody(this, shape);
            ceiling.setPosition(new Vec2(67, 85));
            ceiling.setFillColor(platColour);
        }
////////////////////////////////////////////////////////////////////////////////
        //platforms

        {
            Shape shape = new BoxShape(2.5f, 2.5f);

            //first half of platforms
            StaticBody plat1 = new StaticBody(this, shape);
            plat1.setPosition(new Vec2(17, -6));
            plat1.setFillColor(Color.BLUE);
            //plat1.addCollisionListener(new World3Platforms(player, plat1));

            StaticBody plat2 = new StaticBody(this, shape);
            plat2.setPosition(new Vec2(37, 3));
            plat2.setFillColor(Color.CYAN);
            plat2.addCollisionListener(new World3Platforms(player, plat2));

            StaticBody plat3 = new StaticBody(this, shape);
            plat3.setPosition(new Vec2(63, 10));
            plat3.setFillColor(Color.GREEN);
            //plat3.addCollisionListener(new World3Platforms(player, plat3));

            StaticBody plat4 = new StaticBody(this, shape);
            plat4.setPosition(new Vec2(90, 17));
            plat4.setFillColor(Color.MAGENTA);
            plat4.addCollisionListener(new World3Platforms(player, plat4));

            StaticBody plat5 = new StaticBody(this, shape);
            plat5.setPosition(new Vec2(117, 25));
            plat5.setFillColor(Color.ORANGE);
            //plat5.addCollisionListener(new World3Platforms(player, plat5));

            //second half of platforms
            StaticBody plat6 = new StaticBody(this, shape);
            plat6.setPosition(new Vec2(117, 40));
            plat6.setFillColor(Color.PINK);
            plat6.addCollisionListener(new World3Platforms(player, plat6));

            StaticBody plat7 = new StaticBody(this, shape);
            plat7.setPosition(new Vec2(90, 48));
            plat7.setFillColor(Color.RED);
            plat7.addCollisionListener(new World3Platforms(player, plat7));

            StaticBody plat8 = new StaticBody(this, shape);
            plat8.setPosition(new Vec2(63, 55));
            plat8.setFillColor(Color.YELLOW);
            plat8.addCollisionListener(new World3Platforms(player, plat8));

            StaticBody plat9 = new StaticBody(this, shape);
            plat9.setPosition(new Vec2(37, 63));
            plat9.setFillColor(Color.BLUE);
            plat9.addCollisionListener(new World3Platforms(player, plat9));

            StaticBody plat10 = new StaticBody(this, shape);
            plat10.setPosition(new Vec2(17, 70));
            plat10.setFillColor(Color.CYAN);
            plat10.addCollisionListener(new World3Platforms(player, plat10));

        }
        {   //halfway platform
            Shape shape = new BoxShape(8, 0.5f);
            Body halfPlat = new StaticBody(this, shape);
            halfPlat.setPosition(new Vec2(140, 34));
            halfPlat.setFillColor(Color.GREEN);
        }

        {//fireball1
            fireBalls = new FireBalls(this);
            fireBalls.setPosition(new Vec2(27, 15));
            fireBalls.addCollisionListener(new DestroyPlayer(game));
            //fireBalls.addCollisionListener(fireBalls);
        }
        {//fireball2
            fireBalls = new FireBalls(this);
            fireBalls.setPosition(new Vec2(48, 75));
            fireBalls.addCollisionListener(new DestroyPlayer(game));
            //fireBalls.addCollisionListener(fireBalls);
        }
        {//fireball3
            fireBalls = new FireBalls(this);
            fireBalls.setPosition(new Vec2(75, 75));
            fireBalls.addCollisionListener(new DestroyPlayer(game));
            //fireBalls.addCollisionListener(fireBalls);
        }
        {//fireball4
            fireBalls = new FireBalls(this);
            fireBalls.setPosition(new Vec2(118, 75));
            fireBalls.addCollisionListener(new DestroyPlayer(game));
            //fireBalls.addCollisionListener(fireBalls);
        }
        {//fireball5
            fireBalls = new FireBalls(this);
            fireBalls.setPosition(new Vec2(128, 75));
            fireBalls.addCollisionListener(new DestroyPlayer(game));
            //fireBalls.addCollisionListener(fireBalls);
        }

        {   //the portal that ends the game
            Shape shape = new BoxShape(1.5f, 3.5f);
            Body portal = new StaticBody(this, shape);
            portal.setPosition(new Vec2(-10, 74));
            portal.setImage(new BodyImage("data/world3Portal.png", 10));
            portal.addCollisionListener(new GameFinish(game, player));
        }

        {   //ground
            Shape shape = new BoxShape(50, 0.3f);

            for (int i = 5; i <= 80; i = i + 50) {
                Body ground = new StaticBody(this, shape);
                ground.setPosition(new Vec2(i * 2, -18));
                ground.addCollisionListener(new DestroyPlayer(game));
                ground.setImage(new BodyImage("data/lava.gif", 5));
            }
        }

    }

}