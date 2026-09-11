package it.unicam.universita.mdp2526.Meccaniche.mechanicManager;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.GamePersistenceManager;
import it.unicam.universita.mdp2526.Persistency.*;
import it.unicam.universita.mdp2526.Personaggio.Hero;
import it.unicam.universita.mdp2526.StudioEesami.Exam;

import java.io.File;
import java.util.List;

public class GraphicPersistencyManager  implements GamePersistenceManager {
private String savePath;
GameState gameState;
Hero hero;
List<Exam> exams ;
StateOfGameLoader gameLoader = new StateOfGameLoader();



public GraphicPersistencyManager(Hero hero,List<Exam> exams,String path){
    if(path==null) throw new IllegalArgumentException("path nullo");
    this.savePath=path;
    this.hero=hero;
    this.exams=exams;
}


    @Override
    public void saveGame(Hero hero, List<Exam> exams ) {
        File dir = new File(System.getProperty("user.dir") + File.separator + "Saving");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        GameState gameState1 = new GameState(hero, exams);
        Saver s1 = new StateOfGameSaver(gameState1, savePath);
        s1.save();
    }
    @Override
public GameState loadGame()
{   GameState finalGameState;
    if (existASave()) {
         gameState= new GameState(gameLoader.getSaveState().getHero(),gameLoader.getSaveState().getExam());
 }else {
    gameState= new GameState(hero,exams);}
    return gameState;
}
public boolean existASave(){
    return gameLoader.load(savePath);
}

    @Override
    public void restartGame() {
        this.gameLoader.deleteSaving(savePath);

    }
}
