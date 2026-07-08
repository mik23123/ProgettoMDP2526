package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.Character;

import java.util.List;

public class StudyQuiz extends Applicant {

    public StudyQuiz(List<Quest> domande){
        if(domande==null) throw   new IllegalArgumentException("parametri non possono essere nulli");
       super(domande);

    }




}
