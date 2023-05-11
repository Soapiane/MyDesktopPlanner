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
        // Elle se base sur la tache contenue dans le creneau pour déterminer la durée du nouveau creneau
        // Le nouveau creneau est libre , et a la meme heure de fin que l'ancien

        LocalTime nouvelle_fin  = this.debut.plus(tache.getDuree());
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

    public Tache ajouterTache(Tache tache) throws ExceptionCreneauOccupe , ExceptionDureeTacheIncompatible{
        // Si le creneau est libre , on ajoute la tache , sinon , on renvoies une exception
        // Une fois la tache ajoutée , on décompose le creneau en deux , l'un contenant la tache pendant toute sa durée, l'autre libre
        if (this.libre){
            if (tache.isDecomposable()){
                // Tache decomposable , on assigne la tache au créneau , ensuite on la décompose en changeant le nom.
                // On insére la tache dans le créneau , on crée une nouvelle tache qui contiens la durée restante pour completer cette tache et on la return
                // On décompose le crénau en deux , l'un contenant la tache , l'autre libre


                // 1 - Si la durée de la tache est supérieure a celle du créneau, Créer la nouvelle tache :
                if (tache.getDuree().compareTo(Duration.between(getDebut(),getFin())) > 0){
                    // Créer la nouvelle tache
                    TacheDecomposable tacheDec = (TacheDecomposable) tache;
                    Tache nouvelle_tache = new TacheDecomposable(tacheDec.getNom(),tacheDec.getDuree().minus(Duration.between(getDebut(),getFin())),tacheDec.getPriorite(),tacheDec.getDateLimite(),tacheDec.getCategorie(),tacheDec.getEtat(),tacheDec.getNumeroSousTache());
                        // On insere la tache dans le creneau
                    this.tache = tacheDec;
                    this.tache.setDuree(Duration.between(getDebut(),getFin()));
                    this.libre = false;
                    // On décompose le créneau si possible
                    return nouvelle_tache;
                }
                else{
                    // Si la durée de la tache est inférieure a celle du créneau , on insere la tache dans le creneau , on décompose le creneau si possible et on return null
                    this.tache = tache;
                    this.libre = false;
                }

            }
            else{
                // Tache simple
                // On verifie si la durée de la tache est inférieure a la durée du créneau :
                if (tache.getDuree().compareTo(Duration.between(getDebut(),getFin())) < 0){
                    // Si la durée de la tache est inférieure a la durée du créneau , on décompose le creneau en deux
                    // On insere la tache dans le creneau
                    this.tache = tache;
                    this.libre = false;
                    // On décompose le créneau si possible


                }
                else{
                    // Si la durée de la tache est supérieure a la durée du créneau , on lance une exception
                    throw new ExceptionDureeTacheIncompatible("La durée de la tache est supérieure a la durée du creneau");
                }
            }
        }
        else{
            throw new ExceptionCreneauOccupe("Impossible d'ajouter une tache a un creneau occupé");
        }
        this.decomposer();
        return null;
    }

    public void supprimerTache(){
        // On supprime la tache et on la re insere comme tache UNSCHEDULED
        tache.setEtat(Etat.UNSCHEDULED);
        utilisateur.getCalendrier().ajouterTache(tache);
        this.libre = true;
        this.tache = null;
    }
}

