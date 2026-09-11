package it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager;

import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

public interface QuizManager {

    Applicant getCurrentQuiz();

    boolean checkAnswer(boolean answer);

    boolean isExamPassed();

    void setCurrentQuiz(Applicant currentQuiz);

    boolean currentQuizSelector(int indexOfQuiz, GameMode mode);

    void clearQuiz(int indexOfQuiz,GameMode mode);

}
