package it.unicam.universita.mdp2526.Personaggio;

public interface SleepAble {
    public int getEnergyMAx() ;
    public void incrementEnergy(int v);
    public void sleep(int ore);
    public int getEnergy();

}
