package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.gui.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public   class QuizController implements FxController {
    @FXML
    private Label  quizLabel;
    @FXML
    private Label  score;
    @FXML
    private Label  notify;
    private SceneManager sceneManager;
    private boolean answer;
    private GraphicEngine engine;

    public QuizController( ) {
    }
    @Override
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager=sceneManager;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine= (GraphicEngine)  engine;

    }

    //questo metodo viene chiamato ogni volta che si preme true. in pratica dai la risposta e il back fa tutto il resto
    public void truePressed(){
        if(!(engine.getCurrentQuiz().checkAnswer(true))); engine.getCharacter().incrementStress(1);
updateState();
    }

    //questo metodo viene chiamato ogni volta che si preme true. in pratica dai la risposta e il back fa tutto il resto
    public void falsePressed(){
        if(!(engine.getCurrentQuiz().checkAnswer(false))); engine.getCharacter().incrementStress(1);
        updateState();
    }

    // questo viene azionato ogni volta che si preme conferma o start quiz. Non fa altro che prendere la current quest e metterla nella riga della domanda
    public void setCurrentQuestLabel(){
        if(engine.getCurrentQuiz().getCurrentQuest()==null)
            notify.setText("Le domande sono finite, esci per tornare al menu principale");
            else
            this.quizLabel.setText(engine.getCurrentQuiz().getCurrentQuest().getQuest());

    }


    public void setScoreLabel(){
        score.setText(Integer.toString(engine.getCurrentQuiz().getQuizScore()));
    }


public void updateState(){
    setCurrentQuestLabel();
        setScoreLabel();
}

public void exit(){            sceneManager.showMenuScene();
}
}
