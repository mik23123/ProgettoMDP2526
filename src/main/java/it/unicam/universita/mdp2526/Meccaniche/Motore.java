package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Personaggi.Character;
import it.unicam.universita.mdp2526.StudioEesami.Enemy;
import it.unicam.universita.mdp2526.StudioEesami.Esame;
import it.unicam.universita.mdp2526.utility.ScannerTextInput;

import java.util.List;



public class Motore extends ScannerTextInput {
    Character character;
    List<Enemy> professors;
    List<Esame> exams;
    public Scenari currentScenary;


    public Motore(Character personaggio,List<Esame> examList,List<Enemy> professorList){
        if(personaggio==null) throw  new IllegalArgumentException("professore e personaggio non possono essere nulli");
        this.character=personaggio;
        this.professors=professorList;
        this.exams= examList;
        currentScenary=Scenari.Menu;


    }

    public void start(){
while(currentScenary!=Scenari.exit){

    switch (currentScenary){
        case Menu :gestioneMenu();
        break;
        case sleep:gestioneDormita();
        break;
        case QuizScenary:gestioneStudio();
        break;
        case hangOutWithFriend:gestioneUscita();
            break;
        case examScenary:
            break;

    }

}
    }

        public void gestioneMenu(){
            System.out.println("ciao sono " + character.getName()+" devo passare tutti gli esami in tempo");
            System.out.println("i miei parametri vitali sono:"+"vita : " +  +character.getLife()+ "su: "+ character.
                    getLifeMax() +"Energia: " +character.getEnergy() +"su : " + character.getEnergyMAx()+ "Stress:  " +character.
                    getStress() +"su" + character.getStressMax());
            System.out.println("inserisci l'azione che vuoi fare: 1 per studiare, 2 per uscire , 3 per dormire, 4 per sfidare il professore in un duello(fare l'esame),5 per uscire");
            int n = Integer.parseInt(readInput());



            if(n==1) currentScenary=Scenari.QuizScenary;
            else if (n==2) {currentScenary=Scenari.hangOutWithFriend;
            } else if (n==3) {currentScenary=Scenari.sleep;
            }
            else if (n==4){currentScenary=Scenari.examScenary;}
            else if (n==5) {currentScenary=Scenari.exit;
            }
        }
        public void tornaAlMenu(){
        this.currentScenary=Scenari.Menu;
        }


          public void listOfExam(){
              System.out.println("scegli la materia da studiare");
                int count = 0 ;
                        for(Esame e : exams){
                            System.out.println(e.getNome()+" inserisci  " +count + "per studiare Questo esame" +
                                    " livello di preparazione esame: "+ e.getStaminaStudiedAttuale()+"\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista
                        count++;
                        }
          }
          public int iterateQuest(int numeroSceltaEsame){
              int conteggio=exams.get(numeroSceltaEsame).getQuizStudio().getDomande().size();
              while(conteggio>0){// il while serve per gestire la sequenza delle domande del quiz
                  System.out.println(exams.get(numeroSceltaEsame).getQuizStudio().getQuestCorrente().getQuest());  // qui prende la domanda
                  String s1 =String.valueOf(readInput());  // prende la risposta

                  if(s1.equals("true"))  exams.get(numeroSceltaEsame).getQuizStudio().checkRisposta(true); // se la risposta è true allora fa il check con true
                  else if (s1.equals("false")) exams.get(numeroSceltaEsame).getQuizStudio().checkRisposta(false);// fa la stessa cosa con il false
                  conteggio--; // ho pensato di creare una variabile che ogni volta prensa la size delle domande. visto che nella classe quiz cancello le domande giuste, il conteggio inizia direttamente dalla size e ogni domanda tolgo 1                }
              }
              return exams.get(numeroSceltaEsame).getQuizStudio().getPunteggioQuiz();
          }
            public void gestioneStudio(){
                if (character.checkStress()){
                    System.out.println("sei troppo stressato ,riposati");
                    return;
                }

//                    System.out.println("scegli la materia da studiare");
//                int count = 0 ;
//                        for(Esame e : exams){
//                            System.out.println(e.getNome()+" inserisci  " +count + "per studiare Questo esame" +
//                                    " livello di preparazione esame: "+ e.getStaminaStudiedAttuale()+"\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista
//                        count++;
//                        } questo verrà trasformato in metodo perchè questo metodo fa troppe cose, scelta esame sarà un metodo apparte


             int numeroSceltaEsame=Integer.parseInt(readInput());


//                        int conteggio=exams.get(numeroSceltaEsame).getQuizStudio().getDomande().size();
//
//                        while(conteggio>0){// il while serve per gestire la sequenza delle domande del quiz
//         System.out.println(exams.get(numeroSceltaEsame).getQuizStudio().getQuestCorrente().getQuest());  // qui prende la domanda
//                            String s1 =String.valueOf(readInput());  // prende la risposta
//
//                            if(s1.equals("true"))  exams.get(numeroSceltaEsame).getQuizStudio().checkRisposta(true); // se la risposta è true allora fa il check con true
//                            else if (s1.equals("false")) exams.get(numeroSceltaEsame).getQuizStudio().checkRisposta(false);// fa la stessa cosa con il false
//                            conteggio--; // ho pensato di creare una variabile che ogni volta prensa la size delle domande. visto che nella classe quiz cancello le domande giuste, il conteggio inizia direttamente dalla size e ogni domanda tolgo 1                }
//
//
//            }tutto questo trasformato in un metodo che itera la domanda e vede se è giusta o no

//                exams.get(numeroSceltaEsame).setStudied((int) (exams.get(numeroSceltaEsame).getQuizStudio().getPunteggioQuiz()/1));// da aggiornare a 2,5 quando creerò 31 domande per esame
                this.exams.get(numeroSceltaEsame).setStudied((int)(this.iterateQuest(numeroSceltaEsame)));
                this.tornaAlMenu();
            }


                        public void gestioneUscita(){
                            System.out.println("Quante ore vuoi uscire? lo stress per ora è di  : " +character.getStress() + "su: "+ character.getStress()+ " Ricorda, le uscite con gli amici alleviano tanto lo stress," +
                                    "ma allo stesso tempo decrementano la tua energia");
                            int ore = Integer.parseInt(readInput());
                          character.esci(ore);

                            this.tornaAlMenu();
                        }





                        public void gestioneDormita(){
                            System.out.println("Quante ore vuoi dormite? la tua stamina attuale è di : " +character.getEnergy() + "su: "+ character.getEnergyMAx());
                            int ore = Integer.parseInt(readInput());
                            character.dormi(ore);
                            this.tornaAlMenu();
                        }


}
