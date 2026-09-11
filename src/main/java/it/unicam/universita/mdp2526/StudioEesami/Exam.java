package it.unicam.universita.mdp2526.StudioEesami;

import it.unicam.universita.mdp2526.Personaggio.State;
import it.unicam.universita.mdp2526.gui.GraphicController.GameMode;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 */
public  class Exam {
    private final String name;
    private final State studied;
    private final State risultato;
    private final Map<GameMode,Applicant> applicants;

    private boolean examPassed;
    private int vote;

    public Exam(String nome, StudyQuiz studyQuizstudyQuiz, EnemyProfessor professor) {
        if (nome == null) throw new IllegalArgumentException("parametri nulli o sbagliati");
        this.applicants= new EnumMap<>(GameMode.class);
        this.name = nome;
        this.studied = new State(31, "StaminaStudio");
        this.risultato = new State(31, "risultatoEsame");
        this.studied.setStamina(0);
        this.applicants.put(GameMode.STUDY,studyQuizstudyQuiz);// in pratica tramipe questa map sarò in grado di ricondurmi alla modalità che sta eseguendo il giocatore
        this.applicants.put(GameMode.EXAM,professor);
               this.vote = 0;
        this.examPassed = false;
    }


    public boolean isExamPassed() {
        return examPassed;
    }

    public int getStaminaStudiedAttuale() {
        return studied.getStamina();
    }

    public int getStaminaStudiedMax() {
        return studied.getStaminaMax();
    }


    public int getStaminaRisultatoAttuale() {
        return risultato.getStamina();
    }

    public int getStaminaRisultatoMax() {
        return risultato.getStaminaMax();
    }

    public Applicant getApplicant(GameMode mode){
        return applicants.get(mode);// qui in pratica gli dai la chiave che sarebbe mode e attraverso la chiave ti restituisce un professore o un quiz di quel esame
    }

    public String getName() {
        return name;
    }

    public State getRisultato() {
        return risultato;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public void setTrueExamPassed() {
        this.examPassed = true;
    }

    @Override
    public String toString() {
        EnemyProfessor prof= (EnemyProfessor) applicants.get(GameMode.EXAM);
        return "Exam{" +
                "name='" + name + '\'' +
                ", livello di studio =" + getStaminaStudiedAttuale() +
                "risultato=" + getStaminaRisultatoAttuale() +
                ", professor=" +  prof.getName()+
                ", EsamePassato?=" + isExamPassed() +
                ", vote=" + getRisultato() +
                '}';
    }
}



