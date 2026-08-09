package it.unicam.universita.mdp2526.gui.GraphicController;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class SleepController implements FxController {
    private SceneManager
            sceneManager;
    private GraphicEngine engine;
    @FXML
    private ChoiceBox<Integer> hoursChoiceBox;
    @FXML
    private ProgressBar energyBar;
    @FXML
    private Label notify;

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
        energyBar.setProgress(engine.getCharacter().getEnergy() / 10.0);
    }

    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;
    }

    @Override
    public void updateState() {
        setChoiceBox();
        setEnergyBar();
    }

    public void sleep(){
engine.sleepManagemant(hoursChoiceBox.getValue());
        setEnergyBar();
    }

    public void setNotify(String s ){
        notify.setText("La tua stamina è piena, esci per ritornare al menu");
    }


    public void exit(){
        sceneManager.showMenuScene();
    }

}
