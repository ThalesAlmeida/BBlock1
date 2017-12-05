package br.com.hellmets.motocerol.AndGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.hellmets.motocerol.R;

/**
 * Created by T353915 on 21/11/2017.
 */

public class CenaGame extends AGScene {
    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/

    Random random = new Random();
    private int incrementoElipse = 100;

    private List<AGSprite> quadrados;

    private AGSprite setaLeft;
    private AGSprite setaRight;
    private AGSprite setaUp;
    private AGSprite setaDown;

    private int incrementoX = 20;
    private int fpsQuadrado = 10;
    private AGSprite quadradoVermelho;
    private AGSprite quadradoAzul;
    private AGSprite quadradoPreto;
    private AGSprite quadradoVerde;
    private AGSprite quadradoAmarelo;

    private AGSprite ponte;

    private AGSprite elipse;

    private AGSprite nuvem;

    private AGSprite portal;
    private boolean gameOver = false;


    public CenaGame(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

        quadrados = new ArrayList<>();

        setSceneBackgroundColor(1, 1, 1);

        portal = createSprite(R.mipmap.portal,2,2);
        portal.setScreenPercent(20,20);
        portal.vrPosition.setX(550);
        portal.vrPosition.setY(1600);
        //portal.addAnimation(fpsQuadrado, true, 0,2);

        nuvem = createSprite(R.mipmap.nuvens,8,2 );
        nuvem.setScreenPercent(100,100);
        nuvem.vrPosition.setX(500);
        nuvem.vrPosition.setY(1200);
        //nuvem.addAnimation(fpsQuadrado, true, 0,8);

        setaLeft = createSprite(R.mipmap.setaleft,2,2);
        setaLeft.setScreenPercent(10,10);
        setaLeft.vrPosition.setX(200);
        setaLeft.vrPosition.setY(100);

        setaRight = createSprite(R.mipmap.setaright,2,2);
        setaRight.setScreenPercent(10,10);
        setaRight.vrPosition.setX(900);
        setaRight.vrPosition.setY(100);

        setaUp = createSprite(R.mipmap.setaup,2,2);
        setaUp.setScreenPercent(10,10);
        setaUp.vrPosition.setX(700);
        setaUp.vrPosition.setY(100);

        setaDown = createSprite(R.mipmap.setadown,2,2);
        setaDown.setScreenPercent(10,10);
        setaDown.vrPosition.setX(450);
        setaDown.vrPosition.setY(100);

        quadradoVermelho = createSprite(R.mipmap.quadradovermelho, 2, 2);
        quadradoVermelho.setScreenPercent(10, 10);
        quadradoVermelho.vrPosition.setX(200);
        quadradoVermelho.vrPosition.setY(1200);
        quadradoVermelho.addAnimation(fpsQuadrado, true, 0, 2);
        quadradoVermelho.vrDirection.setX(1);

        quadradoAmarelo = createSprite(R.mipmap.quadradoamarelo, 2, 2);
        quadradoAmarelo.setScreenPercent(10, 10);
        quadradoAmarelo.vrPosition.setX(500);
        quadradoAmarelo.vrPosition.setY(600);
        quadradoAmarelo.addAnimation(fpsQuadrado, true, 0, 2);
        quadradoAmarelo.vrDirection.setX(1);

        quadradoAzul = createSprite(R.mipmap.quadradoazul, 2, 2);
        quadradoAzul.setScreenPercent(10, 10);
        quadradoAzul.vrPosition.setX(500);
        quadradoAzul.vrPosition.setY(1000);
        quadradoAzul.addAnimation(fpsQuadrado, true, 0, 2);
        quadradoAzul.vrDirection.setX(1);

        quadradoVerde = createSprite(R.mipmap.quadradoverde, 2, 2);
        quadradoVerde.setScreenPercent(10, 10);
        quadradoVerde.vrPosition.setX(500);
        quadradoVerde.vrPosition.setY(410);
        quadradoVerde.addAnimation(fpsQuadrado, true, 0, 2);
        quadradoVerde.vrDirection.setX(1);

        quadradoPreto = createSprite(R.mipmap.quadradopreto, 2, 2);
        quadradoPreto.setScreenPercent(10, 10);
        quadradoPreto.vrPosition.setX(500);
        quadradoPreto.vrPosition.setY(780);
        quadradoPreto.addAnimation(fpsQuadrado, true, 0, 2);
        quadradoPreto.vrDirection.setX(1);

        elipse = createSprite(R.mipmap.elipse, 2, 2);
        elipse.setScreenPercent(5, 5);
        elipse.vrPosition.setX(570);
        elipse.vrPosition.setY(200);

        ponte = createSprite(R.mipmap.ponte, 2, 2);
        ponte.setScreenPercent(140, 1);
        ponte.vrPosition.setX(500);
        ponte.vrPosition.setY(1100);

        ponte = createSprite(R.mipmap.ponte, 2, 2);
        ponte.setScreenPercent(140, 1);
        ponte.vrPosition.setX(500);
        ponte.vrPosition.setY(900);

        ponte = createSprite(R.mipmap.ponte, 2, 2);
        ponte.setScreenPercent(135, 1);
        ponte.vrPosition.setX(500);
        ponte.vrPosition.setY(700);

        ponte = createSprite(R.mipmap.ponte, 2, 2);
        ponte.setScreenPercent(150, 1);
        ponte.vrPosition.setX(500);
        ponte.vrPosition.setY(500);

        ponte = createSprite(R.mipmap.ponte, 2, 2);
        ponte.setScreenPercent(170, 1);
        ponte.vrPosition.setX(500);
        ponte.vrPosition.setY(300);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        if(gameOver == true){
            for(AGSprite quadrado: quadrados){
                quadrado.bRecycled = true;

                return;
            }
        }

        if(elipse.collide(portal)){
            vrGameManager.setCurrentScene(3);
            gameOver = true;
            return;
        }

        if(AGInputManager.vrTouchEvents.screenClicked()){
            if(setaDown.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                elipse.vrPosition.setY(elipse.vrPosition.getY()-200);
            }
        }

        if(AGInputManager.vrTouchEvents.screenClicked()){
            if(setaLeft.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                elipse.vrPosition.setX(elipse.vrPosition.getX()-30);
            }
        }

        if(AGInputManager.vrTouchEvents.screenClicked()){
            if(setaRight.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                elipse.vrPosition.setX(elipse.vrPosition.getX()+30);
            }
        }

        if(AGInputManager.vrTouchEvents.screenClicked()){
            if(setaUp.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                elipse.vrPosition.setY(elipse.vrPosition.getY()+200);
            }
        }

        //animaPortal();
        animaQuadradoVermelho();
        animaQuadradoAzul();
        animaQuadradoVerde();
        animaQuadradoPreto();
        animaQuadradoAmarelo();
        //upElipse();
        //downElipse();
        //leftElipse();
        //rightElipe();

        if (elipse.collide(quadradoVermelho)) {
            vrGameManager.setCurrentScene(2);
            gameOver = true;
        }else{
            if (elipse.collide(quadradoVerde)){
                vrGameManager.setCurrentScene(2);
                gameOver = true;
            }else{
                if (elipse.collide(quadradoPreto)){
                    vrGameManager.setCurrentScene(2);
                    gameOver = true;
                }else{
                    if (elipse.collide(quadradoAzul)){
                        vrGameManager.setCurrentScene(2);
                        gameOver = true;
                    }else{
                        if(elipse.collide(quadradoAmarelo)){
                            vrGameManager.setCurrentScene(2);
                            gameOver = true;
                        }
                    }
                }
            }
        }
    }

