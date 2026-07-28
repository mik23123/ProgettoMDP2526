package it.unicam.universita.mdp2526.Meccaniche;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import it.unicam.universita.mdp2526.StudioEesami.Quest;
import com.google.gson.reflect.TypeToken;
import it.unicam.universita.mdp2526.utility.ResourceReader;

public class JsonQuestGetter extends ResourceReader implements QuestsGetter {
    @Override
    public List<Quest> build(String Path){
        String json = leggiFile(Path);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Quest>>(){}.getType();// qui raggiro la type erisure, in pratica tutto questo serve perchè la jvm a runtime poi cancella il tipo. In questo modo forziamo il tipo
         List<Quest> list = gson.fromJson(json, listType);
       return list;
        }
    }

