package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;

public class SleepController implements FxController {
    private SceneManager
            sceneManager;
    private GraphicEngine engine;
    @FXML
    private ChoiceBox<Integer> hoursChoiceBox;
    @FXML
    private ProgressBar energyBar;

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager=sceneManager;
    }

    public void setChoiceBox() {

        ObservableList<Integer> hours = FXCollections.observableArrayList();

        for (int i = 1; i <= 10; i++) {
            hours.add(i);
        }

        hoursChoiceBox.setItems(hours);
    }
    public void setEnergyBar(){
        energyBar.setProgress(engine.getCharacter().getEnergy());
    }
    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;
        setChoiceBox();
        setEnergyBar();
    }
    public void sleep(){
        engine.getCharacter().sleep(hoursChoiceBox.getValue());
    }
}
