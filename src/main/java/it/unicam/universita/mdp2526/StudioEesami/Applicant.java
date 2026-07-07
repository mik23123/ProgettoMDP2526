package it.unicam.universita.mdp2526.StudioEesami;

import java.util.List;
import java.util.Random;

public abstract class Applicant {

        private List<Quest> domande;
        private Quest questCorrente;
        private Exam exam;
        private int punteggioQuiz;
        private int indiceDomanda;

        public Applicant(List<Quest> questList){
            if(questList==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
            this.domande=questList;
            this.indiceDomanda=0;
            this.punteggioQuiz =0;
            questCorrente=this.prossimaDomanda();
        }

        public List<Quest> getDomande() {
            return domande;
        }

        public Exam getEsame() {
            return exam;
        }

        public int getPunteggioQuiz() {
            return punteggioQuiz;
        }

        public int getIndiceDomanda() {
            return indiceDomanda;
        }


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


        public boolean checkRisposta(boolean risposta){
            if (questCorrente.isAnswer()==risposta) {
                punteggioQuiz = punteggioQuiz +1;
                rimuoviDomanda(indiceDomanda);
                this.punteggioQuiz = punteggioQuiz +1;
                this.prossimaDomanda();
                return  true;}

            this.prossimaDomanda();
            return false;
        }

        public Quest getQuestCorrente(){
            return questCorrente;
        }


    }





