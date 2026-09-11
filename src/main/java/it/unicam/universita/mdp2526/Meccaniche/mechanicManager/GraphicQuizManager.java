package it.unicam.universita.mdp2526.Meccaniche.mechanicManager;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.QuizManager;
import it.unicam.universita.mdp2526.Personaggio.Hero;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

import java.util.List;

public class GraphicQuizManager implements QuizManager {
    private Applicant currentQuiz;
    private Hero hero;
    private  List<Exam> exams;

    public GraphicQuizManager(List<Exam> exams,Hero hero) {
    if (hero == null) throw new IllegalArgumentException("quiz vuoto");
    this.hero = hero;
    this.exams=exams;
}

    @Override
    public Applicant getCurrentQuiz() {
        return currentQuiz;    }

    @Override
    public boolean checkAnswer(boolean answer) {
         return (getCurrentQuiz().checkAnswer(answer));

    }

    @Override
    public boolean isExamPassed() {
        if (currentQuiz instanceof EnemyProfessor) {
            EnemyProfessor e2 = (EnemyProfessor) currentQuiz;
            return e2.approveExam();
        }
        return false;
    }
    @Override
    public void setCurrentQuiz(Applicant currentQuiz){
    this.currentQuiz=currentQuiz;
    }

    // seleziona tramite indice e modalità quale applicant restituire.
    @Override
    public boolean currentQuizSelector(int index, GameMode mode) {
       Applicant selectedApplicant = this.exams.get(index).getApplicant(mode);
        if(selectedApplicant== null) return  false;
        selectedApplicant.clearQuiz();
setCurrentQuiz(selectedApplicant);
return true;
    }

    @Override
    public void clearQuiz(int indexOfQuiz,GameMode mode) {
        this.exams.get(indexOfQuiz).getApplicant(mode).clearQuiz();
    }
}
