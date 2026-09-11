package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.*;
import it.unicam.universita.mdp2526.Meccaniche.mechanicManager.*;
import it.unicam.universita.mdp2526.Persistency.*;
import it.unicam.universita.mdp2526.Personaggio.*;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

import java.io.File;
import java.util.List;


public class GraphicEngine implements Engine {
    private Hero hero;
   private  Loader <GameState> gameLoader;
    private Applicant currentQuiz;
    private GameMode mode;
    private List<Exam> examList;


    private VictoryChecker victoryChecker;
    private QuizManager quizManager;
    private JustPressedStateManager pressedButton;
    private GraphicPersistencyManager persistencyManager;
    private ExamManager examManager;
    private GameModeManager gameModeManager;



    public GraphicEngine(Hero personaggio, List<Exam> examList, List<EnemyProfessor> professors) {
        if (personaggio == null)
            throw new IllegalArgumentException("professore e personaggio non possono essere nulli");
        persistencyManager=new GraphicPersistencyManager(personaggio,examList,
                System.getProperty("user.dir") + File.separator + "Saving" + File.separator + "save.json"
);

        if(!persistencyManager.existASave()) {
            this.hero = personaggio;
            this.examList = examList;
        }else{
                this.hero=this.persistencyManager.loadGame().getHero();
                this.examList=this.persistencyManager.loadGame().getExam();}


        this.quizManager=new GraphicQuizManager(this.examList,this.hero);
        this.pressedButton=new GraphicJustPressedManager(false);
        this.victoryChecker= new GraphicVictoryChecker(this.examList);
        this.examManager=new GraphicExamManager(this.examList);
        this.gameModeManager=new GraphicGameModeManager();
    }





public boolean canStartStudyOrExam(){
    if (hero instanceof StressAble stressAble && !stressAble.checkStress()) {
        return true;
    }

    hero.applyPenality();
    checkgGameOver();
    setPressedButton();

    return false;
    }


    public Hero getHero() {
        return  (Hero) hero;
    }


    // questo stampa  la lista degli esami con tutte gli "avanzamenti dello studio"



    public boolean checkgGameOver() {
       if(this.hero.getLife()<=0) return true;

       return false;
    }

// controlla se il personaggio ha la stamina dello stress superiore al 9, se si toglie una vita

    public boolean hangOutManagemant(int v) {
    setNotPressedButton();
    if(hero instanceof SocializeAble socializeAble){
        return socializeAble.hangOut(v);}
        return false;
    }


    public void sleepManagemant(int v) {
        if(hero instanceof SleepAble sleepAble)
        sleepAble.sleep(v);
    }








    // sistemiamo il problema di srp

public void checkAnswer(boolean answer){
       if(!(this.quizManager.checkAnswer(answer)))
this.hero.incrementStress(1);
    }
public boolean isExamPassed(){
        return this.quizManager.isExamPassed();
}
public Applicant getCurrentQuiz(){
        return this.quizManager.getCurrentQuiz();
}

//sistemata la responsabilità pressed button
    public void  setPressedButton() {
        this.pressedButton.setPressed();
    }
    public void setNotPressedButton(){this.pressedButton.setNotPressed();}

    public boolean isJustPressed() {
        return pressedButton.isJustPressed();
    }

    // questo metodo setta il quiz corrente da dare in pasto alla parte "front end"
    public boolean setApplicant(int index,GameMode mode) {
        return  quizManager.currentQuizSelector(index,mode);
    }

    public void restartGame() {
this.persistencyManager.restartGame();
    }
    public void saveGame(){
        this.persistencyManager.saveGame(this.hero,this.examList);
    }

    public int getNumberOfRemaningExam(){
return this.examManager.getNumberOfRemaningExam();
    }
    public double  getAvgOfExamPassed(){
return this.examManager.getAvgOfExamPassed();
    }
    public String readListOfExam() {
return this.examManager.readListOfExam();
    }
    public List<String> getExams() {
        return this.examManager.getExams();
    }


    // questi sono dei metodi che mi serviranno per impostare se il quiz deve essere di studio o esame.

    public void setStudyMode() {
this.gameModeManager.setStudyMode();   }

    public void setExamMode() {
        this.gameModeManager.setExamMode();
    }

    public GameMode getMode() {
        return this.gameModeManager.getMode();
    }
public GameState loadGame(){
        return  this.persistencyManager.loadGame();
}

    public boolean checkVictory() {
        return this.victoryChecker.checkVictory();
    }


}

