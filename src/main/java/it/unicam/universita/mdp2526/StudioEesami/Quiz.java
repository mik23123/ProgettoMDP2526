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

    public Quiz(List<Quest> domande, Esame esame, Character personaggio){
        if(domande==null|| esame==null|| personaggio==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
        this.domande=domande;
        this.esame=esame;
        this.indiceDomanda=0;
        this.punteggioFinale=0;
        questCorrente=this.prossimaDomanda();
        this.personaggio=personaggio;
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
    return  true;}
this.personaggio.incrementaStress(1);
this.prossimaDomanda();
return false;
    }

public Quest getQuestCorrente(){
        return questCorrente;
}

    /**
     * questo metodo aggiorna il punteggio studio. Incremento di 2.5 perchè è il numero piu ragionevole di crescita. in tutto bisogna fare 8 domande in tutto per arrivare al 31.
     *
     */
    public void aggiornaPunteggio(){double divisore = 2.5;
        esame.incrementaStudied((int)(punteggioFinale/divisore));
}
}
