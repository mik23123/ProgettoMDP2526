package it.unicam.universita.mdp2526.gui.GraphicController;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.stream.Collectors;

public class SubjectController implements FxController {
    @FXML
    private ListView<String> examListView;
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
        setExamListView();
    }

    public void setExamListView(){
        ObservableList<String> details = FXCollections.observableArrayList(engine.readListOfExam());
        examListView.setItems(details);
        examListView.setCellFactory(list -> new ListCell<>() {

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                    setWrapText(true);
                    setStyle("-fx-padding: 12; -fx-font-size: 13px;");
                    getStyleClass().add("exam-card");
                }
            }
        });
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
                engine.setIndexOfApplicant(choiceBoxeSubject.getSelectionModel().getSelectedIndex());

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
