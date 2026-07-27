package it.unicam.universita.mdp2526.Meccaniche;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private Stage stage;
    public Scenary currentScenary;

    public  SceneManager(){
        this.stage=new Stage();
    }




public void showMenuScene() throws IOException{
    Parent root = null;
    try {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/menu.fxml")
        );

        root = loader.load();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
}

    public void showQuizScene()  {
Parent root = null;
        try {
    FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/quiz.fxml")
    );

    root = loader.load();
} catch (IOException e) {
    throw new RuntimeException(e);
}

Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    public void showSubjectsScene()  {

        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/Subject.fxml")
            );

            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
}
}
