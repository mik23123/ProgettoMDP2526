package it.unicam.universita.mdp2526.Persistency;

public interface Loader <T>{

    public boolean load(String path);
    public void deleteSaving(String path);
    T getSaveState();
}
