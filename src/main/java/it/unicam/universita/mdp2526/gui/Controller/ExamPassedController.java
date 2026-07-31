package it.unicam.universita.mdp2526.gui.Controller;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.gui.SceneManager;

public class ExamPassedController implements  FxController{
   private SceneManager s1;
   private Engine e1;


    public void exit(){
        s1.showMenuScene();
    }

    @Override
    public void setSceneManager(SceneManager s1) {
     this.s1=s1;
    }

    @Override
    public void setEngine(Engine e1) {
this.e1=e1;
    }

    @Override
    public void updateState() {

    }
}
