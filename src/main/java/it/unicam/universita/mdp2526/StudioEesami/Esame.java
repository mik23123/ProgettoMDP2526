package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.VIta.Stato;

/**
 *
 */
public  class Esame {
    private  final String nome;
    private final Stato studied;
    private final   Stato risultato;
    public    Quiz quizStudio;
    public Esame(String nome,Quiz quizStudio){
        if(nome==null ) throw new IllegalArgumentException("parametri nulli o sbagliati");
        this.nome=nome;
        this.studied= new Stato(31,"StaminaStudio");
        this.risultato=new Stato(31,"risultatoEsame");
        this.quizStudio=quizStudio;
        this.studied.setStamina(0);
    }
//    public void incrementaStudied(int v){
//    if((this.studied.getStamina()+v)>studied.getStaminaMax()) {
//        this.studied.setStamina(this.studied.getStaminaMax());
//    }
//        studied.incrementa(v);
//    }


    public void setStudied(int c){
        this.studied.setStamina(c);    }


    public void incrementaRisultatoEsame(int v){

        risultato.increment(v);
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

public Quiz getQuizStudio(){
        return this.quizStudio;
    }

}
