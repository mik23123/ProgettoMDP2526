package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class SubjectController implements FxController {
    @FXML
    private Label subjectLabel;
    @FXML
    private ChoiceBox choiceBoxeSubject;
    @FXML
    private Button confirmButton;
    @FXML
    private Label notice;
    public boolean confirmFlag;
    private SceneManager sceneManager;
    private GraphicEngine engine;

    public SubjectController() {

    }
    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager=sceneManager;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;
setSubjectList();
setChoiceBoxeSubject();
    }



    public void setSubjectList(){
        subjectLabel.setText(this.engine.readListOfExam());
    }
    public void  setChoiceBoxeSubject(){
        choiceBoxeSubject.setItems(engine.getExams());
    }

    public void  quizStart(){
        if(engine.getMode()==GameMode.EXAM)
            engine.examManagemant(choiceBoxeSubject.getSelectionModel().getSelectedIndex());
else
            engine.studyManagemant(choiceBoxeSubject.getSelectionModel().getSelectedIndex());

sceneManager.showQuizScene();

    }

}
