package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.VIta.Stato;

/**
 *
 */
public  class Esame {
    private  String nome;
    private Stato studied;
    private Stato risultato;
    private Quiz quizStudio;
    public Esame(String nome,Quiz quizStudio){
        if(nome==null ) throw new IllegalArgumentException("parametri nulli o sbagliati");
        this.nome=nome;
        this.studied= new Stato(10,"StaminaStudio");
        this.risultato=new Stato(31,"risultatoEsame");
        this.quizStudio=quizStudio;
    }
    public void incrementaStudied(int v){

        studied.incrementa(v);
    }


    public void incrementaRisultatoEsame(int v){

        risultato.incrementa(v);
    }


    public String getNome() {
        return nome;
    }

    public Stato getRisultato() {
        return risultato;
    }

    public Stato getStudied() {
        return studied;
    }


    /**
     * Questo parametro sarà gestito dalla classe quiz, e rappresenta il livello di preparazione per il singolo esame
     * @return numero che rappresenta il livello di preparazione
     */
    public int getStaminaStudiedAttuale(){
        return studied.getStamina();
    }
    /**
     *
     * @return numero che rappresenta il livello massimo di preparazione che si puo avere
     */
    public int getStaminaStudiedMax(){
        return studied.getStaminaMax();
    }
    /**
     *  Questi parametri saranno gestiti dalla classe enemy che sarebbe il professore che fa le domande.
     * @return Il voto che si sta per prendere
     */
    public int getStaminaRisultatoAttuale(){
        return risultato.getStamina();
    }
    /**
     * @return voto massimo che si può prendere
     */
    public int getStaminaRisultatoMax(){
        return risultato.getStaminaMax();
    }

}
