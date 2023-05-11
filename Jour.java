import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

// Cette classe contient les informations des jours
// Cette classe n'est pas finie , il manque les methodes

public class Jour implements Serializable {
    private ArrayList<Creneau> creneaux;
    private LocalDate date;

    private final Utilisateur utilisateur;

    private int nbTachesAccomplies;
    private boolean felicitations;

    public Jour(LocalDate date,Utilisateur utilisateur) throws ExceptionDateInvalide{
        if (date == null || date.isBefore(LocalDate.now())){
            // Si la date est null , ou elle est avant la date actuelle , on lance une exception
            throw new ExceptionDateInvalide("La date est invalide");
        }
        this.date = date;
        this.utilisateur = utilisateur;
        this.nbTachesAccomplies = 0;
        this.felicitations = false;
        this.creneaux = new ArrayList<Creneau>();
    }


    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public int getNbTachesAccomplies() {
        return nbTachesAccomplies;
    }

    public void setNbTachesAccomplies(int nbTachesAccomplies) {
        this.nbTachesAccomplies = nbTachesAccomplies;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public ArrayList<Creneau> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(ArrayList<Creneau> creneaux) {
        this.creneaux = creneaux;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void ajouterCreneau(Creneau creneau) {
        this.creneaux.add(creneau);
    }

    public void suppCreneau(Creneau creneau) {
        this.creneaux.remove(creneau);
    }
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    // Incremente le nombre de taches accomplies
    public void incTachesAccomplies(){
        nbTachesAccomplies++;
        if (nbTachesAccomplies == utilisateur.getNbMinimalTachesParJour() && !felicitations){
            felicitations = true;
            // TODO : utilisateur.feliciter();
        }   // Si il y'a eu assez de taches accomplies et que l'utilisateur , on le félicite (utile pour l'attribution des badges)

    }

    public void ajouterTache(Tache tache){
            //TODO
    }

    public void ajouterCreneaux(Creneau creneau){
        creneaux.add(creneau);
    }

    public void ajouterCreneau(LocalTime debut, LocalTime fin) throws ExceptionCollisionHorairesCreneau,ExceptionDateInvalide,ExceptionDureeInvalide{
        // Permets d'ajouter un creneau a un jour.
        // On verifie si la date est valide
        if(date == null || date.isBefore(LocalDate.now())){
            throw new ExceptionDateInvalide("La date est invalide");
        }
        for (Creneau creneau : creneaux) {
            // On teste si il y'a collision avec un creneau existant , si oui , on renvoies une exception CollisionHorairesCreneau
            if (timeCollision(creneau.getDebut(),creneau.getFin(),debut) || timeCollision(creneau.getDebut(),creneau.getFin(),fin) || creneau.getDebut().compareTo(debut) == 0){
                throw new ExceptionCollisionHorairesCreneau("Il y'a une collision horaire avec un creneau existant");
            }
        }
        // On peux donc creer ce creneau.
        Creneau creneau = new Creneau(debut, fin, this, utilisateur);
        creneaux.add(creneau);
    }

    public void afficher(){
        System.out.println("---------------- Affichage journée ----------------");
        System.out.println("Date : " + date);
        System.out.println("Nombre de taches accomplies : " + nbTachesAccomplies);
        for (Creneau creneau : creneaux) {
            creneau.afficher();
        }
        System.out.println("---------------------------------------------------");
    }


    public static boolean timeCollision(LocalTime startTime, LocalTime endTime, LocalTime currentTime) {
        // Cette fonction retourne vrai si currentTime est compris entre startTime et endTime
        return currentTime.isAfter(startTime) && currentTime.isBefore(endTime);
    }
}
