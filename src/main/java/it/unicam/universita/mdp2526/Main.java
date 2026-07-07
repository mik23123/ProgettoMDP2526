package it.unicam.universita.mdp2526;
import it.unicam.universita.mdp2526.Meccaniche.*;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.*;

import java.util.List;

public class Main {


    static void main(String[] args) {
        it.unicam.universita.mdp2526.Personaggio.Character p1= new Character("Michele");
        JsonQuestGetter j1 = new JsonQuestGetter();
        List<Exam> listaEesami = List.of(
                new Exam("Matematica",new StudyQuiz(j1.build("matematica.json"))),
                new Exam("Programmazione", new StudyQuiz(j1.build("programmazione.json"))),
                new Exam("Architettura degli Elaboratori",new StudyQuiz(j1.build("architettura.json"))),
                new Exam("Fondamenti di Informatica",new StudyQuiz(j1.build("fondamenti.json"))),
                new Exam("Statistica",new StudyQuiz(j1.build("statistica.json"))),
                new Exam("Algoritmi e Strutture Dati",new StudyQuiz(j1.build("algoritmi.json"))),
                new Exam("Reti di Calcolatori",new StudyQuiz(j1.build("reti.json"))),
                new Exam("Sistemi Operativi",new StudyQuiz(j1.build("sistemiOperativi.json"))),
                new Exam("Ricerca Operativa",new StudyQuiz(j1.build("ricercaOperativa.json"))),
                new Exam("Metodologie di Programmazione",new StudyQuiz(j1.build("metodologie.json"))),
                new Exam("Basi di Dati",new StudyQuiz(j1.build("basiDiDati.json"))),
                new Exam("Tesi",new StudyQuiz(j1.build("tesi.json")))
        );

        List<EnemyProfessor> professori = List.of(
                new EnemyProfessor(j1.build("programmazione.json"),"Bianchi",  ),
                new EnemyProfessor( j1.build("architettura.json"),"Verdi"),
                new EnemyProfessor( j1.build("fondamenti.json"),"Neri" ),
                new EnemyProfessor(j1.build("statistica.json"),"Gallo"),
                new EnemyProfessor(  j1.build("algoritmi.json"),"Costa"),
                new EnemyProfessor( j1.build("reti.json"),"Ferrari"),
                new EnemyProfessor( j1.build("sistemiOperativi.json"),"Romano" ),
                new EnemyProfessor( j1.build("ricercaOperativa.json"),"Esposito" ),
                new EnemyProfessor( j1.build("metodologie.json"),"De Luca" ),
                new EnemyProfessor( j1.build("basiDiDati.json"),"Greco" ),
                new EnemyProfessor( j1.build("tesi.json"),"Santoro")
        );

        ConsoleEngine m1 = new ConsoleEngine(p1,listaEesami,professori);
        m1.start();
    }

}
