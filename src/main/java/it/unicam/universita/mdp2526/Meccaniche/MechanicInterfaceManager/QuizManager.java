package it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager;

import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.ExamEvaluator;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

public interface QuizManager {



    boolean checkAnswer(boolean answer,Applicant applicant);

    boolean isExamPassed(ExamEvaluator examEvaluator);


    Applicant currentQuizSelector(int indexOfQuiz, GameMode mode);

    void clearQuiz(int indexOfQuiz,GameMode mode);

    void setVote(int index,ExamEvaluator examEvaluator);
    boolean areQuizFinished(Applicant applicant);
    public void setExamPAssed(int indexOfExam,ExamEvaluator examEvaluator);
}
