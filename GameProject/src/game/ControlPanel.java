package game;

import java.io.IOException;

/**
 * The ControlPanel class give easy access buttons to user while playing
 * @author M0MAC
 */

public class ControlPanel extends javax.swing.JPanel {

    private MyView view;
    private ShadeGame game;

    public ControlPanel(MyView view, ShadeGame game) {
        this.view = view;
        this.game = game;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pauseButton = new javax.swing.JToggleButton();
        exitButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        soundButton = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setEnabled(false);
        setOpaque(false);

        pauseButton.setText("Pause");
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        exitButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        exitButton.setMaximumSize(new java.awt.Dimension(66, 36));
        exitButton.setMinimumSize(new java.awt.Dimension(66, 36));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        restartButton.setText("Restart Level");
        restartButton.setFocusable(false);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        soundButton.setText("Mute Music");
        soundButton.setFocusable(false);
        soundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(pauseButton)
                .addGap(77, 77, 77)
                .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(soundButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        //toggle button to play/pause the world
        if(pauseButton.isSelected()){
            game.getWorld().setPaused(true);
        }else{
            game.getWorld().setPaused(false);
        }
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //exits game
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
       //button used to restart level depending on what level you're on
       
       //writes message to .txt file
       try {
            game.getGameLog().writeToFile("Restarting Level...");
        } catch (IOException ex) {
            System.out.println(ex);
        }
       
       if(game.getLevelCounter() == 1){
           game.restartWorld1();
       }else if(game.getLevelCounter() == 2){
       game.changeWorld2();
       }else if(game.getLevelCounter() == 3){
       game.changeWorld3();
       }
    }//GEN-LAST:event_restartButtonActionPerformed

    private void soundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundButtonActionPerformed
         //toggle button to pause/play background music
         if(soundButton.isSelected()){
            game.getSound().getBackgroundSound().pause();
            
        }else{
            game.getSound().getBackgroundSound().resume();
        }
    }//GEN-LAST:event_soundButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JToggleButton pauseButton;
    private javax.swing.JButton restartButton;
    private javax.swing.JToggleButton soundButton;
    // End of variables declaration//GEN-END:variables
}
