package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.StudioEesami.Applicant;

public interface QuizManager {
    Applicant getCurrentQuiz();

    void checkAnswer(boolean answer);

    boolean isExamPassed();
}
