package it.unicam.universita.mdp2526.gui.GraphicController;
import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
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



    public void updateState() {

        setStateBar();
setNotify(
                "Ciao sono "
                        + engine.getHero().getName()
                        + " aiutami, devo passare tutti gli esami in tempo!!"
        );


    }



    public void setStateBar() {

        // ProgressBar vuole valori tra 0 e 1
        stressBar.setProgress(engine.getHero().getStress() / 10.0);
        energyBar.setProgress(engine.getHero().getEnergy() / 10.0);
        lifeBar.setProgress(engine.getHero().getLife() / 3.0);
    }







                private void startActivity(GameMode mode) {
            // questo bottone l'ho implementato per non far premere piu volte lo stesso bottone e perdere in modo non sensato la vita
                    if (engine.isJustPressed()) {
                        this.setNotify("Se provi ancora a studiare con così tanto stress perderai vita.");
                        return;
                    }
            // check che puo studiare
                    if (!engine.canStartStudyOrExam()) {
            setNotify("Non puoi fare queste attività con così tanto stress");
            updateState();
            if (engine.checkgGameOver()) {
                            sceneManager.showGameOverScene();
                        }

                        return;
                    }
                    // per non soccombere a codice duplicato ho creato un enumeration che setta le modalità

                    if (mode == GameMode.STUDY) {
                        engine.setStudyMode();
                    } else {
                        engine.setExamMode();
                    }

                    engine.setJustPressed(false);
                    sceneManager.showSubjectsScene();
                }





    @FXML
    public void studyStart() {
        startActivity(GameMode.STUDY);

        }

    @FXML
    public void examStart() {
    startActivity(GameMode.EXAM);
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

    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    @Override
    public void setSceneManager(SceneManager sceneManager) {

        this.sceneManager = sceneManager;
        }


        public void setNotify(String s ) {
                this.notify.setText(s);
    }


    @Override
        public void setEngine(Engine engine) {
            this.engine = (GraphicEngine) engine;
        }


}