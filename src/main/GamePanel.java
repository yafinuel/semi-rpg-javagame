package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;


import java.awt.*;
import javax.swing.*;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

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
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
//        System.out.println("size: "+ GAME_WIDTH + ":" + GAME_HEIGHT);
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
