package it.unicam.universita.mdp2526.Persistency;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class StateOfGameLoader implements Loader {
    GameState saveState;

 public boolean load(String path){
     Gson gson = new Gson();
   try(FileReader reader = new FileReader(path)){

       this.saveState = gson.fromJson(reader, GameState.class);
       if(saveState==null){return false;}
       System.out.println("load check");
       return true;
   }

   catch(IOException e){
       e.printStackTrace();
       return false;
   }

 }
 public GameState getSaveState(){ return this.saveState;}
}

