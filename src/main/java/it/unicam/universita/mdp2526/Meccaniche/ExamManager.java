package it.unicam.universita.mdp2526.Meccaniche;

public interface ExamManager {
    boolean studyManagemant(int index);
    boolean examManagemant(int index);

    void clearQuiz(int indexOfQuiz);

    boolean checkVictory();
    int getNumberOfRemaningExam();
    double getAvgOfExamPassed();

    String readListOfExam();
}