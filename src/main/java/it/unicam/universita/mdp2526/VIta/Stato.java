package it.unicam.universita.mdp2526.VIta;

public class Stato {

    private int staminaMax;
    private String nome;
    private int stamina  ;
    public Stato(int staminaMax,String nome){
        if( staminaMax<0||nome==null){throw new IllegalArgumentException("I parametri sono sbagliati");
        }
        this.staminaMax=staminaMax;
        this.nome=nome  ;
      this.stamina= staminaMax/2;
    }

    public int getStaminaMax() {
        return staminaMax;
    }

    public String getNome() {
        return nome;
    }

    public int getStamina() {
        return stamina;
    }
    public void incrementa(int v){
        if((stamina+v)>staminaMax)
            stamina=staminaMax;
    else this.stamina=stamina+v;
    }
    public void decrementa(int v){
        if((stamina-v)<0) {this.stamina=0;}
        else
        this.stamina=stamina-v;
    }

}
