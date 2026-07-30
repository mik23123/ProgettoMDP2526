package it.unicam.universita.mdp2526.Persistency;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

 public void deleteSaving(String path){saveState=null;
     FileWriter writer=null;
     try {
          writer = new FileWriter(path);
         writer.write("");
         writer.close();
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
    }
 public GameState getSaveState(){ return this.saveState;}
}

