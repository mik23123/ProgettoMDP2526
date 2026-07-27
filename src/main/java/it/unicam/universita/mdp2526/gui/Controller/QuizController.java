package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.Meccaniche.GraphicEngine;
import it.unicam.universita.mdp2526.Meccaniche.SceneManager;
import javafx.fxml.FXML;

import java.awt.*;

public abstract class QuizController implements FxController {
    @FXML
    private Label  quizLabel;
    @FXML
    private Label  score;
    private SceneManager sceneManager;
    private boolean answer;
    private GraphicEngine engine;

    public QuizController( GraphicEngine engine) {
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
engine.getCurrentQuiz().checkAnswer(true);
updateView();
    }

    //questo metodo viene chiamato ogni volta che si preme true. in pratica dai la risposta e il back fa tutto il resto
    public void falsePressed(){
        engine.getCurrentQuiz().checkAnswer(true);
        updateView();
    }

    // questo viene azionato ogni volta che si preme conferma o start quiz. Non fa altro che prendere la current quest e metterla nella riga della domanda
    public void setCurrentQuestLabel(){
        this.quizLabel.setText(engine.getCurrentQuiz().getCurrentQuest().getQuest());
    }


    public void setScoreLabel(){
        score.setText(Integer.toString(engine.getCurrentQuiz().getQuizScore()));
    }


public void updateView(){
        setCurrentQuestLabel();
        setScoreLabel();
}


}
