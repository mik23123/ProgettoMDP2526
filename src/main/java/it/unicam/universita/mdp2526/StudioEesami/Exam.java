package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.State;

/**
 *
 */
public  class Exam {
    private  final String name;
    private final State studied;
    private final State risultato;
    //da decidere se tenere quiz nel json, mi sembra una cosa troppo pesante da tenere
    private  StudyQuiz studyQuiz;
    private boolean examPassed;
    public Exam(String nome, StudyQuiz studyQuizstudyQuiz){
        if(nome==null ) throw new IllegalArgumentException("parametri nulli o sbagliati");
        this.name =nome;
        this.studied= new State(31,"StaminaStudio");
        this.risultato=new State(31,"risultatoEsame");
        this.studyQuiz = studyQuizstudyQuiz;
        this.studied.setStamina(0);
    this.examPassed=false;
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


    public String getName() {
        return name;
    }

    public State getRisultato() {
        return risultato;
    }

    public State getStudied() {
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

public StudyQuiz getQuizStudio(){
        return this.studyQuiz;
    }

}
