package it.unicam.universita.mdp2526.Meccaniche.mechanicManager;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.ExamManager;
import it.unicam.universita.mdp2526.StudioEesami.Exam;

import java.util.ArrayList;
import java.util.List;

public class GraphicExamManager implements ExamManager {
public List<Exam> exams;
    public GraphicExamManager(List<Exam> exams){
     this.exams=exams;
    }



    @Override
    public int getNumberOfRemaningExam() {
        int num=0;
        for(Exam e : exams){
            if(!e.isExamPassed()) num++;
        }
        return num;
    }

    @Override
    public double getAvgOfExamPassed() {
        double avg=0.0;
        for(Exam e : exams){
            avg= avg+e.getRisultato().getStamina();
        }
        return avg/exams.size();
    }

    @Override
    public String readListOfExam() {
        int count = 0;
        String finalString = "";
        for (Exam e : exams) {
            finalString = finalString + e.toString(); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista

            count++;
        }
        return finalString;
    }

    @Override
    public List<String> getExams() {
        List<String> finalList = new ArrayList<>();
        for (Exam e : exams) {
            finalList.add(e.getName());
        }
        return finalList;    }
}
