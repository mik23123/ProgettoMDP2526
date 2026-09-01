package it.unicam.universita.mdp2526.Personaggio;

public interface StressAble {
    public int getStress();
    public void incrementStress(int v);
    public int getStressMax() ;
    public void decrementStress(int v);
    public boolean checkStress();
}
