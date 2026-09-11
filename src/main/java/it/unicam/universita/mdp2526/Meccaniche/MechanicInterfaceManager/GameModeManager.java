package it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager;

import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

public interface GameModeManager {
    void setStudyMode();
    void setExamMode();
    GameMode getMode();
}