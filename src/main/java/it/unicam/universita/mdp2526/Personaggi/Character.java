package it.unicam.universita.mdp2526.Personaggi;

import it.unicam.universita.mdp2526.VIta.Stato;
import it.unicam.universita.mdp2526.esami.Esame;

import java.util.List;

public class Character {
   String nome;
   String matricola;
    Stato vita ;
    Stato energia;
    Stato stress;
    Stato cibo;
    List<Esame> esami;
    public Character(String nome, List<Esame> esami){
        this.vita= new Stato(15,"Vita");
        this.energia=new Stato(10,"Energia");
        this.stress=new Stato(10,"Stress");
        this.cibo=new Stato(10,"cibo");
        this.esami=esami;
    }

    public void esci(){
        stress.decrementa(1);
    }
    public void dormi(){
            energia.incrementa(1);
    }
    public void mangia(){
        energia.incrementa(1);
        cibo.incrementa(1);
    }
   public void studia(Esame esame)
   {
energia.decrementa(2);
stress.incrementa(1);
esame.incrementaStudied(1);
   }

    public String getNome() {
        return nome;
    }

    public String getMatricola() {
        return matricola;
    }

    public int getVita() {
        return vita.getStamina();
    }

    public int getEnergia() {
        return energia.getStamina();
    }

    public int getStress() {
        return stress.getStamina();
    }



    public int getCibo() {
        return cibo.getStamina();
    }
}
