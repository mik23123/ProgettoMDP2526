package it.unicam.universita.mdp2526.Meccaniche.mechanicManager;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.GameModeManager;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

public class GraphicGameModeManager implements GameModeManager {
    private GameMode mode;
    @Override
    public void setStudyMode() {
        mode = GameMode.STUDY;
    }

    @Override
    public void setExamMode() {
        mode = GameMode.EXAM;
    }

    @Override
    public GameMode getMode() {
return  this.mode;
    }
}
