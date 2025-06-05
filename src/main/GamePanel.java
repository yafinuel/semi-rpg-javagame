package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 0, yDelta = 0;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;

    public GamePanel(){
        
        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[8][8];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 32, j * 32, 32, 32);
            }
        }
    }

    private void importImg() {
        try (InputStream is = getClass().getResourceAsStream("/sprites.png")) {
            if (is != null) {
                img = ImageIO.read(is);
            } else {
                System.err.println("File gambar tidak ditemukan!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setPanelSize(){
        Dimension size = new Dimension(960, 540);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void setDirection (int direction){
        this.playerDir = direction;
        moving = true;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction)){
                aniIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if (moving) {
            playerAction = SIDE_WALK;
        } else {
            playerAction = IDLE;
        }
    }
    private void updatePos() {
        if (moving) {
            switch (playerDir){
                case LEFT:
                    xDelta -= 5;
                    break;
                case UP:
                    yDelta -= 5;
                    break;
                case RIGHT:
                    xDelta += 5;
                    break;
                case DOWN:
                    yDelta += 5;
                    break;
            }
        }
    }

    public void updateGame() {
        updateAnimationTick();
        setAnimation();
        updatePos();
    }

    // Tempat menggambar
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 64, 64, null);
    }
}
