package it.unicam.universita.mdp2526.StudioEesami;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Applicant {

    private List<Quest> quests;
    private final  List<Quest> cleanQuest;
    private Quest currentQuest;
    private int quizScore;
    private int questIndex;


    public Applicant(List<Quest> questList){
        if(questList==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
        this.cleanQuest= new ArrayList<Quest>(questList);
        this.quests =questList;
        Collections.shuffle(quests);// mischia le domande appena viene istanziato un applicant
        this.questIndex =0;
        this.quizScore =0;
        this.currentQuest=quests.get(questIndex);

    }

    public List<Quest> getQuests() {
        return quests;
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


  public void removeQuest(int index){
      System.out.println("rimozione domanda: " + quests.get(index).getQuest() +" index:  "+ index);
      quests.remove(index);
   }



public Quest nextQuest() {
    this.questIndex++;

    if (questIndex >= quests.size()) {
        currentQuest = null;
        return null;
    }

  setCurrentQuest();
    return currentQuest;
}
    public boolean checkAnswer(boolean risposta){
        if(currentQuest==null) return false;
        if (currentQuest.isAnswer() == risposta) {
            quizScore++;
            removeQuest(questIndex);

            // ci sono ancora domande, rimani sullo stesso indice
            if (questIndex < quests.size()) {
                currentQuest = quests.get(questIndex);
            } else {
                // non ci sono più domande, il quiz è terminato
                currentQuest = null;
            }

            return true;
        }

        this.nextQuest();
        return false;
    }
public void setCurrentQuest()
{
    this.currentQuest=getQuests().get(questIndex);
}
    // questo serve per cancellare tutto lo storico delle domande.
    public void clearQuiz(){
        this.quests=cleanQuest;
        this.quizScore=0;
        this.questIndex=0;
        setCurrentQuest();
        System.out.println("checkChiamata");

    }


}





