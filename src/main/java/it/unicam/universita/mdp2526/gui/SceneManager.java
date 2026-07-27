package it.unicam.universita.mdp2526.gui;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.Meccaniche.Scenary;
import it.unicam.universita.mdp2526.gui.Controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private Stage stage;
    public Scenary currentScenary;
    public Engine engine;


    public SceneManager(Engine engine, Stage stage) {
        this.stage = stage;
        this.engine = engine;
    }


    public void showMenuScene()  {
        Parent root = null;
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(
                    getClass().getResource("/menu.fxml")
            );

            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MenuController controller = loader.getController();

        controller.setEngine(engine);

        stage.setScene(new Scene(root));

        Scene scene = new Scene(root);

        stage.setScene(new Scene(root));

        stage.setScene(scene);
        stage.show();
    }

    public void showQuizScene() {
        Parent root = null;
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(
                    getClass().getResource("/quiz.fxml")
            );


            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        QuizController controller = loader.getController();
        controller.setEngine(engine);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void showSubjectsScene() {

        Parent root = null;
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(
                    getClass().getResource("/Subject.fxml")
            );

            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SubjectController controller = loader.getController();
        controller.setEngine(engine);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void showGameOverScene() {

        Parent root = null;
        FXMLLoader loader = null;

        try {
            loader = new FXMLLoader(
                    getClass().getResource("/GameOver.fxml")
            );

            root = loader.load();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GameOverController controller = loader.getController();
        controller.setEngine(engine);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }


    public void showHangOutWithFriendsScene() {

        Parent root = null;
        FXMLLoader loader = null;

        try {
            loader = new FXMLLoader(
                    getClass().getResource("/HangOutWithFriends.fxml")
            );

            root = loader.load();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HangOutWithFriendsController controller = loader.getController();
        controller.setEngine(engine);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }


    public void showSleepScene() {

        Parent root = null;
        FXMLLoader loader = null;

        try {
            loader = new FXMLLoader(
                    getClass().getResource("/Sleep.fxml")
            );

            root = loader.load();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SleepController controller = loader.getController();
        controller.setEngine(engine);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}