package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.State;

import java.util.List;

public class EnemyProfessor extends Applicant {
    private  String name;
    private State tried;


    public EnemyProfessor (List<Quest> quests,String name){
        if(quests==null) throw   new IllegalArgumentException("parameter cant be null");
        super(quests);
        this.name=name;
        this.tried = new State(31," Life of professor");
        this.tried.setStamina(4);
    }
    public String getName(){return this.name;}
    // this change for devcrement of life of professor
@Override
    public boolean checkAnswer(boolean risposta){
        if (getCurrentQuest().isAnswer()==risposta) {
            incerementQuizScore(1);
            removeQuest(getQuestIndex());
            this.nextQuest();
            return  true;

        }

        this.nextQuest();
        return false;
    }
public State getTried(){return tried;}
    public void decrementTried(){this.tried.decrement(1);}

    /**
     * this method enable professor to give votation to exam
     * @param vote
     * @return
     */
    public boolean approveExam(int vote){
if(getQuizScore()>18) {
    this.getExam().setTrueExamPassed();
    this.getExam().setVote(vote);
    return true;
}
return false;
}

    @Override
    public String toString() {
        return "EnemyProfessor{" +
                "name='" + name + '\'' +
                ", life=" + tried.getStamina() +
                '}';
    }
}
