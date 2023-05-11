import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
// Cette classe contient les informations d'un creaneau
// Cette classe n'est pas encore finie (il manque les méthodes)

public class Creneau implements Decomposable , Serializable {
    private LocalTime debut,fin;
    private boolean libre;
    private Tache tache;

    private final Jour jour; // Envoyer the context here is important pour decomposer le creneau
    private final Utilisateur utilisateur;
    // Tache simple car un creneau ne peux contenir qu'une seule tache , pas une liste de taches
    // Les taches decomposables sont de base des taches simples fragmentées.

    public Creneau(LocalTime debut, LocalTime fin, Jour jour, Utilisateur utilisateur) throws ExceptionDureeInvalide{

        // Si la durée d'un creneau est inferieure a user.getTempsMinCreneau() , on lance une exception
        if (Duration.between(debut,fin).compareTo(utilisateur.getTempsMinCreneau()) < 0){
            throw new ExceptionDureeInvalide("La durée du creneau est invalide");
        }
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
        this.libre = true;
        this.utilisateur = utilisateur;
        this.tache = null;


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

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public void decomposer(){
        // Cette méthode change le temps de fin , et insére un nouveau créneau a l'heure de fin de l'ancien
        // Le nouveau creneau est libre , et a la meme heure de fin que l'ancien

        LocalTime nouvelle_fin  = this.debut.plus(tache.getDurée());
        // Verifier si le creneau peut etre décomposé en verifiant la durée du nouveau creneau:
        if (Duration.between(nouvelle_fin,this.fin).compareTo(utilisateur.getTempsMinCreneau()) < 0){
            // Si la durée du nouveau creneau est inferieure a la durée minimale d'un creneau , on ne peut pas le décomposer
            System.out.println("Impossible de décomposer le creneau");
        }
        else {
            LocalTime ancienne_fin = this.fin;
            this.fin = nouvelle_fin;
            try {
                jour.ajouterCreneau(this.fin, ancienne_fin);
            } catch (ExceptionCollisionHorairesCreneau e) {
                throw new RuntimeException(e);
            } catch (ExceptionDateInvalide e) {
                throw new RuntimeException(e);
            } catch (ExceptionDureeInvalide e) {
                throw new RuntimeException(e);
            }
        }
    };

    public void afficher(){
        System.out.println("----- Affichage creneau -----");
        System.out.println("Debut : " + this.debut);
        System.out.println("Fin : " + this.fin);
        System.out.println("Libre : " + this.libre);
        System.out.println("Tache : " + this.tache);
        System.out.println("----- Fin affichage creneau -----");
    }

    public void ajouterTache(Tache tache) throws ExceptionCollisionHorairesCreneau{
        // Si le creneau est libre , on ajoute la tache , sinon , on renvoies une exception
        // Une fois la tache ajoutée , on décompose le creneau en deux , l'un contenant la tache pendant toute sa durée, l'autre libre
        if (this.libre){
            this.tache = tache;
            this.libre = false;
            this.decomposer();
        }
        else{
            throw new ExceptionCollisionHorairesCreneau("Le creneau est deja occupé");
        }
    }

    public void supprimerTache(){
        // On supprime la tache et on la re insere comme tache UNSCHEDULED
        tache.setEtat(Etat.UNSCHEDULED);
        utilisateur.getCalendrier().ajouterTache(tache);
        this.libre = true;
        this.tache = null;


    }
}