    /*public void tocaElipse(){
        if (AGInputManager.vrTouchEvents.screenDown()) {
            elipse.vrPosition.setX(AGInputManager.vrTouchEvents.getLastPosition().getX());
            elipse.vrPosition.setY(AGInputManager.vrTouchEvents.getLastPosition().getY());
        }
    }*/

    /*public void animaPortal(){
        portal.vrPosition.setX(portal.vrPosition.getX()+incrementoX*portal.vrDirection.getX());
        if (portal.vrPosition.getX()>= AGScreenManager.iScreenHeight + portal.getSpriteHeight()/2){
            portal.iMirror = AGSprite.HORIZONTAL;
            portal.vrDirection.setX(-2);
        }

        if(portal.vrPosition.getX() <= -portal.getSpriteWidth()/2){
            portal.iMirror = AGSprite.HORIZONTAL;
            portal.vrDirection.setX(1);
        }
    }*/

    public void animaQuadradoAmarelo(){
        quadradoAmarelo.vrPosition.setX(quadradoAmarelo.vrPosition.getX() + incrementoX* quadradoAmarelo.vrDirection.getX());
        if (quadradoAmarelo.vrPosition.getX()>= AGScreenManager.iScreenHeight + quadradoAmarelo.getSpriteHeight()/2){
            quadradoAmarelo.iMirror = AGSprite.HORIZONTAL;
            quadradoAmarelo.vrDirection.setX(-2);
        }

        if(quadradoAmarelo.vrPosition.getX() <= -quadradoAmarelo.getSpriteWidth()/2){
            quadradoAmarelo.iMirror = AGSprite.HORIZONTAL;
            quadradoAmarelo.vrDirection.setX(1);
        }
    }

