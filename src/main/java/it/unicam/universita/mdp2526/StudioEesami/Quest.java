package it.unicam.universita.mdp2526.StudioEesami;

import java.util.Objects;

public class Quest {

    String quest;
    boolean answer;
    public Quest(String quest, boolean answer){
        if(quest==null ) throw new IllegalArgumentException("parametri sbagliati o nulli");
        this.quest=quest;
        this.answer=answer;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Quest quest1)) return false;
        return answer == quest1.answer && Objects.equals(quest, quest1.quest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quest, answer);
    }
    @Override
    public String toString() {
        return "Quest{" +
                "quest='" + quest + '\'' +
                ", answer=" + answer +
                '}';
    }

    public boolean isAnswer() {
        return this.answer;
    }

    public String getQuest() {
        return this.quest;
    }
}
