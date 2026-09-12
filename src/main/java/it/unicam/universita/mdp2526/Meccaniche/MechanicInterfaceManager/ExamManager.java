package it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager;

import java.util.List;

public interface ExamManager {


    int getNumberOfRemaningExam();
    double getAvgOfExamPassed();

    List<String> readDetailsOfExam();
    List<String> getExams();
}