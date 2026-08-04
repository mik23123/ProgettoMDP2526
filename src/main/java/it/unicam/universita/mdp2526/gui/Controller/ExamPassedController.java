package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;

public class ExamPassedController implements  FxController{
   private SceneManager s1;
   private GraphicEngine e1;
    @FXML
    private Label notify;

    public void exit(){
        s1.showMenuScene();
    }

    @Override
    public void setSceneManager(SceneManager s1) {
     this.s1=s1;
    }

    @Override
    public void setEngine(Engine e1) {
this.e1=(GraphicEngine) e1;
    }

    @Override
    public void updateState() {
setNotify("");
    }

    @Override
    public void setNotify(String s) {
        this.notify.setText("Bravo, hai passato l'esame con : " + e1.getCurrentQuiz().getQuizScore() + "su 30 ");

    }

}
