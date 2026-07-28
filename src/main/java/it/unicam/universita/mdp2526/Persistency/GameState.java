package it.unicam.universita.mdp2526.Persistency;

import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.Exam;

import java.util.List;

public class GameState {
   private   Character character ;
    private  List<Exam> listOfExam;
    public GameState(Character character,List<Exam> listOfExam){
        this.character=character;
        this.listOfExam=listOfExam;
    }
public Character getCharacter(){
        return this.character;
}
public List<Exam> getExam(){
        return this.listOfExam;
}

}
