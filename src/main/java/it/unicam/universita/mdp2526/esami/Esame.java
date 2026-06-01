package it.unicam.universita.mdp2526.esami;

import it.unicam.universita.mdp2526.Personaggi.Enemy;

import java.util.List;

public  class Esame {
    private  String nome;
    private Enemy prof;
    private List<Quest> domande;
    public Esame(String nome, List<Quest> domande, Enemy prof){
        if(nome==null||domande==null||prof==null) throw new IllegalArgumentException("parametri nulli o sbagliati");
        this.domande= domande;
        this.prof=prof;
        this.nome=nome;
    }

}
