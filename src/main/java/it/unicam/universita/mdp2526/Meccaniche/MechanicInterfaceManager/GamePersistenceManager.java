package it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager;

import it.unicam.universita.mdp2526.Persistency.GameState;
import it.unicam.universita.mdp2526.Personaggio.Hero;
import it.unicam.universita.mdp2526.StudioEesami.Exam;

import java.util.List;

public interface GamePersistenceManager {
    void saveGame(Hero hero, List<Exam>exams);
    void restartGame();
    GameState loadGame();
    boolean existASave();

}