package it.unicam.universita.mdp2526.VIta;

public class Stato {

    private int staminaMax;
    private String name;
    private int stamina  ;
    public Stato(int staminaMax,String name){
        if( staminaMax<0|| name ==null){throw new IllegalArgumentException("I parametri sono sbagliati");
        }
        this.staminaMax=staminaMax;
        this.name = name;
      this.stamina= staminaMax/2;
    }

    public int getStaminaMax() {
        return staminaMax;
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }


    public void increment(int v){
        if((stamina+v)>staminaMax)
            stamina=staminaMax;
    else this.stamina=stamina+v;
    }
    public void decrement(int v){
        if((stamina-v)<0) {this.stamina=0;}
        else
        this.stamina=stamina-v;
    }


    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
