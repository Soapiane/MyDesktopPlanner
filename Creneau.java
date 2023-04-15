import java.time.LocalDateTime;
import java.util.ArrayList;
// Cette classe contient les informations d'un creaneau
// Cette classe n'est pas encore finie (il manque les méthodes)

public class Creneau implements Decomposable{
    private LocalDateTime debut, fin;
    private boolean libre;
    private TacheSimple tache;
    // Tache simple car un creneau ne peux contenir qu'une seule tache , pas une liste de taches
    // Les taches decomposables sont de base des taches simples fragmentées.

    public Creneau(LocalDateTime debut, LocalDateTime fin) {
        this.debut = debut;
        this.fin = fin;
        this.libre = true;
    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public TacheSimple getTache() {
        return tache;
    }

    public void setTache(TacheSimple tache) {
        this.tache = tache;
    }
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public void decomposer(){
        // TODO
    };
}

