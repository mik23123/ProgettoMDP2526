package it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager;

import it.unicam.universita.mdp2526.StudioEesami.Exam;

import java.util.List;

public interface ExamManager {


    int getNumberOfRemaningExam();
    double getAvgOfExamPassed();

    String readListOfExam();
    List<String> getExams();
}