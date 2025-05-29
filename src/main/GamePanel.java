package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import javax.imageio.ImageIO;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static utils.Constants.PlayerConstant.*;
import static utils.Constants.Direction.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15; // FPS
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;


    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        importImg();
        setPanelSize();
        loadAnimations();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6]; // Ini adalah array foto

        for(int j = 0; j < animations.length; j++)
            for(int i = 0; i < animations.length; i++)
                animations[i] = img.getSubimage(i*64, 0, 64, 40);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/SpriteSheet.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setPreferredSize(size);
    }
    public void setDirection (int direction) {
        this.playerDir = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void updateAnimationTick(){

        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction))
                aniIndex = 0; // Untuk index foto
        }

    }

    private void setAnimation() {
        if (moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }

    private void updatePos() {
        if (moving) {
            switch (playerDir) {
                case LEFT:
                    xDelta -= 5;
                    break;
                case UP:
                    yDelta -=5;
                    break;
                case RIGHT:
                    xDelta +=5;
                    break;
                case DOWN:
                    yDelta +=5;
                    break;
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimationTick();

        setAnimation();
        updatePos();

//        sub image dihapus
        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 128, 80, null); // Ngelooping animasi
    }


}
