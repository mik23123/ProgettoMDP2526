package it.unicam.universita.mdp2526.gui.Controller;


import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.Meccaniche.SceneManager;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.StudyQuiz;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.awt.*;


public class MenuController implements FxController {
    @FXML
   private Label greetingLabel;
    @FXML
    private Label stateOfLabel;
    @FXML
    private Label notify;
    @FXML
    private ProgressBar stressBar;
    @FXML
    private ProgressBar energyBar;
    @FXML
    private ProgressBar lifeBar;
    @FXML
    private Button studyButton;
    @FXML
    private Button examButton;
    @FXML
    private Button hangOutWithFriendsButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button sleepButton;
    @FXML
    private Button exitButton;
    private GraphicEngine engine;
    private SceneManager sceneManager;
    public void  updateState(){
        greetingLabel.setText("Ciao sono " +engine.getCharacter().toString() + "  aiutami, devo passare tutti gli esami in tempo!!");
    }
    public MenuController(){

    }


public void setStateBar(){
        stressBar.setProgress(engine.getCharacter().getStress()/10);
        energyBar.setProgress(engine.getCharacter().getEnergy()/10);
        lifeBar.setProgress(engine.getCharacter().getLife()/10);
}
public void studyStart()  {
    if(engine.getCharacter().checkStress())
        notify.setText("sei troppo Stressato,riposati");

        StudyQuiz q1=null;
        engine.setApplicant(q1);
        sceneManager.showSubjectsScene();
}
public void examStart(){
        if(engine.getCharacter().checkStress())
            notify.setText("sei troppo Stressato,riposati");
    EnemyProfessor e1=null;
    engine.setApplicant(e1);
    sceneManager.showSubjectsScene();
}
public void saveGame(){
        engine.saveManagement();
        notify.setText("Salvataggio Completato");
}

    @Override
    public void setSceneManager(SceneManager sceneManager) {
    this.sceneManager=sceneManager;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;

    }
}
