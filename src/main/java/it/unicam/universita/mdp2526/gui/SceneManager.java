package it.unicam.universita.mdp2526.gui;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.Controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private final Stage stage;
    private final GraphicEngine engine;
private   FXMLLoader loader;
    public SceneManager(Engine engine, Stage stage) {
        this.engine = (GraphicEngine) engine;
        this.stage = stage;
    }

    /**
     * Carica la scena e  imposta engine e scenemanager  nel controller
     */
    private <T extends FxController> void loadScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + fxml));
            this.loader=loader;
          Parent root = loader.load();

            T controller = loader.getController();

            // 1. Prima passi le dipendenze
            controller.setEngine(engine);
            controller.setSceneManager(this);

            // 2. Poi fai l'update della grafica!
            controller.updateState();

            // 3. Infine mostri la scena
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException("Impossibile caricare il file FXML: " + fxml, e);
        }
    }

    public void showMenuScene() {
        loadScene("menu.fxml");
    }

    public void showSubjectsScene() {
        loadScene("subjects.fxml");
    }

    public void showQuizScene() {
        loadScene("quiz.fxml");
    }

    public void showSleepScene() {
        loadScene("sleep.fxml");
    }

    public void showHangOutWithFriendsScene() {
        loadScene("hangOutWithFriends.fxml");
    }

    public void showGameOverScene() {
        loadScene("gameOver.fxml");
    }
    public void showExamPassedScene() {
        loadScene("examPassed.fxml");
    }
    public void showVictory() {
        loadScene("victory.fxml");
    }
}