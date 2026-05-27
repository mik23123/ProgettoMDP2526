package it.unicam.universita.mdp2526.Personaggi;

import java.util.Objects;

public abstract class    Persona {
    private int eta;
    private String nome;
    private String cognome;



public   Persona(int eta,String nome,String cognome){
   if(eta<0|| nome==null||cognome==null) throw new IllegalArgumentException("i valori non possono essere nulli");
   this.eta=eta;
   this.cognome=cognome;
   this.nome=nome;
}


    public int getEta() {
        return eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona persona)) return false;
        return eta == persona.eta && Objects.equals(nome, persona.nome) && Objects.equals(cognome, persona.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eta, nome, cognome);
    }
}
