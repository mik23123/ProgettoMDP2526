package it.unicam.universita.mdp2526.Main;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.Meccaniche.JsonQuestGetter;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.*;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Character character = new Character("Michele");

        List<Exam> exams = GameSetup.buildExams(new JsonQuestGetter());
        List<EnemyProfessor> professors = GameSetup.extractProfessors(exams);
        Engine engine = new GraphicEngine(character, exams,professors);

        SceneManager sceneManager = new SceneManager(engine, stage);
        sceneManager.showMenuScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}