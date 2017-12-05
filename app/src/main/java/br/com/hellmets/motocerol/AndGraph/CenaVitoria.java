package br.com.hellmets.motocerol.AndGraph;

import br.com.hellmets.motocerol.R;

/**
 * Created by thales on 02/12/2017.
 */

public class CenaVitoria extends AGScene {
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/

    private AGSprite youWon;
    private AGSprite playAgain;
    public CenaVitoria(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        youWon = createSprite(R.mipmap.youwon,2,2 );
        youWon.setScreenPercent(100,100);
        youWon.vrPosition.setX(500);
        youWon.vrPosition.setY(500);

        playAgain = createSprite(R.mipmap.btnjogar,2,2 );
        playAgain.setScreenPercent(20,20);
        playAgain.vrPosition.setX(500);
        playAgain.vrPosition.setY(900);
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
