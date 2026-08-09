## University Simulator  🎓

Un simulatore di vita universitaria sviluppato in JavaFX. Vesti i panni di uno studente alle prese con esami, stress ed energia: studia, sostieni gli esami tramite quiz a risposta vero/falso, gestisci le tue risorse e cerca di superare tutti gli esami prima che la vita del personaggio arrivi a zero.


Progetto sviluppato per l'esame di Metodologie di Programmazione — A.A. 2025/2026.

<img width="661" height="426" alt="Screenshot 2026-08-06 103007" src="https://github.com/user-attachments/assets/8f0042ce-57d7-41dd-aebf-5fe12dca56ea" />


## Funzionalità
Il giocatore dispone di tre statistiche principali:

❤️ Vita
⚡ Energia
😵 Stress

Lo stress aumenta rispondendo in maniera errata.

Dormire permette di recuperare energia.

Uscire con gli amici riduce lo stress.

Studiare aumenta la preparazione dell'esame.

Per superare il gioco è necessario superare tutti gli esami

-Gestione del personaggio: statistiche di vita, energia e stress che influenzano le azioni disponibili
-Sistema di studio: quiz preparatori per ogni materia, con punteggio persistente
-Sistema d'esame: alla fine di ogni esame, il professore approva o respinge lo studente in base al punteggio ottenuto
-Conseguenze realistiche: uno stress troppo alto penalizza la vita del personaggio; energia e stress vanno gestiti dormendo o uscendo con gli amici
-Salvataggio e caricamento: la partita viene salvata in locale in formato JSON e ripresa automaticamente al riavvio
-Game Over: la partita termina se la vita del personaggio arriva a zero



Tecnologie utilizzate

- Java (JDK 25)
- JavaFX 25 — interfaccia grafica
- Gradle — build automation
- Gson — serializzazione/deserializzazione dei salvataggi in JSON



Come eseguire il progetto

Requisiti

-JDK 25 (o versione compatibile)
-Git

Avvio
```bash
git clone https://github.com/mik23123/ProgettoMDP2526.git](https://github.com/mik23123/ProgettoMDP2526.git
```
```bash
cd ProgettoMDP2526
```
```bash
gradle run
```

Al primo avvio non è presente alcun salvataggio: il gioco parte da una nuova partita. I salvataggi successivi vengono creati  nella cartella `Saving/` all'interno della root del progetto.


Autore


Michele Grillo — [130479]
Informatica — Università di Camerino


Licenza

Progetto sviluppato a scopo didattico.
