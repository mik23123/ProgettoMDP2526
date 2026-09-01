package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Persistency.*;
import it.unicam.universita.mdp2526.Personaggio.Charachter;
import it.unicam.universita.mdp2526.Personaggio.Hero;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.StudioEesami.StudyQuiz;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.List;


public class GraphicEngine implements Engine {
    private Charachter hero;
  private  List<Exam> exams;
   private  Loader <GameState> gameLoader;
    private Applicant currentQuiz;
    private GameMode mode;
    // questo serve per non far premere il bottone di esame/ studia piu volte. se venisse premuto piu volte il personaggio perderebbe vita inumerevole volte
    private boolean buttonStudyJustPressed;
    // serve per il controllo nei controller grafici
    private static final String SAVE_PATH =
            System.getProperty("user.dir") + File.separator + "Saving" + File.separator + "save.json";


    public GraphicEngine(Charachter personaggio, List<Exam> examList, List<EnemyProfessor> professors) {
        if (personaggio == null)
            throw new IllegalArgumentException("professore e personaggio non possono essere nulli");

        this.gameLoader = new StateOfGameLoader();
        if (gameLoader.load(SAVE_PATH)) {
            this.hero = this.gameLoader.getSaveState().getCharacter();
            this.exams = this.gameLoader.getSaveState().getExam();
        } else {
            this.hero = personaggio;
            this.exams = examList;
        }
        this.buttonStudyJustPressed = false;
    }


    // questi sono dei metodi che mi serviranno per impostare se il quiz deve essere di studio o esame.

    // provato a usare modi alternativi con il "riconoscimento" di istanza ma non sono riuscito
    public void setStudyMode() {
        mode = GameMode.STUDY;
    }

    public void setExamMode() {
        mode = GameMode.EXAM;
    }


    public void setButtonStudyJustPressed(boolean buttonStudyJustPressed) {
        this.buttonStudyJustPressed = buttonStudyJustPressed;
    }

    public boolean isButtonStudyJustPressed() {
        return buttonStudyJustPressed;
    }


    public GameMode getMode() {
        return mode;
    }

    public ObservableList<String> getExams() {
        ObservableList<String> finalList = FXCollections.observableArrayList();
        for (Exam e : exams) {
            finalList.add(e.getName());
        }
        return finalList;
    }

    public Applicant getCurrentQuiz() {
        return currentQuiz;
    }

    public boolean isExamPassed() {
        if (currentQuiz instanceof EnemyProfessor) {
            EnemyProfessor e2 = (EnemyProfessor) currentQuiz;
            return e2.approveExam();
        }
        return false;
    }

public boolean canStartStudyOrExam(){
    if (!hero.checkStress()) {
        return true;
    }

    hero.applyPenality();
    checkgGameOver();
    setButtonStudyJustPressed(true);

    return false;
    }


    public Hero getCharachter() {
        return (Hero) hero;
    }


    // questo stampa  la lista degli esami con tutte gli "avanzamenti dello studio"
    public String readListOfExam() {
        int count = 0;
        String finalString = "";
        for (Exam e : exams) {
            finalString = finalString + (e.getName() + "  livello di preparazione esame: "
                    + e.getQuizStudio().getQuizScore() + " su 30     professore : " + e.getExamProfessor().getName() + "\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista

            count++;
        }
        return finalString;
    }


    @Override
    public void saveManagement() {
        // in pratica crea una cartella di nome Saving e poi va a salvare il file json ogni volta su quella cartella
        File dir = new File(System.getProperty("user.dir") + File.separator + "Saving");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        GameState gameState1 = new GameState((Hero) this.hero, exams);
        Saver s1 = new StateOfGameSaver(gameState1, SAVE_PATH);
        s1.save();
    }


    public boolean examManagemant(int index) {
        EnemyProfessor e1 = this.exams.get(index).getExamProfessor();
        if (e1 == null) return false;
        e1.setExam( this.exams.get(index));   // <-- questa riga mancava
        e1.clearQuiz();
        this.currentQuiz = e1;
        return true;
    }


    public boolean studyManagemant(int numeroSceltaEsame) {


        StudyQuiz q1 = this.exams.get(numeroSceltaEsame).getQuizStudio();
        if (q1 == null) return false;

        this.currentQuiz = q1;
        return true;
    }


    public boolean checkgGameOver() {
       if(this.hero.getLife()<=0) return true;

       return false;
    }

// controlla se il personaggio ha la stamina dello stress superiore al 9, se si toglie una vita

    public boolean hangOutManagemant(int v) {
        setButtonStudyJustPressed(false);
        return hero.hangOut(v);
    }


    public void sleepManagemant(int v) {
        hero.sleep(v);
    }


    public void clearQuiz(int indexOfQuiz) {
        this.exams.get(indexOfQuiz).getQuizStudio().clearQuiz();
    }

    public boolean checkVictory() {

        for (Exam exam : exams) {
            if (!exam.isExamPassed()) {
                return false;
            }
        }

        return true;
    }

    public void checkAnswer(boolean answer){
        if(!(getCurrentQuiz().checkAnswer(answer))) this.getCharachter().incrementStress(1);
    }


    public void restartGame() {
        this.gameLoader.deleteSaving(SAVE_PATH);

    }
    public int getNumberOfRemaningExam(){
        int num=0;
        for(Exam e : exams){
            if(!e.isExamPassed()) num++;
        }
        return num;
    }
    public double  getAvgOfExamPassed(){
        double avg=0.0;
        for(Exam e : exams){
        avg= avg+e.getRisultato().getStamina();
        }
        return avg/exams.size();
    }

}

