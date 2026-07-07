package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.Character;

import java.util.List;

public class StudyQuiz extends Applicant {
   private   List<Quest> domande;
    private Quest questCorrente;
    private Exam exam;
    private int punteggioQuiz;
    private int indiceDomanda;
    private Character personaggio;

    public StudyQuiz(List<Quest> domande){
        if(domande==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
       super(domande);

    }




}
