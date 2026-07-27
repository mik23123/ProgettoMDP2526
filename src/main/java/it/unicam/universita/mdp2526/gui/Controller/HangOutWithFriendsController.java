package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;

import javax.swing.text.html.ImageView;

public class HangOutWithFriendsController implements FxController{
    @FXML
    private ImageView imageFriends;
    private GraphicEngine engine;
    private SceneManager sceneManager;
    @FXML
    private ProgressBar stressBar;
    @FXML
    private ChoiceBox<Integer> hoursChoiceBox;


    private HangOutWithFriendsController(){

    }

    //qui setto il choice boxe con i numeri da 1 a 10
    public void setChoiceBox() {

        ObservableList<Integer> hours = FXCollections.observableArrayList();

        for (int i = 1; i <= 10; i++) {
            hours.add(i);
        }

        hoursChoiceBox.setItems(hours);
    }

public void setStressBar(){
        stressBar.setProgress(engine.getCharacter().getStress());
}
    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager=sceneManager;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;
        setChoiceBox();
        setStressBar();

    }
    private void confirmHangOut(){
        engine.getCharacter().decrementStress(hoursChoiceBox.getValue());
    }

    }
