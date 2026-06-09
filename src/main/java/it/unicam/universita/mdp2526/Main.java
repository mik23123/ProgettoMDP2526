package it.unicam.universita.mdp2526;
import it.unicam.universita.mdp2526.Meccaniche.*;
import it.unicam.universita.mdp2526.Personaggi.Character;
import it.unicam.universita.mdp2526.StudioEesami.*;
import it.unicam.universita.mdp2526.Meccaniche.*;

import java.util.List;

public class Main {


    static void main(String[] args) {
        it.unicam.universita.mdp2526.Personaggi.Character p1= new Character("Michele");
        JsonQuestGetter j1 = new JsonQuestGetter();
        List<Esame> listaEesami = List.of(
                new Esame("Matematica",new Quiz(j1.build("matematica.json"))),
                new Esame("Programmazione", new Quiz(j1.build("programmazione.json"))),
                new Esame("Architettura degli Elaboratori",new Quiz(j1.build("architettura.json"))),
                new Esame("Fondamenti di Informatica",new Quiz(j1.build("fondamenti.json"))),
                new Esame("Statistica",new Quiz(j1.build("statistica.json"))),
                new Esame("Algoritmi e Strutture Dati",new Quiz(j1.build("algoritmi.json"))),
                new Esame("Reti di Calcolatori",new Quiz(j1.build("reti.json"))),
                new Esame("Sistemi Operativi",new Quiz(j1.build("sistemiOperativi.json"))),
                new Esame("Ricerca Operativa",new Quiz(j1.build("ricercaOperativa.json"))),
                new Esame("Metodologie di Programmazione",new Quiz(j1.build("metodologie.json"))),
                new Esame("Basi di Dati",new Quiz(j1.build("basiDiDati.json"))),
                new Esame("Tesi",new Quiz(j1.build("tesi.json")))
        );

        List<Enemy> professori = List.of(
                new Enemy("Rossi", j1.build("matematica.json")),
                new Enemy("Bianchi",  j1.build("programmazione.json")),
                new Enemy("Verdi",  j1.build("architettura.json")),
                new Enemy("Neri",  j1.build("fondamenti.json")),
                new Enemy("Gallo",  j1.build("statistica.json")),
                new Enemy("Costa",  j1.build("algoritmi.json")),
                new Enemy("Ferrari", j1.build("reti.json")),
                new Enemy("Romano",  j1.build("sistemiOperativi.json")),
                new Enemy("Esposito",  j1.build("ricercaOperativa.json")),
                new Enemy("De Luca",  j1.build("metodologie.json")),
                new Enemy("Greco",  j1.build("basiDiDati.json")),
                new Enemy("Santoro",  j1.build("tesi.json"))
        );

        Motore m1 = new Motore(p1,listaEesami,professori);
        m1.start();
    }

}
