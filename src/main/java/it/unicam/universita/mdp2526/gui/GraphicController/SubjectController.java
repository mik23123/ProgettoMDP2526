package it.unicam.universita.mdp2526.gui.GraphicController;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SubjectController implements FxController {
    @FXML
    private Label subjectLabel;
    @FXML
    private ChoiceBox choiceBoxeSubject;
    @FXML
    private Button confirmButton;
    @FXML
    private Label notify;
    private SceneManager sceneManager;
    private GraphicEngine engine;


    @Override
    public void updateState() {
        setChoiceBoxeSubject();
        setSubjectList();
    }

    public void setSubjectList(){
        subjectLabel.setText(this.engine.readListOfExam());
    }

    public void  setChoiceBoxeSubject(){

        ObservableList<String> examList=engine.getExams().stream()
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));

        choiceBoxeSubject.setItems(examList);
    }

    public void  quizStart(){
        if (choiceBoxeSubject.getSelectionModel().getSelectedIndex() == -1) {
            setNotify("Seleziona prima una materia!");
            return;
        }

                engine.setApplicant(choiceBoxeSubject.getSelectionModel().getSelectedIndex(),engine.getMode());


        sceneManager.showQuizScene();
    }


    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager=sceneManager;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;
    }

    public void setNotify(String s){
        this.notify.setText(s);
    }

    public void exit(){
        sceneManager.showMenuScene();
    }
}
