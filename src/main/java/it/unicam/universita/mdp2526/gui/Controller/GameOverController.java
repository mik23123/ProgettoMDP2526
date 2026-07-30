package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;

public class GameOverController implements FxController{
    private SceneManager sceneManager;
    private  GraphicEngine engine;

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager=sceneManager;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;

    }

    @Override
    public void updateState() {

    }
    @FXML
    public void exit() {
        engine.restartGame();

        System.exit(0);
    }



}
