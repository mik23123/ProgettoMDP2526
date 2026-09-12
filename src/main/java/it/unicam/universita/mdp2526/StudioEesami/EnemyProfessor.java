package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.State;

import java.util.List;

public class EnemyProfessor extends Applicant implements ExamEvaluator{
    private  String name;


    public EnemyProfessor (List<Quest> quests,String name){
        if(quests==null) throw   new IllegalArgumentException("parameter cant be null");
        super(quests);
        this.name=name;

            }

    public String getName(){return this.name;}





    @Override
    public boolean approveExam() {
        return getQuizScore() >= 18;
    }
    @Override
    public int getVotationOfExam(){
        return getQuizScore();
    }




}