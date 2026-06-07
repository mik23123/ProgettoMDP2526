package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.Personaggi.Character;
import it.unicam.universita.mdp2526.StudioEesami.Enemy;
import it.unicam.universita.mdp2526.StudioEesami.Esame;
import it.unicam.universita.mdp2526.utility.ScannerTextInput;

import java.util.ArrayList;
import java.util.List;



public class Motore extends ScannerTextInput {
    Character personaggio;
    List<Enemy> professori;
    List<Esame> esami;
    public Scenari scenarioCorrente;
    public Motore(Character personaggio){
        if(personaggio==null) throw  new IllegalArgumentException("professore e personaggio non possono essere nulli");
        this.personaggio=personaggio;
        this.professori=new ArrayList<Enemy>();
        this.esami= new ArrayList<Esame>();
        scenarioCorrente=Scenari.Menu;


    }

    public void start(){
        System.out.println("ciao sono " + personaggio.getNome()+" devo passare tutti gli esami in tempo");
        System.out.println("inserisci l'azione che vuoi fare: 1 per studiare, 2 per uscire , 3 per dormire, 4 per sfidare il professore in un duello(fare l'esame)");
        int n = Integer.parseInt(readInput());


    }
    public void gestioneStudio(){
        System.out.println("scegli la materia da studiare");
        int count = 0 ;
                for(Esame e : esami){
                    System.out.println(e.getNome()+" Inserisci numero che vedi  qui di fianco per studiare per questo esame " +count +"livello di preparazione esame: "+ e.getStaminaStudiedAttuale()+"\n"); // stampo direttamente tutti gli esami con gli indici vicino. In modo tale che ogni indice sia uguale all'indice della lista
                count++;
                }

     int numeroSceltaEsame=Integer.parseInt(readInput());
        personaggio.studia(esami.get(numeroSceltaEsame));
    }
    public void gestioneDormita(){
        System.out.println("Quante ore vuoi dormite? la tua stamina attuale è di : " +personaggio.getEnergia() + "su: "+ personaggio.getEnergiaMax());
        int ore = Integer.parseInt(readInput());
        personaggio.dormi(ore);
    }


}
