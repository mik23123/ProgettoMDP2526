package it.unicam.universita.mdp2526.gui.Controller;
import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MenuController implements FxController {

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

        setStateBar();

        notify.setText(
                "Ciao sono "
                        + engine.getCharacter().getName()
                        + " aiutami, devo passare tutti gli esami in tempo!!"
        );


    }

    public void setStateBar() {

        // ProgressBar vuole valori tra 0 e 1
        stressBar.setProgress(engine.getCharacter().getStress() / 10.0);
        energyBar.setProgress(engine.getCharacter().getEnergy() / 10.0);
        lifeBar.setProgress(engine.getCharacter().getLife() / 3.0);
    }



public boolean checkGameOver(){
        if(this.engine.checkgGameOver()) {
            sceneManager.showGameOverScene();
            return true;
        }
    return false;
    }



    @FXML
    public void studyStart() {
if(checkGameOver()) return;
if(engine.isButtonStudyJustPressed()) {
    notify.setText("se cerchi di studiare con cos' tanto stress, perderai vita");
    return;}

Character c1 =  engine.getCharacter();

// allora, in pratica se il personaggio e stressato e il bottone studia non è stato gia premuto allora applica la penalità
        System.out.println(engine.isButtonStudyJustPressed());
if (c1.checkStress() ) {
    c1.applyStressPenalty();
    setStateBar();
    notify.setText("Sei troppo stressato, riposati. Il personaggio sta perdendo vita, ATTENTO");
    checkGameOver();
    engine.setButtonStudyJustPressed(true);
    return;
        }
        sceneManager.showSubjectsScene();
        engine.setStudyMode();
        engine.setButtonStudyJustPressed(false);


    }

    @FXML
    public void examStart() {
        if(checkGameOver()) return;
        if(engine.isButtonStudyJustPressed()) {
            notify.setText("se cerchi di fare l'esame  con cos' tanto stress, perderai vita");
            return;}

        Character c1 =  engine.getCharacter();

// allora, in pratica se il personaggio e stressato e il bottone studia non è stato gia premuto allora applica la penalità
        if (c1.checkStress() ) {
            c1.applyStressPenalty();
            setStateBar();
            notify.setText("Sei troppo stressato, riposati. Il personaggio sta perdendo vita, ATTENTO");
            checkGameOver();
            engine.setButtonStudyJustPressed(true);
            return;
        }
        sceneManager.showSubjectsScene();
        engine.setExamMode();
        engine.setButtonStudyJustPressed(false);



    }

    @FXML
    public void sleepStart() {
        sceneManager.showSleepScene();
    }

    @FXML
    public void hangOutWithFriendsStart() {
        engine.setButtonStudyJustPressed(false);
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
public Label getNotify()
{
    return notify;
}@Override
    public void setEngine(Engine engine) {
        this.engine = (GraphicEngine) engine;
    }
}