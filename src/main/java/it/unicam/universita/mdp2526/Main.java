package it.unicam.universita.mdp2526;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.Meccaniche.JsonQuestGetter;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.*;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {


    @Override
    public void start(Stage stage) {

        Character ch1 = new Character("Michele");

        JsonQuestGetter j1 = new JsonQuestGetter();

        EnemyProfessor p1 = new EnemyProfessor(j1.build("ProfessorQuests/Examprogrammazione.json"), "Bianchi");
        EnemyProfessor p2 = new EnemyProfessor(j1.build("ProfessorQuests/Examarchitettura.json"), "Verdi");
        EnemyProfessor p3 = new EnemyProfessor(j1.build("ProfessorQuests/Examfondamenti.json"), "Neri");
        EnemyProfessor p4 = new EnemyProfessor(j1.build("ProfessorQuests/Examstatistica.json"), "Gallo");
        EnemyProfessor p5 = new EnemyProfessor(j1.build("ProfessorQuests/Examalgoritmi.json"), "Costa");
        EnemyProfessor p6 = new EnemyProfessor(j1.build("ProfessorQuests/Examreti.json"), "Ferrari");
        EnemyProfessor p7 = new EnemyProfessor(j1.build("ProfessorQuests/ExamsistemiOperativi.json"), "Romano");
        EnemyProfessor p8 = new EnemyProfessor(j1.build("ProfessorQuests/ExamricercaOperativa.json"), "Esposito");
        EnemyProfessor p9 = new EnemyProfessor(j1.build("ProfessorQuests/Exammetodologie.json"), "De Luca");
        EnemyProfessor p10 = new EnemyProfessor(j1.build("ProfessorQuests/ExambasiDiDati.json"), "Greco");
        EnemyProfessor p11 = new EnemyProfessor(j1.build("ProfessorQuests/Examtesi.json"), "Santoro");


        List<Exam> listaEsami = List.of(
                new Exam("Programmazione", new StudyQuiz(j1.build("QuizQuests/programmazione.json")), p1),
                new Exam("Architettura degli Elaboratori", new StudyQuiz(j1.build("QuizQuests/architettura.json")), p2),
                new Exam("Fondamenti di Informatica", new StudyQuiz(j1.build("QuizQuests/fondamenti.json")), p3),
                new Exam("Statistica", new StudyQuiz(j1.build("QuizQuests/statistica.json")), p4),
                new Exam("Algoritmi e Strutture Dati", new StudyQuiz(j1.build("QuizQuests/algoritmi.json")), p5),
                new Exam("Reti di Calcolatori", new StudyQuiz(j1.build("QuizQuests/reti.json")), p6),
                new Exam("Sistemi Operativi", new StudyQuiz(j1.build("QuizQuests/sistemiOperativi.json")), p7),
                new Exam("Ricerca Operativa", new StudyQuiz(j1.build("QuizQuests/ricercaOperativa.json")), p8),
                new Exam("Metodologie di Programmazione", new StudyQuiz(j1.build("QuizQuests/metodologie.json")), p9),
                new Exam("Basi di Dati", new StudyQuiz(j1.build("QuizQuests/basiDiDati.json")), p10),
                new Exam("Tesi", new StudyQuiz(j1.build("QuizQuests/tesi.json")), p11)
        );


        List<EnemyProfessor> professors = List.of(
                p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11
        );


        Engine engine = new GraphicEngine(ch1,listaEsami,professors) ;


        SceneManager sceneManager = new SceneManager(engine,stage);


        sceneManager.showMenuScene();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
