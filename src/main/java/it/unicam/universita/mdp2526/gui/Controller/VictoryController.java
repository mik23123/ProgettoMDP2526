package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;

public class VictoryController implements  FxController{
    private SceneManager sceneManager;
    private GraphicEngine engine;
    @FXML
    private Label notify;

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
setNotify("s");
    }
    @FXML
    public void exit() {
        engine.restartGame();

        System.exit(0);
    }
    public void setNotify(String s){
    this.notify.setText("BRAVO, hai passato tutti gli esami con media : "+String.valueOf(engine.getAvgOfExamPassed()));
    }
}
