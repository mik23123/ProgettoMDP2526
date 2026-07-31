package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;

import java.lang.classfile.Label;

public class LibrettoController implements FxController{
SceneManager s1;
Engine e1;
@FXML
private Label exams;

    @Override
    public void setSceneManager(SceneManager s1) {
        this.s1=s1;
    }

    @Override
    public void setEngine(Engine e1) {
this.e1= (GraphicEngine) e1 ;
    }

    @Override
    public void updateState() {

    }

}
