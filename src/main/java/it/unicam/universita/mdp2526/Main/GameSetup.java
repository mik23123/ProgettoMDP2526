package it.unicam.universita.mdp2526.Main;

import it.unicam.universita.mdp2526.Meccaniche.JsonQuestGetter;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.StudyQuiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Costruisce l'elenco degli esami disponibili nel gioco a partire da una
 * definizione dichiarativa (EXAM_DEFINITIONS).
 * <p>
 * Aggiungere una nuova materia richiede di aggiungere una sola riga a
 * EXAM_DEFINITIONS: nessun'altra parte del codice va toccata (Open/Closed
 * Principle). La classe non conosce JavaFX né la UI: la sua unica
 * responsabilità è costruire il modello di dominio (Single Responsibility
 * Principle), separando questa logica da Main, che si occupa solo di avviare
 * l'applicazione.
 */
public final class GameSetup {

    /**
     * Descrive tutto ciò che serve per costruire un esame: materia,
     * professore e i due file JSON con le rispettive domande.
     */
    private record ExamDefinition(
            String subjectName,
            String professorName,
            String professorQuestPath,
            String studyQuestPath
    ) {
    }

    private static final List<ExamDefinition> EXAM_DEFINITIONS = List.of(
            new ExamDefinition("Programmazione", "Bianchi",
                    "ProfessorQuests/Examprogrammazione.json", "QuizQuests/programmazione.json"),
            new ExamDefinition("Architettura degli Elaboratori", "Verdi",
                    "ProfessorQuests/Examarchitettura.json", "QuizQuests/architettura.json"),
            new ExamDefinition("Fondamenti di Informatica", "Neri",
                    "ProfessorQuests/Examfondamenti.json", "QuizQuests/fondamenti.json"),
            new ExamDefinition("Statistica", "Gallo",
                    "ProfessorQuests/Examstatistica.json", "QuizQuests/statistica.json"),
            new ExamDefinition("Algoritmi e Strutture Dati", "Costa",
                    "ProfessorQuests/Examalgoritmi.json", "QuizQuests/algoritmi.json"),
            new ExamDefinition("Reti di Calcolatori", "Ferrari",
                    "ProfessorQuests/Examreti.json", "QuizQuests/reti.json"),
            new ExamDefinition("Sistemi Operativi", "Romano",
                    "ProfessorQuests/ExamsistemiOperativi.json", "QuizQuests/sistemiOperativi.json"),
            new ExamDefinition("Ricerca Operativa", "Esposito",
                    "ProfessorQuests/ExamricercaOperativa.json", "QuizQuests/ricercaOperativa.json"),
            new ExamDefinition("Metodologie di Programmazione", "De Luca",
                    "ProfessorQuests/Exammetodologie.json", "QuizQuests/metodologie.json"),
            new ExamDefinition("Basi di Dati", "Greco",
                    "ProfessorQuests/ExambasiDiDati.json", "QuizQuests/basiDiDati.json")
    );

    // Impedisce l'istanziazione: la classe espone solo metodi statici di fabbrica.
    private GameSetup() {
    }

    /**
     * Costruisce l'elenco completo degli esami, ciascuno già collegato al
     * proprio professore (in entrambe le direzioni: exam -> professor e
     * professor -> exam).
     *
     * @param questGetter componente che legge le domande dai file JSON
     * @return la lista di tutti gli esami del gioco
     */
    public static List<Exam> buildExams(JsonQuestGetter questGetter) {
        List<Exam> exams = new ArrayList<>();

        for (ExamDefinition def : EXAM_DEFINITIONS) {
            EnemyProfessor professor = new EnemyProfessor(
                    questGetter.build(def.professorQuestPath()),
                    def.professorName()
            );

            Exam exam = new Exam(
                    def.subjectName(),
                    new StudyQuiz(questGetter.build(def.studyQuestPath())),
                    professor
            );

            // Il campo "exam" in EnemyProfessor è transient (per evitare cicli
            // nella serializzazione JSON), quindi va sempre ricollegato qui
            // esplicitamente dopo la costruzione.
            professor.setExam(exam);

            exams.add(exam);
        }

        return exams;
    }

    /**
     * Estrae la lista dei professori dagli esami già costruiti, invece di
     * mantenerne una seconda copia scritta a mano: evita che le due liste
     * possano disallinearsi in futuro (es. un professore aggiunto a una
     * lista e dimenticato nell'altra).
     *
     * @param exams la lista di esami da cui estrarre i professori
     * @return la lista dei professori, uno per ogni esame
     */
    public static List<EnemyProfessor> extractProfessors(List<Exam> exams) {
        List<EnemyProfessor> professors = new ArrayList<>();
        for (Exam exam : exams) {
            professors.add(exam.getExamProfessor());
        }
        return professors;
    }
}
