package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggi.Character;
import it.unicam.universita.mdp2526.VIta.Stato;

import java.util.List;
import java.util.Random;

public class Enemy implements Applicant {
  private     List<Quest> domande;
    private Quest currentQuest;
    private  String nome;
    private Esame esame;
    private Stato vita;
    private int punteggioFinale;
    private int indiceDomanda;
    private Character personaggio;


    public Enemy(String nome,List<Quest> domande){
        if(domande==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
        this.domande=domande;

        this.indiceDomanda=0;
        this.punteggioFinale=0;
        this.currentQuest=this.prossimaDomanda();

        this.vita= new Stato(31," Vita Del Professore ");
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
