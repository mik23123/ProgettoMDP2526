package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggi.Character;

import java.util.List;
import java.util.Random;

public class Quiz implements Applicant {
   private   List<Quest> domande;
    private Quest questCorrente;
    private Esame esame;
    private int punteggioFinale;
    private int indiceDomanda;
    private Character personaggio;

    public Quiz(List<Quest> domande){
        if(domande==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
        this.domande=domande;
        this.indiceDomanda=0;
        this.punteggioFinale=0;
        questCorrente=this.prossimaDomanda();
    }

    public List<Quest> getDomande() {
        return domande;
    }

    public Esame getEsame() {
        return esame;
    }

    public int getPunteggioFinale() {
        return punteggioFinale;
    }

    public int getIndiceDomanda() {
        return indiceDomanda;
    }

    public Character getPersonaggio() {
        return personaggio;
    }

    @Override
    public Quest prossimaDomanda(){
        Random randomer= new Random();
        int index= randomer.nextInt(domande.size()); // in pratica questo metodo estrae random una domanda MA LA ELIMINA PER NON FARE LA STESSA DOMANDA NEL QUIZ
        Quest questFinale = domande.get(index);
        this.questCorrente = questFinale;
        this.indiceDomanda=index;
        return questFinale;
    }
    public void rimuoviDomanda(int index){
        domande.remove(index);
    }

    @Override
    public boolean checkRisposta(boolean risposta){
if (questCorrente.isAnswer()==risposta) {
    punteggioFinale=punteggioFinale+1;
    rimuoviDomanda(indiceDomanda);
    this.prossimaDomanda();
    return  true;}

this.prossimaDomanda();
return false;
    }

public Quest getQuestCorrente(){
        return questCorrente;
}


}
