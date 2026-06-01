package it.unicam.universita.mdp2526.Personaggi;

import it.unicam.universita.mdp2526.esami.Quest;
import it.unicam.universita.mdp2526.esami.Applicant;

import java.util.List;
import java.util.Random;

public class Enemy implements Applicant {
  private     List<Quest> domande;
    private Quest currentQuest;
    private  String nome;



    public Enemy(String nome){
        if(this.nome==null) throw new IllegalArgumentException("nome non può essere nullo");
        this.nome=nome;
    }


    @Override
    public Quest prossimaDomanda(){
        Random randomer= new Random();

        int index= randomer.nextInt(domande.size()); // in pratica questo metodo estrae random una domanda MA LA ELIMINA PER NON FARE LA STESSA DOMANDA NEL QUIZ
        Quest finalQuest = domande.get(index);
        Quest d1 = null;
        for(int i = 0 ; i<index;i++){
            d1=domande.get(i);
        }
        domande.remove(d1);
        currentQuest = finalQuest;
        return finalQuest;
    }

    @Override
    public boolean checkRisposta(boolean answer){
        if (currentQuest.isAnswer()==answer) return  true;
        return false;
    }


}
