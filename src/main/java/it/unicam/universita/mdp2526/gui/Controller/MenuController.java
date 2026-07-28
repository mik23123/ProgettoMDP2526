package it.unicam.universita.mdp2526.gui.Controller;
import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MenuController implements FxController {

    @FXML
    private Label greetingLabel;

    @FXML
    private Label stateOfLabel;

    @FXML
    private Label notify;

    @FXML
    private ProgressBar stressBar;

    @FXML
    private ProgressBar energyBar;

    @FXML
    private ProgressBar lifeBar;

    @FXML
    private Button studyButton;

    @FXML
    private Button examButton;

    @FXML
    private Button hangOutWithFriendsButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button sleepButton;

    @FXML
    private Button exitButton;

    private GraphicEngine engine;

    private SceneManager sceneManager;

    public MenuController() {

    }

    public void updateState() {
    greetingLabel=new Label();
        greetingLabel.setText(
                "Ciao sono "
                        + engine.getCharacter()
                        + " aiutami, devo passare tutti gli esami in tempo!!"
        );
        setStateBar();
    }

    public void setStateBar() {

        // ProgressBar vuole valori tra 0 e 1
        stressBar.setProgress(engine.getCharacter().getStress() / 10.0);
        energyBar.setProgress(engine.getCharacter().getEnergy() / 10.0);
        lifeBar.setProgress(engine.getCharacter().getLife() / 10.0);
    }

    @FXML
    public void studyStart() {

        if (engine.getCharacter().checkStress()) {
            notify.setText("Sei troppo stressato, riposati.");
            return;
        }
        sceneManager.showSubjectsScene();
        engine.setStudyMode();


    }

    @FXML
    public void examStart() {

        if (engine.getCharacter().checkStress()) {
            notify.setText("Sei troppo stressato, riposati.");
            return;
        }
        sceneManager.showSubjectsScene();
        engine.setExamMode();


    }

    @FXML
    public void sleepStart() {

        sceneManager.showSleepScene();
    }

    @FXML
    public void hangOutWithFriendsStart() {
        sceneManager.showHangOutWithFriendsScene();
    }

    @FXML
    public void save() {

        engine.saveManagement();

        notify.setText("Salvataggio completato.");
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    @Override
    public void setSceneManager(SceneManager sceneManager) {

        this.sceneManager = sceneManager;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = (GraphicEngine) engine;
    }
}