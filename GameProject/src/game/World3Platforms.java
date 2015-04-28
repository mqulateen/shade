package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Second world in the game, Extends the general world ShadeWorlds
 * @author M0MAC
 */
public class World3Platforms implements CollisionListener{
    
    private Player player;
    private StaticBody s;
    private Timer timer;
    private int counter = 10; //start from 10 seconds
    private int delay = 1000; //every 1 second
    
    //platforms are passed into the constructor as staticbodies
    public World3Platforms(Player player, StaticBody s){
        super();
        this.player = player;
        this.s = s;
     }
    
    /*collision method to start timer countdown to destroy platform when 
      player collides with the platform*/
    @Override
    public void collide(CollisionEvent e){
      if(e.getOtherBody() == player){
        
        //action performed by timer  
        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                //destory platform when counter is at zero or decrement counter
                if(counter == 0){
                    s.destroy();
                }
                else{
                    counter--;
                }
            }
        }; 
        //create/start timer
        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();
        }
    }
}




