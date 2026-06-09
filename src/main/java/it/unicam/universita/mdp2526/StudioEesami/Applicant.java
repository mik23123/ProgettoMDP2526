package it.unicam.universita.mdp2526.StudioEesami;

public interface Applicant {
    public Quest getQuestCorrente();
    public Quest prossimaDomanda();
    public boolean checkRisposta(boolean Risposta);

}
