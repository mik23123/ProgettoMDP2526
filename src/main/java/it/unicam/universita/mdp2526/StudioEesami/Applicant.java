package it.unicam.universita.mdp2526.StudioEesami;

import java.util.Collections;
import java.util.List;

public abstract class Applicant {

    private List<Quest> quests;
    private Quest currentQuest;
    private Exam exam;
    private int quizScore;
    private int questIndex;

    public Applicant(List<Quest> questList){
        if(questList==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
        this.quests =questList;
        Collections.shuffle(quests);// mischia le domande appena viene istanziato un applica<nt
        this.questIndex =0;
        this.quizScore =0;
        this.currentQuest=quests.get(questIndex);
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
        System.out.println("quest index" + questIndex);
        return currentQuest;
    }
    public void incerementQuizScore(int v ){this.quizScore=quizScore+v;}

    public Quest nextQuest(){
        System.out.println("chiamata next quest");
       // in pratica questo metodo estrae random una domanda MA LA ELIMINA PER NON FARE LA STESSA DOMANDA NEL QUIZ
        System.out.println(" quest index" + questIndex);

        this.questIndex ++;
        this.currentQuest =  quests.get(questIndex);
        return currentQuest;
    }
    public void removeQuest(int index){
        quests.remove(index);
    }


    public boolean checkAnswer(boolean risposta){
        if (currentQuest.isAnswer()==risposta) {
            quizScore = quizScore +1;
            removeQuest(questIndex);
            this.nextQuest();
            return  true;}

        this.nextQuest();
        return false;
    }




}





