import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
// Cette classe contiens les informations du calendrier
// Cette classe n'est pas finie , il manque les methodes.
// All the Exceptions are handled in this class

// Don't forget that we need to store the days in a file. So , we have to do some file IO.
public class Calendrier {
    private ArrayList<Jour> jours;
    private ArrayList<Periode> periode;
    // Les jours des periodes doivent etre ajoutés a la array Jour[]
    private final Utilisateur utilisateur;

public Calendrier(Utilisateur utilisateur) {
this.utilisateur = utilisateur;
this.jours = new ArrayList<>();
}
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public ArrayList<Jour> getJours() {
        return jours;
    }

    public void setJours(ArrayList<Jour> jours) {
        this.jours = jours;
    }

    public ArrayList<Periode> getPeriode() {
        return periode;
    }

    public void setPeriode(ArrayList<Periode> periode) {
        this.periode = periode;
    }

    public void ajouterPeriode(Periode periode) {
        this.periode.add(periode);
    }

    public void supprimerPeriode(Periode periode) {
        this.periode.remove(periode);
    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public void ajouterJour(Jour jour){
     jours.add(jour);
    }
    public void AjouterTache(Tache tache) {
        //TODO
    }
    public void ajouterCreneau(LocalDateTime debut, LocalDateTime fin) throws ExceptionCollisionHorairesCreneau{
    try {
        // On crée un creneau en récupérant les heures de variables debut et fin
        // La date du jour est contenu dans la variable debut
        // Si le jour existe deja , on ne fait que de l'inserer dans la liste des creneaux de ce jour
        // Si le jour n'existe pas , on le crée , et on l'ajoute a la liste des jours du calendrier

        boolean jourExiste = false;
        Jour jour = null;
        LocalTime tempsDebut = debut.toLocalTime();
        LocalTime tempsFin = fin.toLocalTime();
        for (Jour jourCal : jours) {
            if (jourCal.getDate().equals(debut.toLocalDate())) {
                jourExiste = true;
                jour = jourCal;

            }
        }
        if (!jourExiste) {
            jour = new Jour(debut.toLocalDate(), utilisateur);
            System.out.println("Le jour n'existe pas , il a été créé");
            jours.add(jour);
        }
        jour.ajouterCreneau(tempsDebut,tempsFin);
    }
    catch (ExceptionDureeInvalide e) {
        System.out.println("La durée du créneau est invalide");
        }
    catch (ExceptionDateInvalide e){
        System.out.println("La date du créneau est invalide");
        }
    catch (ExceptionCollisionHorairesCreneau e){
        System.out.println("Le créneau est en collision avec un autre creneau existant");
        }
    catch (Exception e){
        System.out.println(e.getMessage());
        }
    }

    public  void afficher(){
        System.out.println("-------- Affichage du calendrier --------");
        if (jours == null){
            System.out.println("Le calendrier est vide");
        }
        else{
        for (Jour jour : jours){jour.afficher();}
        }
}
}



