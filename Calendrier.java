import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
// Cette classe contiens les informations du calendrier
// Cette classe n'est pas finie , il manque les methodes.
// All the Exceptions are handled in this class

// Don't forget that we need to store the days in a file. So , we have to do some file IO.
public class Calendrier implements Serializable {
    private TreeMap<LocalDate,Jour> jours; // Tree
    private ArrayList<Periode> periode;
    // Les jours des periodes doivent etre ajoutés a la array Jour[].

    private ArrayList<Tache> tachesUnscheduled;
    private final Utilisateur utilisateur;

public Calendrier(Utilisateur utilisateur) {
this.utilisateur = utilisateur;
this.jours = new TreeMap<>();
this.tachesUnscheduled = new ArrayList<>();
this.periode = new ArrayList<>();

}
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public TreeMap<LocalDate,Jour> getJours() {
        return jours;
    }

    public void setJours(TreeMap<LocalDate,Jour> jours) {
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

    public ArrayList<Tache> getTachesUnscheduled() {
        return tachesUnscheduled;
    }

    public void setTachesUnscheduled(ArrayList<Tache> tachesUnscheduled) {
        this.tachesUnscheduled = tachesUnscheduled;
    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public void ajouterJour(LocalDate date) throws ExceptionDateInvalide{
     Jour jour;
     jour = new Jour(date, utilisateur);
     jours.put(date,jour);
    }

    public void ajouterCreneau(LocalDate jourCnreneau , LocalTime tempsDebut, LocalTime tempsFin) throws ExceptionCollisionHorairesCreneau{
    try {
        // On crée un creneau en récupérant les heures de variables debut et fin.
        // La date du jour est contenu dans la variable debut.
        // Si le jour existe deja, on ne fait que de l'inserer dans la liste des creneaux de ce jour.
        // Si le jour n'existe pas, on le crée , et on l'ajoute a la liste des jours du calendrier.

        boolean jourExiste = false;
        Jour jour = null;

        // On parcours le tree et on verifie si le jour existe deja
        for (Jour jourCal : jours.values()){
            if (jourCal.getDate().equals(jourCnreneau)) {
                // Si le jour existe , on l'enregistre
                jourExiste = true;
                jour = jourCal;

            }
        }
        // Sinon , on en crée un nouveau.
        if (!jourExiste) {
            jour = new Jour(jourCnreneau, utilisateur);
            System.out.println("Le jour n'existe pas , il a été créé");
            jours.put(jour.getDate(),jour);
        }

        // Finalement , on ajoute le créneau au jour.
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
        for (Jour jour : jours.values()){jour.afficher();}
        }
}




    // Ajouter une nouvelle tache unscheduled
    public void ajouterTache(String nom, Duration duree , Priorite priorite , LocalDate dateLimite , Categorie categorie , boolean isPeriodique,boolean isDecomposable) {
        Tache nouvelleTache;
        if (isDecomposable){
            nouvelleTache = new TacheDecomposable(nom, duree, priorite, dateLimite, categorie, Etat.UNSCHEDULED,0);
        }
        else{
            nouvelleTache = new TacheSimple(nom, duree, priorite, dateLimite, categorie, isPeriodique, Etat.UNSCHEDULED);
        }
        tachesUnscheduled.add(nouvelleTache);
    }

    public void supprimerTache(Tache tache){
        tachesUnscheduled.remove(tache);
    }

    public void afficherTachesUnscheduled(){
        System.out.println("-------- Affichage des taches non planifiées --------");
        if (tachesUnscheduled == null){
            System.out.println("Il n'y a pas de taches non planifiées");
        }
        else{
            for (Tache tache : tachesUnscheduled){tache.afficher();}
        }
    }


    public ArrayList<Jour> getJoursIntervalle(LocalDate debut , LocalDate fin){
    // Cette fonction renvoies une liste contenant tout les jours du calendrier [EXISTANTS] dans l'intervalle indiqué
        return new ArrayList<>(jours.subMap(debut,fin.plusDays(1)).values());
    }

    public ArrayList<Creneau> getCreneauxJour(LocalDate date){
    return jours.get(date).getCreneaux();
    }

    public void ajouterTache(Tache tache){
    tachesUnscheduled.add(tache);
    }


    public void PlannifierTacheManuellement(Tache tache , Creneau creneau) throws ExceptionCreneauOccupe, ExceptionDureeTacheIncompatible {
    // Cette fonction permets de plannifier une tache (c'est a dire l'associer a un créneau au choix)
        // Si cette tache est simple , on l'ajoute simplement au créneau
        // Si cette tache est décomposable , et que la durée du créneau
        // Cette fonction renvoies le créneau dans lequel la tache a été plannifiée.
        creneau.ajouterTache(tache);

    }

    public void plannifierTachePeriode(){
        // Si l'utilisateur ne rentre pas de periode , les taches sont plannifiées dans le jour , puis celui qui suit.
        // Tu dois respecter les dates limites et la priorité , sinon tu informe l'utilisateur que c'est impossible
        // L'etat de la tache doit aussi changer en NOTREALIZED
        //TODO
    }


}



