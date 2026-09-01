package it.unicam.universita.mdp2526.Persistency;

import it.unicam.universita.mdp2526.Personaggio.Charachter;
import it.unicam.universita.mdp2526.Personaggio.Hero;
import it.unicam.universita.mdp2526.StudioEesami.Exam;

import java.util.List;

public class GameState {
   private Hero hero;
    private  List<Exam> listOfExam;
    public GameState(Hero hero, List<Exam> listOfExam){
        this.hero = hero;
        this.listOfExam=listOfExam;
    }
public Charachter getCharacter(){
        return this.hero;
}
public List<Exam> getExam(){
        return this.listOfExam;
}

}
