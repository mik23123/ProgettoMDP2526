package it.unicam.universita.mdp2526.Personaggi;

import it.unicam.universita.mdp2526.VIta.Stato;

public class Character {
   String nome;
   String matricola;
    Stato vita ;
    Stato energia;
    Stato stress;
    Stato depressione;
    Stato cibo;

    public Character(String nome){
        this.vita= new Stato(15,"Vita");
        this.energia=new Stato(10,"Energia");
        this.stress=new Stato(10,"Stress");
        this.depressione=new Stato(10,"Depressione");
        this.cibo=new Stato(10,"cibo");
    }
    public boolean mangia(){
        energia.incrementa(1);
    }
}
