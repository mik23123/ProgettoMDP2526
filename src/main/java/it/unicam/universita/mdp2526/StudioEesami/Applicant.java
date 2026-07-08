package it.unicam.universita.mdp2526.StudioEesami;

import java.util.List;
import java.util.Random;

public abstract class Applicant {

        private List<Quest> quests;
        private Quest currentQuest;
        private Exam exam;
        private int quizScore;
        private int questIndex;

        public Applicant(List<Quest> questList){
            if(questList==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
            this.quests =questList;
            this.questIndex =0;
            this.quizScore =0;
            currentQuest =this.prossimaDomanda();
        }

        public List<Quest> getQuests() {
            return quests;
        }

        public Exam getExam() {
            return exam;
        }

        public int getQuizScore() {
            return quizScore;
        }

        public int getQuestIndex() {
            return questIndex;
        }

    public Quest getCurrentQuest(){
        return currentQuest;
    }
    public void incerementQuizScore(int v ){this.quizScore=quizScore+v;}

        public Quest prossimaDomanda(){
            Random randomer= new Random();
            int index= randomer.nextInt(quests.size()); // in pratica questo metodo estrae random una domanda MA LA ELIMINA PER NON FARE LA STESSA DOMANDA NEL QUIZ
            Quest questFinale = quests.get(index);
            this.currentQuest = questFinale;
            this.questIndex =index;
            return questFinale;
        }
        public void rimuoviDomanda(int index){
            quests.remove(index);
        }


        public boolean checkRisposta(boolean risposta){
            if (currentQuest.isAnswer()==risposta) {
                quizScore = quizScore +1;
                rimuoviDomanda(questIndex);
                this.prossimaDomanda();
                return  true;}

            this.prossimaDomanda();
            return false;
        }




    }





