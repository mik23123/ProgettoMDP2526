package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Persistency.StateOfGameLoader;
import it.unicam.universita.mdp2526.Persistency.StateOfGameSaver;
import it.unicam.universita.mdp2526.Persistency.GameState;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.StudioEesami.StudyQuiz;
import it.unicam.universita.mdp2526.utility.ScannerTextInput;

import java.util.List;


public class ConsoleEngine extends ScannerTextInput  implements Engine{
    Character character;
    private List<EnemyProfessor> professors;
    private List<Exam> exams;
    public Scenary currentScenary;
    private StateOfGameLoader loader;


    public ConsoleEngine(Character personaggio, List<Exam> examList,List<EnemyProfessor> professors){
        if(personaggio==null) throw  new IllegalArgumentException("professore e personaggio non possono essere nulli");
this.loader = new StateOfGameLoader();
        if(loader.load("C:\\Users\\ASUS\\Desktop\\Progetti\\Esame\\src\\main\\resources\\saving\\save.json")){
            this.character=this.loader.getSaveState().getCharacter();
            this.exams =this.loader.getSaveState().getExam();
        }
        else{ this.character=personaggio;
            this.exams = examList;}
        this.professors=professors;
        currentScenary= Scenary.menu;

    }

    public void start(){
while(currentScenary!= Scenary.exit){

    switch (currentScenary){
        case menu: gestioneMenu();
        break;
        case sleep:
            sleepManagemant(Integer.parseInt(readInput()));
        break;
        case quizScenary:
            studyManagemant(Integer.parseInt(readInput()));
        break;
        case hangOutWithFriend:
            hangOutManagemant(Integer.parseInt(readInput()));
            break;
        case examScenary:
            examManagemant();
            break;
        case save:
            saveManagement();
            break;
        case gameOver:
            gameOverManagemant();

    }

}
    }

        public void gestioneMenu(){
            System.out.println("ciao sono " + character.getName()+" devo passare tutti gli esami in tempo"+ "prova provina        " + exams.get(1).getExamProfessor().getName());
            System.out.println("i miei parametri vitali sono:"+"vita : " +  +character.getLife()+ "su: "+ character.
                    getLifeMax() +"Energia: " +character.getEnergy() +"su : " + character.getEnergyMAx()+ "Stress:  " +character.
                    getStress() +"su" + character.getStressMax());
            System.out.println("inserisci l'azione che vuoi fare: 1 per studiare, 2 per uscire , 3 per dormire, 4 per sfidare il professore in un duello(fare l'esame),5 per uscire, 6 per salvare");
            int n = Integer.parseInt(readInput());



            if(n==1) currentScenary= Scenary.quizScenary;
            else if (n==2) {currentScenary= Scenary.hangOutWithFriend;}
            else if (n==3) {currentScenary= Scenary.sleep;}
            else if (n==4){currentScenary= Scenary.examScenary;}
            else if (n==5) {currentScenary= Scenary.exit;}
            else if(n==6){currentScenary=Scenary.save;}

    }
        public void tornaAlMenu(){
        this.currentScenary= Scenary.menu;
        }
        public void gameOver(){this.currentScenary=Scenary.gameOver;}


          public void readListOfExam(){
              System.out.println("scegli la materia da studiare ");
                int count = 0 ;
                String finalString="";
                        for(Exam e : exams){
                            finalString= finalString+ (e.getName()+" inserisci  " +count + "  per selezionare questo esame " +
                                    "  livello di preparazione esame: "+ e.getQuizStudio().getQuizScore()+" professore : "+ e.getExamProfessor().getName()+" prove esame disponibili : "+"\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista

                            System.out.println((e.getName()+" inserisci  " +count + "  per selezionare questo esame " +
                                    "  livello di preparazione esame: "+ e.getQuizStudio().getQuizScore()+" professore : "+ e.getExamProfessor().getName()+" prove esame disponibili : "+ "\n")); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista

                        count++;
                        }
    }
    public int iterateQuiz(Applicant applicant) {

        while (applicant.getCurrentQuest() != null) {

            System.out.println(applicant.getCurrentQuest().getQuest());

            if (applicant.checkAnswer(readAnswer())) {
                System.out.println("BRAVO");
            } else {
                character.incrementStress(1);
            }
        }

        return applicant.getQuizScore();
    }

public boolean readAnswer( ){
    String answer = String.valueOf(readInput());
 if(!answer.equals("true")&&!answer.equals("false")) throw new IllegalArgumentException("answer can be only true or false");

    if (answer.equals("true")) {// se la risposta è true allora fa il check con true
    return true;}

return false;
}

public void examManagemant(){
    if (character.checkStress()){
        System.out.println("sei troppo stressato ,riposati");
        this.tornaAlMenu();
        return;
    }

    this.readListOfExam();
    int numeroSceltaEsame=Integer.parseInt(readInput());

   EnemyProfessor professor =  this.exams.get(numeroSceltaEsame).getExamProfessor();
    this.iterateQuiz(professor);
    System.out.println("decrement");
    this.tornaAlMenu();
}

            public void studyManagemant(int v ){
                if (character.checkStress()){
                    System.out.println("sei troppo stressato ,riposati");
                    this.tornaAlMenu();

                }

                this.readListOfExam();
             int numeroSceltaEsame=Integer.parseInt(readInput());
        StudyQuiz quiz=  this.exams.get(numeroSceltaEsame).getQuizStudio();

        this.tornaAlMenu();
            }

    @Override
                        public void hangOutManagemant(int v){
                            System.out.println("Quante ore vuoi uscire? lo stress per ora è di  : " +character.getStress() + "su: "+ character.getStressMax()+ " Ricorda, le uscite con gli amici alleviano tanto lo stress," +
                                    "ma allo stesso tempo decrementano la tua energia");
                            int ore = Integer.parseInt(readInput());
                          character.hangOut(ore);

                            this.tornaAlMenu();
                        }




                @Override
                        public void sleepManagemant(int v){
                            System.out.println("Quante ore vuoi dormite? la tua stamina attuale è di : " +character.getEnergy() + "su: "+ character.getEnergyMAx());
                            int ore = Integer.parseInt(readInput());
                            character.sleep(ore);
                            this.tornaAlMenu();
                        }
                        public void saveManagement(){
                            GameState gameState1=new GameState(this.character, exams);
                            StateOfGameSaver s1 = new StateOfGameSaver(gameState1,"C:\\Users\\ASUS\\Desktop\\Progetti\\Esame\\src\\main\\resources\\Saving\\save.json");
                            s1.save();
                            this.tornaAlMenu();
                        }

                      public void gameOverManagemant(){
                    System.out.println("Hai perso");
}
public Character getCharacter(){return character;}
}
