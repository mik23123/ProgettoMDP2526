package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

public interface Engine {

    boolean studyManagemant(int v);
    boolean examManagemant(int v);
    boolean hangOutManagemant(int v);
    void sleepManagemant(int v);
    void saveManagement();
    void restartGame();
    public Character getCharacter();
    boolean checkgGameOver();
    boolean canStartStudyOrExam();
    void setStudyMode();
    void setExamMode();
    GameMode getMode();
    boolean isButtonStudyJustPressed();
    void setButtonStudyJustPressed(boolean value);
    Applicant getCurrentQuiz();
    void checkAnswer(boolean answer);
    boolean isExamPassed();
    void clearQuiz(int indexOfQuiz);
    boolean checkVictory();
    int getNumberOfRemaningExam();
    double getAvgOfExamPassed();
    String readListOfExam();


}
