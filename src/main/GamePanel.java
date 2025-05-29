package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.fillRect(100,100,200,50);
    }
}
