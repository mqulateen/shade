package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 * Shade by Mohamed Qulateen - ABSK259.
 * ShadeGame is the main class
 */
public class ShadeGame {

    private ShadeWorlds world;
    private MyView view;
    private int zoom = 12;
    private int levelCounter;
    private JFrame frame;
    private Sounds sound;
    private ControlPanel cp;
    private MenuPage mainMenu;
    private GameLog g;
    private Boolean isComplete;

    public ShadeGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        levelCounter = 1;
        isComplete = false;
        //initialise the first world
        world = new WorldOne(this);
        
        //initialise the view, cp, mainmenu, gamelog
        view = new MyView(this, 850, 550);
        cp = new ControlPanel(view, this);
        mainMenu = new MenuPage(this);
        g = new GameLog(this);
        //set the zoom
        view.setZoom(zoom);
        //set a background in the view
        view.setBackground(Color.WHITE);
        
        //name and create a frame
        frame = new JFrame("Shade");
        //quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        //create new sound and loop it
        sound = new Sounds();
        sound.getBackgroundSound().loop();
        
        //add the main menu to the frame
        frame.add(mainMenu);

        //window cannot be resized
        frame.setResizable(false);
        //pack everything into the frame
        frame.pack();
        //make the window visible in the frame
        frame.setVisible(true);
        //add keylistener
        frame.addKeyListener(new KeyHandler(this));
        //add tracker
        world.addStepListener(new PlayerTracker(view, this));
    }

    //method to remove menu from frame and show view
    public void setView() {
        //remove mainmenu from frame
        frame.remove(mainMenu);
        //add view to frame
        frame.add(view);
        //add the controlpanel
        frame.add(cp, BorderLayout.SOUTH);
        //pack into frame
        frame.pack();
        //set focus to the window
        frame.requestFocusInWindow();
        //repaint the frame
        frame.repaint();
        //start the world
        world.start();
    }

    //method to view GameLog class when game complete
    public void gameComplete() {
        isComplete = true;
        //pause the world
        world.setPaused(true);
        //remove view/cp from frame
        frame.remove(view);
        frame.remove(cp);
        //add gamelog page to frame
        frame.add(g);
        //pack and repaint frame
        frame.pack();
        frame.repaint();
    }

    //method to switch to world 2
    public void changeWorld2() {
        //set the levelcounter to 2
        this.setLevelCounter(2);
        //pause current world
        world.setPaused(true);
        //change world
        world = new WorldTwo(this);
        //set the world,background,zoom to the view
        view.setWorld(world);
        view.setBackground(Color.CYAN);
        view.setZoom(zoom);
        world.addStepListener(new PlayerTracker(view, this));

        //write message to .txt file
        try {
            this.getGameLog().writeToFile("---Level 2---");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        //start world
        world.start();
    }

    //method to switch to world 3
    public void changeWorld3() {
        this.setLevelCounter(3);
        world.setPaused(true);
        world = new WorldThree(this);
        view.setWorld(world);
        view.setBackground(Color.ORANGE);
        view.setZoom(zoom);
        world.addStepListener(new PlayerTracker(view, this));

        try {
            this.getGameLog().writeToFile("---Level 3---");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        world.start();
    }

    //method to restart level 1
    public void restartWorld1() {
        this.setLevelCounter(1);
        world.setPaused(true);
        world = new WorldOne(this);
        view.setWorld(world);
        view.setBackground(Color.WHITE);
        view.setZoom(zoom);
        world.addStepListener(new PlayerTracker(view, this));

        try {
            this.getGameLog().writeToFile("---Level 1---");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        world.start();
    }

    //getters
    public ShadeWorlds getWorld() {
        return world;
    }

    public GameLog getGameLog() {
        return g;
    }

    public int getLevelCounter() {
        return levelCounter;
    }

    public Sounds getSound() {
        return sound;
    }
    
    public boolean isComplete(){
        return true;
    }

    //setters
    public void setLevelCounter(int levelCounter) {
        this.levelCounter = levelCounter;
    }

    /**
     * Run the Game.
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new ShadeGame();
    }
}
