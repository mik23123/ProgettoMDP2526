package it.unicam.universita.mdp2526.gui.GraphicController;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.Personaggio.SocializeAble;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    @FXML
    private Label notify;
    private SocializeAble socializeAble;


    //qui setto il choice boxe con i numeri da 1 a 10
    public void setChoiceBox() {

        ObservableList<Integer> hours = FXCollections.observableArrayList();

        for (int i = 1; i <= 10; i++) {
            hours.add(i);
        }

        hoursChoiceBox.setItems(hours);
    }


public void setStressBar(){
    stressBar.setProgress(engine.getHero().getStress() / 10.0);
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
setStressBar();
setChoiceBox();
    }
    public void confirmHangOut(){
        if(!engine.hangOutManagemant(hoursChoiceBox.getValue())){
          setNotify("non hai abbastanza energie per uscire così tante ore!!");}
        System.out.println(engine.getHero().getStress());
        setStressBar();
    }
    public void exit(){
        sceneManager.showMenuScene();
    }

    public void setNotify(String notify){
        this.notify.setText(notify);
    }
    }
