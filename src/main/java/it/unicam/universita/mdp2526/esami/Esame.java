package it.unicam.universita.mdp2526.esami;

import it.unicam.universita.mdp2526.Personaggi.Professore;

import java.util.ArrayList;
import java.util.List;

public  class Esame {
    private  String nome;
    private Professore prof;
    private List<Domanda> domande;
    public Esame(String nome,List<Domanda> domande,Professore prof){
        if(nome==null||domande==null||prof==null) throw new IllegalArgumentException("parametri nulli o sbagliati");
        this.domande= domande;
        this.prof=prof;
        this.nome=nome;
    }

}
