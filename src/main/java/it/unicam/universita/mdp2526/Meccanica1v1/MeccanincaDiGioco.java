package it.unicam.universita.mdp2526.Meccanica1v1;

import it.unicam.universita.mdp2526.Personaggi.Character;
import it.unicam.universita.mdp2526.Personaggi.Enemy;
import it.unicam.universita.mdp2526.esami.Esame;

import java.util.ArrayList;
import java.util.List;

public class MeccanincaDiGioco {
    Character personaggio;
    List<Enemy> professori;
    List<Esame> esami;
    public MeccanincaDiGioco(Character personaggio){
        if(personaggio==null) throw  new IllegalArgumentException("professore e personaggio non possono essere nulli");
        this.personaggio=personaggio;
        this.professori=new ArrayList<Enemy>();
        this.esami= new ArrayList<Esame>();

    }

    public void start(){
        System.out.println("ciao sono " + personaggio.getNome()+" devo passare tutti gli esami in tempo");

    }

}
