package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.StudioEesami.Quest;

import java.util.List;

public interface QuestsGetter {
    public List<Quest> build(String file);
}
