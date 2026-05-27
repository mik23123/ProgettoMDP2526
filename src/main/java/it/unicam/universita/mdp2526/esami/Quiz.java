package it.unicam.universita.mdp2526.esami;

import java.net.UnixDomainSocketAddress;
import java.util.List;
import java.util.Random;

public class Quiz implements Richiedente{
    List<Domanda> domande;
    Domanda domandaCorrente;

@Override
    public Domanda prossimaDomanda(){
        Random randomer= new Random();

        int index= randomer.nextInt(domande.size()); // in pratica questo metodo estrae random una domanda MA LA ELIMINA PER NON FARE LA STESSA DOMANDA NEL QUIZ
        Domanda domandaFinale= domande.get(index);
        Domanda d1= new Domanda(null,false);
        for(int i = 0 ; i<index;i++){
            d1=domande.get(i);
        }
        domande.remove(d1);
        domandaCorrente=domandaFinale;
        return domandaFinale;
    }

    @Override
    public boolean checkRisposta(boolean risposta){
if (domandaCorrente.isRisposta()==risposta) return  true;
return false;
    }

}
