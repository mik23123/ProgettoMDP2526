package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.State;

import java.util.List;

public class EnemyProfessor extends Applicant implements ExamEvaluator{
    private  String name;
    private State tried;
    private transient Exam exam;

    public EnemyProfessor (List<Quest> quests,String name){
        if(quests==null) throw   new IllegalArgumentException("parameter cant be null");
        super(quests);
        this.name=name;

            }
    public String getName(){return this.name;}

// ho pensato di fare un set in caso il professore cambi materia da insegnare
    public void setExam(Exam exam){
        this.exam=exam;
    }
    // this change for devcrement of life of professor


    public Exam getExam(){
        return this.exam;
    }

    /**
     * this method enable professor to give votation to exam
     * @return
     */
    @Override
    public boolean approveExam() {
        if (getQuizScore() > 18) {
            this.getExam().setTrueExamPassed();
            this.setVote(getQuizScore());
            this.name=name+"  ESAME PASSATO  ";
            return true;
        }
        return false;
    }
    @Override
    public void setVote(int vote){
        this.getExam().setVote(vote);
    }

}