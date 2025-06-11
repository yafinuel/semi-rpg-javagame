package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;

    private  Game game;
    public GamePanel(Game game){
        
        mouseInputs = new MouseInputs(this);
        this.game = game;


        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }



    private void setPanelSize(){
        Dimension size = new Dimension(960, 540);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }


    public void updateGame() {

    }

    // Tempat menggambar
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.render(g);

    }

    public Game getGame(){
        return game;
    }

}
