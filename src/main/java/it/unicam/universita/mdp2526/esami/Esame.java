package it.unicam.universita.mdp2526.esami;

import it.unicam.universita.mdp2526.Personaggi.Enemy;
import it.unicam.universita.mdp2526.VIta.Stato;

import java.util.List;

public  class Esame {
    private  String nome;

    private Stato studied;

    public Esame(String nome){
        if(nome==null   ) throw new IllegalArgumentException("parametri nulli o sbagliati");
        this.nome=nome;
        this.studied= new Stato(10,"studio");
        this.studied.setStamina(0);
    }
    public void incrementaStudied(int v){

        studied.incrementa(v);
    }


}
