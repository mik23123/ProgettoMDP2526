package it.unicam.universita.mdp2526.esami;

public class Domanda {
    String domanda;
    boolean risposta;
    public Domanda(String domanda,boolean risposta){
        if(domanda==null ) throw new IllegalArgumentException("parametri sbagliati o nulli");
        this.domanda=domanda;
        this.risposta=risposta;
    }

    public boolean isRisposta() {
        return risposta;
    }

    public String getDomanda() {
        return domanda;
    }
}
