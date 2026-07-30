package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.State;

import java.util.List;

public class EnemyProfessor extends Applicant {
    private  String name;
    private State tried;
    private transient Exam exam;

    public EnemyProfessor (List<Quest> quests,String name){
        if(quests==null) throw   new IllegalArgumentException("parameter cant be null");
        super(quests);
        this.name=name;
        this.tried = new State(31," Life of professor");
        this.tried.setStamina(4);
            }
    public String getName(){return this.name;}

// ho pensato di fare un set in caso il professore cambi materia da insegnare
    public void setExam(Exam exam){
        this.exam=exam;
    }
    // this change for devcrement of life of professor
    public State getTried(){return tried;}
    public void decrementTried(){this.tried.decrement(1);}

    public Exam getExam(){
        return this.exam;
    }

    /**
     * this method enable professor to give votation to exam
     * @param vote
     * @return
     */
    public boolean approveExam(int vote) {
        if (getQuizScore() > 18) {
            this.getExam().setTrueExamPassed();
            this.getExam().setVote(vote);
            return true;
        }
        return false;
    }
}