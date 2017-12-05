//Aplication package
package br.com.hellmets.motocerol.AndGraph;

//Used Packages
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Game extends AGActivityGame {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.vrManager = new AGGameManager(this, false);

        CenaGame cenaGame = new CenaGame(vrManager);
        CenaAbertura cenaAbertura = new CenaAbertura(vrManager);
        CenaDerrota cenaDerrota = new CenaDerrota(vrManager);
        CenaVitoria cenaVitoria = new CenaVitoria(vrManager);

        //Cena 0
        vrManager.addScene(cenaAbertura);
        //Cena 1
        vrManager.addScene(cenaGame);
        //Cena 2
        vrManager.addScene(cenaDerrota);
        //Cena 3
        vrManager.addScene(cenaVitoria);


    }
}
