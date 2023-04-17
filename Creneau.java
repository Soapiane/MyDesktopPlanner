import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
// Cette classe contient les informations d'un creaneau
// Cette classe n'est pas encore finie (il manque les méthodes)

public class Creneau implements Decomposable{
    private LocalTime debut,fin;
    private boolean libre;
    private TacheSimple tache;

    private final Utilisateur utilisateur;
    // Tache simple car un creneau ne peux contenir qu'une seule tache , pas une liste de taches
    // Les taches decomposables sont de base des taches simples fragmentées.

    public Creneau(LocalTime debut, LocalTime fin,Utilisateur utilisateur) throws ExceptionDureeInvalide{
        // Si la durée d'un creneau est inferieure a user.getTempsMinCreneau() , on lance une exception
        if (Duration.between(debut,fin).compareTo(utilisateur.getTempsMinCreneau()) < 0){
            throw new ExceptionDureeInvalide("La durée du creneau est invalide");
        }
        this.debut = debut;
        this.fin = fin;
        this.libre = true;
        this.utilisateur = utilisateur;


    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public LocalTime getDebut() {
        return debut;
    }

    public void setDebut(LocalTime debut) {
        this.debut = debut;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
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

    public void afficher(){
        System.out.println("----- Affichage creneau -----");
        System.out.println("Debut : " + this.debut);
        System.out.println("Fin : " + this.fin);
        System.out.println("Libre : " + this.libre);
        System.out.println("Tache : " + this.tache);
        System.out.println("----- Fin affichage creneau -----");
    }
}

