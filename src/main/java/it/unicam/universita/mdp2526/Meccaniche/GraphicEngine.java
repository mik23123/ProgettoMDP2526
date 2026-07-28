package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Persistency.GameState;
import it.unicam.universita.mdp2526.Persistency.StateOfGameLoader;
import it.unicam.universita.mdp2526.Persistency.StateOfGameSaver;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.gui.Controller.GameMode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;


public class GraphicEngine implements Engine {
    private Character character;
    List<EnemyProfessor> professors;
    List<Exam> exams;
    private Scenary currentScenary;
    StateOfGameLoader loader;
    private Applicant currentQuiz;
    private GameMode mode;


    public GraphicEngine(Character personaggio, List<Exam> examList, List<EnemyProfessor> professors) {
        if (personaggio == null)
            throw new IllegalArgumentException("professore e personaggio non possono essere nulli");
        this.loader = new StateOfGameLoader();
        if (loader.load("C:\\Users\\ASUS\\Desktop\\Progetti\\Esame\\src\\main\\resources\\saving\\save.json")) {
            this.character = this.loader.getSaveState().getCharacter();
            this.exams = this.loader.getSaveState().getExam();
        } else {
            this.character = personaggio;
            this.exams = examList;
        }
        this.professors = professors;
        currentScenary = Scenary.menu;

    }

    public void restartGame() {
        this.loader.deleteSaving();

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
        System.out.println("scegli la materia da studiare ");
        int count = 0;
        String finalString = "";
        for (Exam e : exams) {
            System.out.println(e.getName() +
                    "  livello di preparazione esame: " + e.getQuizStudio().getQuizScore() + " professore : " + e.getExamProfessor().getName() + " prove esame disponibili : " + e.getExamProfessor().getTried().getStamina()); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista
            finalString = finalString + (e.getName() + " inserisci  " + count + "  per selezionare questo esame " +
                    "  livello di preparazione esame: " + e.getQuizStudio().getQuizScore() + " professore : " + e.getExamProfessor().getName() + " prove esame disponibili : " + e.getExamProfessor().getTried().getStamina() + "\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista

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
    public void setApplicant(Applicant applicant) {
        currentQuiz = applicant;
    }


    public void saveManagement() {
        GameState gameState1 = new GameState(this.character, exams);
        StateOfGameSaver s1 = new StateOfGameSaver(gameState1, "C:\\Users\\ASUS\\Desktop\\Progetti\\Esame\\src\\main\\resources\\Saving\\save.json");
        s1.save();
    }



    public Applicant getCurrentQuiz() {
        return currentQuiz;
    }

    public void examManagemant(int index) {
        if (character.checkStress()) {

        }
        int numeroSceltaEsame = index;
        this.currentQuiz = this.exams.get(numeroSceltaEsame).getExamProfessor();
    }

    public Character getCharacter() {
        return character;
    }



    public void studyManagemant(int index) {
        if (character.checkStress()) {
        }
        int numeroSceltaEsame = index;
        this.currentQuiz = this.exams.get(numeroSceltaEsame).getQuizStudio();
    }


    public void hangOutManagemant(int v) {
        character.decrementStress(v);
    }


    public void sleepManagemant(int v) {
character.decrementEnergy(v);
    }


}


