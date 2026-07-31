package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Persistency.GameState;
import it.unicam.universita.mdp2526.Persistency.StateOfGameLoader;
import it.unicam.universita.mdp2526.Persistency.StateOfGameSaver;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.StudioEesami.StudyQuiz;
import it.unicam.universita.mdp2526.gui.Controller.GameMode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.List;


public class GraphicEngine implements Engine {
    private Character character;
    List<EnemyProfessor> professors;
    List<Exam> exams;
    private Scenary currentScenary;
    StateOfGameLoader loader;
    private Applicant currentQuiz;
    private GameMode mode;
    private boolean gameOver;
    private boolean buttonStudyJustPressed;
    private static final String SAVE_PATH =
            System.getProperty("user.dir") + File.separator + "Saving" + File.separator + "save.json";


    public GraphicEngine(Character personaggio, List<Exam> examList, List<EnemyProfessor> professors) {
        if (personaggio == null)
            throw new IllegalArgumentException("professore e personaggio non possono essere nulli");
        this.loader = new StateOfGameLoader();
        if (loader.load("Saving/save.json")) {
            this.character = this.loader.getSaveState().getCharacter();
            this.exams = this.loader.getSaveState().getExam();
        } else {
            this.character = personaggio;
            this.exams = examList;
        }
        this.professors = professors;
        currentScenary = Scenary.menu;
        this.buttonStudyJustPressed=false;
        this.gameOver=false;
    }

    public void restartGame() {
        this.loader.deleteSaving("Saving/save.json");

    }    // questi sono dei metodi che mi serviranno per impostare se il quiz deve essere di studio o esame.

    // provato a usare modi alternativi con il "riconoscimento" di istanza ma non sono riuscito
    public void setStudyMode() {
        mode = GameMode.STUDY;
    }

    public void setExamMode() {
        mode = GameMode.EXAM;
    }

    public GameMode getMode() {
        return mode;
    }

    // questo fa la lista degli esami con tutte gli "avanzamenti dello studio"
    public String readListOfExam() {
        int count = 0;
        String finalString = "";
        for (Exam e : exams) {
            finalString = finalString + (e.getName()+"  livello di preparazione esame: "
                    + e.getQuizStudio().getQuizScore() + " su 30     professore : " + e.getExamProfessor().getName() + "\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista

            count++;
        }
        return finalString;
    }

    public ObservableList<String> getExams() {
        ObservableList<String> finalList = FXCollections.observableArrayList();
        for (Exam e : exams) {
            finalList.add(e.getName());
        }
        return finalList;
    }


        public void saveManagement() {
          // in pratica crea una cartella di nome Saving e poi va a salvare il file json ogni volta su quella cartella
            File dir = new File(System.getProperty("user.dir") + File.separator + "Saving");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            GameState gameState1 = new GameState(this.character, exams);
            StateOfGameSaver s1 = new StateOfGameSaver(gameState1, SAVE_PATH);
            s1.save();
        }


    public Applicant getCurrentQuiz() {
        return currentQuiz;
    }

    public void examManagemant(int index) {
        EnemyProfessor e1 =this.exams.get(index).getExamProfessor();
        e1.clearQuiz();
        this.currentQuiz = e1;
    }
    public boolean isExamPassed(){
        EnemyProfessor e2 =(EnemyProfessor) currentQuiz;
        return e2.approveExam();
    }

    public Character getCharacter() {
        return character;
    }



    public void studyManagemant(int numeroSceltaEsame) {

        StudyQuiz q1 =this.exams.get(numeroSceltaEsame).getQuizStudio();
        this.currentQuiz = q1;
    }


public boolean  checkgGameOver(){
        if(character.getLife()<=0 ) {return true;}
        return false;
}

// controlla se il personaggio ha la stamina dello stress superiore al 9, se si toglie una vita

    public void hangOutManagemant(int v) {
        character.decrementStress(v);
    }


    public void sleepManagemant(int v) {
character.sleep(v);
    }


    public boolean isButtonStudyJustPressed() {
        return buttonStudyJustPressed;
    }


    public void setButtonStudyJustPressed(boolean buttonStudyJustPressed) {
        this.buttonStudyJustPressed = buttonStudyJustPressed;
    }
public void clearQuiz(int indexOfQuiz){
        this.exams.get(indexOfQuiz).getQuizStudio().clearQuiz();
}
public String universityTranscriptStamp(){
        String s1="";
        for(Exam e1 : exams){
        s1= s1 + e1.toString() + "\n";
}
return s1;
}
    public boolean checkVictory() {

        for (Exam exam : exams) {
            if (!exam.isExamPassed()) {
                return false;
            }
        }

        return true;
    }
}


