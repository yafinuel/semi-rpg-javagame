package Entities;

import gamestates.Playing;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import levels.Level;

import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {
    private Playing playing;
    private BufferedImage[][] crabbyArr;
    private ArrayList<Crabby> crabbies = new ArrayList<>();

    public EnemyManager(Playing playing){
        this.playing = playing;
        loadEnemyImgs();
    }

    public void loadEnemies(Level level) {
        crabbies = level.getCrabs();
    }


    public void update(int[][] lvlData, Player player){
        boolean isAnyActive = false;
        for(Crabby c : crabbies)
            if(c.isActive()) {
                c.update(lvlData, player);
                isAnyActive = true;
            }
        if(!isAnyActive)
            playing.setLevelCompleted(true);
    }

    public void draw(Graphics g, int xLevelOffset){
        drawCrabs(g, xLevelOffset);
    }

    public void drawCrabs(Graphics g, int xLvlOffset){
        for(Crabby c : crabbies)
            if(c.isActive()){
                g.drawImage(crabbyArr[c.getEnemyState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset - CRABBY_DRAWOFFSET_X + c.flipX(), (int) c.getHitbox().y - CRABBY_DRAWOFFSET_Y, CRABBY_WIDTH * c.flipW(), CRABBY_HEIGHT, null);
//                c.drawAttackBox(g, xLvlOffset);
            }
    }

    public void checkEnemyHit(Rectangle2D.Float attackBox){
        for (Crabby c : crabbies)
            if(c.isActive())
                if(attackBox.intersects(c.getHitbox())){
                    c.hurt(10);
                    return;
                }
    }

    public void loadEnemyImgs(){
        crabbyArr = new BufferedImage[5][9];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.CRABBY_SPRITE);
        for(int j = 0; j < crabbyArr.length; j++)
            for(int i = 0; i < crabbyArr[j].length; i++)
                crabbyArr[j][i] = temp.getSubimage(i* CRABBY_WIDTH_DEFAULT, j*CRABBY_HEIGHT_DEFAULT, CRABBY_WIDTH_DEFAULT, CRABBY_HEIGHT_DEFAULT);

    }

    public void resetAllEnemies(){
        for(Crabby c : crabbies)
            c.resetEnemy();
    }
}
