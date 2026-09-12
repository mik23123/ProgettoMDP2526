package it.unicam.universita.mdp2526.Meccaniche.mechanicManager;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.QuizManager;
import it.unicam.universita.mdp2526.Personaggio.Hero;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.StudioEesami.ExamEvaluator;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

import java.util.List;

public class GraphicQuizManager implements QuizManager {
//    private Applicant currentQuiz;
    private ExamEvaluator examEvaluator;
    private Hero hero;
    private  List<Exam> exams;

    public GraphicQuizManager(List<Exam> exams,Hero hero) {
    if (hero == null) throw new IllegalArgumentException("quiz vuoto");
    this.exams=exams;
    this.hero = hero;
}


    @Override
    public boolean checkAnswer(boolean answer,Applicant applicant) {
         return (applicant.checkAnswer(answer));

    }

    @Override
    public boolean isExamPassed(ExamEvaluator examEvaluator) {
        return examEvaluator.approveExam();
    }

    public void setVote(int indexOfExam,ExamEvaluator examEvaluator){
    System.out.println(examEvaluator.getVotationOfExam());
        this.exams.get(indexOfExam).setVote(examEvaluator.getVotationOfExam());
    }

    @Override
    public void setExamPAssed(int indexOfExam, ExamEvaluator examEvaluator) {
        this.exams.get(indexOfExam).setTrueExamPassed();
    }


    // seleziona tramite indice e modalità quale applicant restituire.
    @Override
    public Applicant currentQuizSelector(int indexOfExam, GameMode mode) {
       Applicant selectedApplicant = this.exams.get(indexOfExam).getApplicant(mode);
        if(selectedApplicant== null) throw new IllegalArgumentException();
        selectedApplicant.clearQuiz();
return selectedApplicant;

    }

    @Override
    public void clearQuiz(int indexOfQuiz,GameMode mode) {
        this.exams.get(indexOfQuiz).getApplicant(mode).clearQuiz();
    }



    public boolean areQuizFinished(Applicant applicant){
        return applicant.getCurrentQuest()==null;
    }


}
