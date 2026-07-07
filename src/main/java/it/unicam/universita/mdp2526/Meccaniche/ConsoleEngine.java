package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Persistency.StateOfGameLoader;
import it.unicam.universita.mdp2526.Persistency.StateOfGameSaver;
import it.unicam.universita.mdp2526.Persistency.GameState;
import it.unicam.universita.mdp2526.Personaggio.Character;
import it.unicam.universita.mdp2526.StudioEesami.EnemyProfessor;
import it.unicam.universita.mdp2526.StudioEesami.Applicant;
import it.unicam.universita.mdp2526.StudioEesami.Exam;
import it.unicam.universita.mdp2526.utility.ScannerTextInput;

import java.util.List;


public class ConsoleEngine extends ScannerTextInput  implements Engine{
    Character character;
    List<EnemyProfessor> professors;
    List<Exam> exams;
    public Scenary currentScenary;
    StateOfGameLoader loader;


    public ConsoleEngine(Character personaggio, List<Exam> examList, List<EnemyProfessor> professorList){
        if(personaggio==null) throw  new IllegalArgumentException("professore e personaggio non possono essere nulli");
this.loader = new StateOfGameLoader();
        if(loader.load("C:\\Users\\ASUS\\Desktop\\Progetti\\Esame\\src\\main\\resources\\save.json")){
            this.character=this.loader.getSaveState().getCharacter();
            this.exams =this.loader.getSaveState().getExam();
        }
        else{ this.character=personaggio;
            this.exams = examList;}

        this.professors=professorList;
        currentScenary= Scenary.menu;

    }
    @Override
    public void start(){
while(currentScenary!= Scenary.exit){

    switch (currentScenary){
        case menu: gestioneMenu();
        break;
        case sleep:gestioneDormita();
        break;
        case quizScenary:gestioneStudio();
        break;
        case hangOutWithFriend:gestioneUscita();
            break;
        case examScenary:
            break;
        case save:gestioneSalvataggio();
            break;

    }

}
    }
    @Override
        public void gestioneMenu(){
            System.out.println("ciao sono " + character.getName()+" devo passare tutti gli esami in tempo");
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


          public void listOfExam(){
              System.out.println("scegli la materia da studiare");
                int count = 0 ;
                        for(Exam e : exams){
                            System.out.println(e.getName()+" inserisci  " +count + "per studiare Questo esame" +
                                    " livello di preparazione esame: "+ e.getStaminaStudiedAttuale()+"\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista
                        count++;
                        }
          }

          public int iterateQuest(int choosenNumber, Applicant applicant){// questo metodo è stato messo nella classe engine perchè era insensato e
        // inutilmente complicato metterlo in StudyQuiz

              int conteggio= applicant.get(choosenNumber).getQuizStudio().getDomande().size();
              while(conteggio>0){// il while serve per gestire la sequenza delle domande del quiz

                  System.out.println(this.exams.get(choosenNumber).getQuizStudio().getQuestCorrente().getQuest());  // qui prende la domanda
                  String s1 =String.valueOf(readInput());  // prende la risposta

                  // se il giocatore risponde true
                  if(s1.equals("true")){// se la risposta è true allora fa il check con true

                      if (this.exams.get(choosenNumber).getQuizStudio().checkRisposta(true)) System.out.println("BRAVO");

                      else this.character.incrementStress(1);
                  }
                  else if (s1.equals("false")) {// se la risposta è false allora fa il check con false
                      if (this.exams.get(choosenNumber).getQuizStudio().checkRisposta(false))
                          System.out.println("BRAVO");// fa la stessa cosa con il false
                      else this.character.incrementStress(1);
                  }
                  conteggio--; // ho pensato di creare una variabile che ogni volta prensa la size delle domande. visto che nella classe quiz cancello le domande giuste, il conteggio inizia direttamente dalla size e ogni domanda tolgo 1                }
              }
              return this.exams.get(choosenNumber).getQuizStudio().getPunteggioQuiz();
          }


    @Override
            public void gestioneStudio(){
                if (character.checkStress()){
                    System.out.println("sei troppo stressato ,riposati");
                    this.tornaAlMenu();
                    return;
                }

                this.listOfExam();
             int numeroSceltaEsame=Integer.parseInt(readInput());
                this.exams.get(numeroSceltaEsame).setStudied((int)(this.iterateQuest(numeroSceltaEsame)));
                this.tornaAlMenu();
            }

    @Override
                        public void gestioneUscita(){
                            System.out.println("Quante ore vuoi uscire? lo stress per ora è di  : " +character.getStress() + "su: "+ character.getStressMax()+ " Ricorda, le uscite con gli amici alleviano tanto lo stress," +
                                    "ma allo stesso tempo decrementano la tua energia");
                            int ore = Integer.parseInt(readInput());
                          character.esci(ore);

                            this.tornaAlMenu();
                        }




@Override
                        public void gestioneDormita(){
                            System.out.println("Quante ore vuoi dormite? la tua stamina attuale è di : " +character.getEnergy() + "su: "+ character.getEnergyMAx());
                            int ore = Integer.parseInt(readInput());
                            character.sleep(ore);
                            this.tornaAlMenu();
                        }
                        public void gestioneSalvataggio(){
                            GameState gameState1=new GameState(this.character, exams);
                            StateOfGameSaver s1 = new StateOfGameSaver(gameState1,"C:\\Users\\ASUS\\Desktop\\Progetti\\Esame\\src\\main\\resources\\save.json");
                            s1.save();
                            this.tornaAlMenu();
                        }
}
