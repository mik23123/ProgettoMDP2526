package it.unicam.universita.mdp2526.gui.GraphicController;

import it.unicam.universita.mdp2526.Meccaniche.Engine;
import it.unicam.universita.mdp2526.gui.SceneManager;

public interface FxController {
public void setSceneManager(SceneManager s1);
public  void setEngine(Engine e1);
public    void updateState();
public void setNotify(String s );
}
