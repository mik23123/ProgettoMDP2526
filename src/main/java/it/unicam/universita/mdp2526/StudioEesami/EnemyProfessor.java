package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.Personaggio.State;

import java.util.List;
import java.util.Random;

public class EnemyProfessor extends Applicant {
  private     List<Quest> domande;
    private Quest currentQuest;
    private  String name;
    private Exam exam;
    private State vita;
    private int punteggioFinale;
    private int indiceDomanda;
    private Character personaggio;


    public EnemyProfessor (List<Quest> quests,String name){
        if(quests==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
        super(quests);
        this.name=name;
        this.vita= new State(31," Vita Del Professore ");
    }

    @Override
    public Quest prossimaDomanda(){
        Random randomer= new Random();
        int index= randomer.nextInt(domande.size()); // in pratica questo metodo estrae random una domanda MA LA ELIMINA PER NON FARE LA STESSA DOMANDA NEL QUIZ
        Quest questFinale = domande.get(index);
        this.currentQuest = questFinale;
        this.indiceDomanda=index;
        return questFinale;
    }
    public void rimuoviDomanda(int index){
        domande.remove(index);
    }

    @Override
    public boolean checkRisposta(boolean risposta){
        if (currentQuest.isAnswer()==risposta) {
            this.vita.decrement(1);
            punteggioFinale=punteggioFinale+1;
            rimuoviDomanda(indiceDomanda);
            this.prossimaDomanda();
            return  true;}

        this.prossimaDomanda();
        System.out.println("ahh capra,sei una capra sei una capra ignorante non sai niente, cambia indirizzo. " +
                "Ci sono molti altri indirizzi come scienze gastronomiche!!!");
        return false;
    }

    public Quest getQuestCorrente(){
        return currentQuest;
    }





}
