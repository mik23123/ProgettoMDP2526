package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Personaggio.Charachter;

public interface CharacterManager {
    Charachter getCharachter();

    boolean hangOutManagemant(int hours);
    void sleepManagemant(int hours);

    boolean checkgGameOver();
    boolean canStartStudyOrExam();
}