package br.com.hellmets.motocerol.AndGraph;

import br.com.hellmets.motocerol.R;

/**
 * Created by thales on 27/11/2017.
 */

public class CenaDerrota extends AGScene{

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    private AGSprite gameover;
    private AGSprite playAgain;
    public CenaDerrota(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

        setSceneBackgroundColor(0,0,0);

        playAgain = createSprite(R.mipmap.btnjogar,2,2);
        playAgain.setScreenPercent(20,20);
        playAgain.vrPosition.setX(500);
        playAgain.vrPosition.setY(600);

        gameover = createSprite(R.mipmap.gameover,2,2);
        gameover.setScreenPercent(20,20);
        gameover.vrPosition.setX(500);
        gameover.vrPosition.setY(1100);

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        if (AGInputManager.vrTouchEvents.screenClicked()) {
            vrGameManager.setCurrentScene(1);
            return;
        }
    }
}
