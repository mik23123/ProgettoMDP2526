package it.unicam.universita.mdp2526.StudioEesami;

public class Quest {

    String quest;
    boolean answer;
    public Quest(String quest, boolean answer){
        if(quest==null ) throw new IllegalArgumentException("parametri sbagliati o nulli");
        this.quest=quest;
        this.answer=answer;
    }

    public boolean isAnswer() {
        return this.answer;
    }

    public String getQuest() {
        return this.quest;
    }
}
