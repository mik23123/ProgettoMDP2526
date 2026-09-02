package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Personaggio.Charachter;
import it.unicam.universita.mdp2526.Personaggio.Hero;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;
public interface Engine
        extends CharacterManager,
        ExamManager,
        QuizManager,
        GameModeManager,
        GamePersistence,JustPressedStateManager{
}