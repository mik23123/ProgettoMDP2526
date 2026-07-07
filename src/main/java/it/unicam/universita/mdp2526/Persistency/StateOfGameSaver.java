package it.unicam.universita.mdp2526.Persistency;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class StateOfGameSaver implements Saver{
    private final GameState stateOfGame;
    private String path;
public StateOfGameSaver(GameState stateOfGame, String path){
this.stateOfGame=stateOfGame;
this.path=path;
}
public void save(){
    Gson gson = new Gson();

    try (FileWriter writer = new FileWriter(path)) {
        gson.toJson(this.stateOfGame, writer);
        System.out.println("check salvataggio");
    }
    catch(IOException e){
        e.printStackTrace();
    }
}

}
