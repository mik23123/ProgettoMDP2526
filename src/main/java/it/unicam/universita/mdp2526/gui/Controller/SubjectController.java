package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.collections.ObservableList;
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
    }

    @Override
    public void updateState() {
        setChoiceBoxeSubject();
        setSubjectList();
    }


    public void setSubjectList(){
        subjectLabel.setText(this.engine.readListOfExam());
    }
    public void  setChoiceBoxeSubject(){
        ObservableList<String> lista = engine.getExams();
        System.out.println("Numero esami: " + lista.size()); // debug
        choiceBoxeSubject.setItems(lista);
    }
public void clearQuiz(){

}

    public void  quizStart(){
        if (choiceBoxeSubject.getSelectionModel().getSelectedIndex() == -1) {
            notice.setText("Seleziona prima una materia!");
            return;
        }


        if(engine.getMode()==GameMode.EXAM) {
            engine.examManagemant(choiceBoxeSubject.getSelectionModel().getSelectedIndex());
        }
else
            engine.studyManagemant(choiceBoxeSubject.getSelectionModel().getSelectedIndex());

sceneManager.showQuizScene();

    }
    public void StartClearQuiz(){
        engine.clearQuiz(choiceBoxeSubject.getSelectionModel().getSelectedIndex());
        updateState();
    }
    public void exit(){
        sceneManager.showMenuScene();
    }
}
