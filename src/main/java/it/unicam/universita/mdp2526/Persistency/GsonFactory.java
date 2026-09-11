package it.unicam.universita.mdp2526.Persistency;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.StudyQuiz;
public class GsonFactory {
    private GsonFactory() {}

    public static Gson create() {
        RuntimeTypeAdapterFactory<Applicant> adapter = RuntimeTypeAdapterFactory
                .of(Applicant.class, "type")
                .registerSubtype(StudyQuiz.class, "STUDY_QUIZ")
                .registerSubtype(EnemyProfessor.class, "ENEMY_PROFESSOR");

        return new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .setPrettyPrinting()
                .create();
    }
}
