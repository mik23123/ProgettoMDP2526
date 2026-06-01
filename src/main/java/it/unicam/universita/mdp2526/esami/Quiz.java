package it.unicam.universita.mdp2526.esami;

import java.util.List;
import java.util.Random;

public class Quiz implements Applicant {
    List<Quest> domande;
    Quest questCorrente;

@Override
    public Quest prossimaDomanda(){
        Random randomer= new Random();

        int index= randomer.nextInt(domande.size()); // in pratica questo metodo estrae random una domanda MA LA ELIMINA PER NON FARE LA STESSA DOMANDA NEL QUIZ
        Quest questFinale = domande.get(index);
        Quest d1= new Quest(null,false);
        for(int i = 0 ; i<index;i++){
            d1=domande.get(i);
        }
        domande.remove(d1);
        questCorrente = questFinale;
        return questFinale;
    }

    @Override
    public boolean checkRisposta(boolean risposta){
if (questCorrente.isAnswer()==risposta) return  true;
return false;
    }

}
