package br.com.hellmets.motocerol.AndGraph;

import br.com.hellmets.motocerol.R;

/**
 * Created by thales on 27/11/2017.
 */

public class CenaAbertura extends AGScene {
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    private AGSprite play;
    public CenaAbertura(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        setSceneBackgroundColor(1,0,0);

        play = createSprite(R.mipmap.btnjogar,2,2);
        play.setScreenPercent(20,20);
        play.vrPosition.setX(AGScreenManager.iScreenWidth/2);
        play.vrPosition.setY(AGScreenManager.iScreenHeight/2);
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