    public void animaQuadradoVermelho(){
        quadradoVermelho.vrPosition.setX(quadradoVermelho.vrPosition.getX() + incrementoX* quadradoVermelho.vrDirection.getX());
        if (quadradoVermelho.vrPosition.getX()>= AGScreenManager.iScreenHeight + quadradoVermelho.getSpriteHeight()/2){
            quadradoVermelho.iMirror = AGSprite.HORIZONTAL;
            quadradoVermelho.vrDirection.setX(-3);
        }

        if(quadradoVermelho.vrPosition.getX() <= -quadradoVermelho.getSpriteWidth()/2){
            quadradoVermelho.iMirror = AGSprite.HORIZONTAL;
            quadradoVermelho.vrDirection.setX(2);
        }
    }

    public void animaQuadradoAzul(){
        quadradoAzul.vrPosition.setX(quadradoAzul.vrPosition.getX() + incrementoX* quadradoAzul.vrDirection.getX());
        if (quadradoAzul.vrPosition.getX()>= AGScreenManager.iScreenHeight + quadradoAzul.getSpriteHeight()/3){
            quadradoAzul.iMirror = AGSprite.HORIZONTAL;
            quadradoAzul.vrDirection.setX(-2);
        }

        if(quadradoAzul.vrPosition.getX() <= -quadradoAzul.getSpriteWidth()/3){
            quadradoAzul.iMirror = AGSprite.HORIZONTAL;
            quadradoAzul.vrDirection.setX(1);
        }
    }

    public void animaQuadradoVerde(){
        quadradoVerde.vrPosition.setX(quadradoVerde.vrPosition.getX() + incrementoX* quadradoVerde.vrDirection.getX());
        if (quadradoVerde.vrPosition.getX()>= AGScreenManager.iScreenHeight + quadradoVerde.getSpriteHeight()/4){
            quadradoVerde.iMirror = AGSprite.HORIZONTAL;
            quadradoVerde.vrDirection.setX(-2);
        }

        if(quadradoVerde.vrPosition.getX() <= -quadradoVerde.getSpriteWidth()/4){
            quadradoVerde.iMirror = AGSprite.HORIZONTAL;
            quadradoVerde.vrDirection.setX(1);
        }
    }

    public void animaQuadradoPreto(){
        quadradoPreto.vrPosition.setX(quadradoPreto.vrPosition.getX() + incrementoX* quadradoPreto.vrDirection.getX());
        if (quadradoPreto.vrPosition.getX()>= AGScreenManager.iScreenHeight + quadradoPreto.getSpriteHeight()/5){
            //quadradoPreto.iMirror = AGSprite.HORIZONTAL;
            quadradoPreto.vrDirection.setX(-5);
        }

        if(quadradoPreto.vrPosition.getX() <= -quadradoPreto.getSpriteWidth()/5){
            quadradoPreto.iMirror = AGSprite.HORIZONTAL;
            quadradoPreto.vrDirection.setX(2);
        }
    }



    public void upElipse() {
        if((AGInputManager.vrTouchEvents.screenClicked())){
            if(setaUp.collide(550,100))
                elipse.vrPosition.setY(elipse.vrPosition.getY()+200);

        }
    }

   /* public void downElipse(){
  ko       if(AGInputManager.vrTouchEvents.screenClicked()){
            if(setaDown.collide(500,50)){
                elipse.vrDirection.setY(elipse.vrPosition.getY()-200);
            }
        }
    }*/

    public void leftElipse() {
    }

    public void rightElipe(){
        if(AGInputManager.vrTouchEvents.screenClicked()){
            if(setaRight.collide(900,100)){
                elipse.vrPosition.setX(elipse.vrPosition.getX()+10);
            }
        }
    }
}


