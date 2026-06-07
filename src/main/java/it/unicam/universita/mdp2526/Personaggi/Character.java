package it.unicam.universita.mdp2526.Personaggi;

import it.unicam.universita.mdp2526.StudioEesami.Quest;
import it.unicam.universita.mdp2526.VIta.Stato;
import it.unicam.universita.mdp2526.StudioEesami.Esame;

import java.util.List;

public class Character {
   String nome;
   String matricola;
    Stato vita ;
    Stato energia;
    Stato stress;
    Stato cibo;

    public Character(String nome){
        this.vita= new Stato(15,"Vita");
        this.energia=new Stato(10,"Energia");
        this.stress=new Stato(10,"Stress");
        this.cibo=new Stato(10,"cibo");

    }

    public void esci(int ore){
        for(int i = 0 ; i<ore;i++) {
            stress.decrementa(1);
        }

    }
    public boolean  dormi(int ore){
        if(getEnergia()>getEnergiaMax()){
            System.out.println("Non puoi dormire, sei già riposato al massimo");
        return false;
        }
                if((getEnergia()+ore)>getEnergiaMax()){
                    throw new IllegalArgumentException("la stamina non può essere superiore a" + this.getEnergiaMax());
                }
                energia.incrementa(ore);
            return true;
    }
    public void mangia(){
        energia.incrementa(1);
        cibo.incrementa(1);
    }

    /**
     * se Il personaggio è troppo stressato non ti fa studiare.
     * @param esame
     * @return vero se il personaggio puo studiare false altrimenti
     */
   public boolean studia(Esame esame)
   {
       if(getStress()>(int) (getStressMax()*0.75)){
           System.out.println("sei troppo stressato, riposati");
           return false;}

           energia.decrementa(4);
           stress.incrementa(1);
           return true;
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
    public void incrementaStress(int v){
        stress.setStamina(stress.getStamina()+v);
    }

    public int getVitaMax() {
        return vita.getStaminaMax();
    }

    public int getEnergiaMax() {
        return energia.getStaminaMax();
    }

    public int getStressMax() {
        return stress.getStaminaMax();
    }



    public int getCibo() {
        return cibo.getStamina();
    }
}
