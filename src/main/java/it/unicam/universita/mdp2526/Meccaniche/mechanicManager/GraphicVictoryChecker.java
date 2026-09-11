package it.unicam.universita.mdp2526.Meccaniche.mechanicManager;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.VictoryChecker;
import it.unicam.universita.mdp2526.StudioEesami.Exam;

import java.util.List;

public class GraphicVictoryChecker implements VictoryChecker {
    private List<Exam> exams;
    public GraphicVictoryChecker(List<Exam> listExam){
        this.exams=listExam;
    }
    public  boolean checkVictory(){
        for (Exam exam : exams) {
            if (!exam.isExamPassed()) {
                return false;
            }
        }

        return true;
    }


}
