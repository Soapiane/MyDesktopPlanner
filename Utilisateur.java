import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Utilisateur {
    // Cette classe contient les informations d'un utilisateur
    // Cette classe n'est pas encore finie (il manque les méthodes)
    // L'utilisateur est envoyé comme contexte dans les classes Jour et Calendrier
    private String pseudo;
    private float rendementJournalier , rendementPeriode;
    private int nbEncouragements;
    private Jour jourRentable;
    private LocalDateTime[] tempsCategories;
    private Duration tempsMinCreneau;
    private Calendrier calendrier;
    private int[] badges;
    private Projet[] projets;

    private ArrayList<Tache> tachesNonPlanifiees;

    private int nbMinimalTachesParJour;         // Pour l'attribution des badges (lire l'ennoncé)

    public Utilisateur(String pseudo) {
        // Le temps minimal d'un creneau est initialisé a 30 minutes par defaut
        this.pseudo = pseudo;
        this.tempsMinCreneau = Duration.ofMinutes(30);
        this.calendrier = new Calendrier(this);
    }


    // -------------------------------------- Delimitation Setters/Getters --------------------------------------


    public int getNbMinimalTachesParJour() {
        return nbMinimalTachesParJour;
    }

    public void setNbMinimalTachesParJour(int nbMinimalTachesParJour) {
        this.nbMinimalTachesParJour = nbMinimalTachesParJour;
    }

    public Duration getTempsMinCreneau() {
        return tempsMinCreneau;
    }

    public ArrayList<Tache> getTachesNonPlanifiees() {
        return tachesNonPlanifiees;
    }

    public void setTachesNonPlanifiees(ArrayList<Tache> tachesNonPlanifiees) {
        this.tachesNonPlanifiees = tachesNonPlanifiees;
    }

    public void setTempsMinCreneau(Duration tempsMinCreneau) {
        this.tempsMinCreneau = tempsMinCreneau;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setNomUtilisateur(String pseudo) {
        this.pseudo = pseudo;
    }

    public float getRendementJournalier() {
        return rendementJournalier;
    }

    public void setRendementJournalier(float rendementJournalier) {
        this.rendementJournalier = rendementJournalier;
    }

    public float getRendementPeriode() {
        return rendementPeriode;
    }

    public void setRendementPeriode(float rendementPeriode) {
        this.rendementPeriode = rendementPeriode;
    }

    public int getNbEncouragements() {
        return nbEncouragements;
    }

    public void setNbEncouragements(int nbEncouragements) {
        this.nbEncouragements = nbEncouragements;
    }

    public Jour getJourRentable() {
        return jourRentable;
    }

    public void setJourRentable(Jour jourRentable) {
        this.jourRentable = jourRentable;
    }

    public LocalDateTime[] getTempsCategories() {
        return tempsCategories;
    }

    public void setTempsCategories(LocalDateTime[] tempsCategories) {
        this.tempsCategories = tempsCategories;
    }

    public Calendrier getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }

    public int[] getBadges() {
        return badges;
    }

    public void setBadges(int[] badges) {
        this.badges = badges;
    }

    public Projet[] getProjets() {
        return projets;
    }

    public void setProjets(Projet[] projets) {
        this.projets = projets;
    }
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------


    // Remember to send the context in every method
    public void ajouterTache(Tache tache){
        this.tachesNonPlanifiees.add(tache);
    }
    public void ajouterProjet(Projet projet){
        // TODO
    }
    public void ajouterPeriode(Periode periode){
        // TODO
    }
    public void plannifierUneTache(){
        // TODO
    }
    // Cette fonction permets de rajouter les creneaux libres d'une journée
    public void ajouterCreneau(LocalDateTime debut, LocalDateTime fin){
        try {
            calendrier.ajouterCreneau(debut, fin);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void afficher(){
        System.out.println("------- Affichage utilisateur -------");
        System.out.println("Pseudo : " + this.pseudo);
        System.out.println("Rendement journalier : " + this.rendementJournalier);
        System.out.println("Rendement periode : " + this.rendementPeriode);
        System.out.println("Nombre d'encouragements : " + this.nbEncouragements);
        System.out.println("Jour rentable : " + this.jourRentable);
        System.out.println("Temps minimal d'un creneau : " + this.tempsMinCreneau);
        System.out.println("Calendrier : " + this.calendrier);
        System.out.println("Badges : " + this.badges);
        System.out.println("Projets : " + this.projets);
        System.out.println("Taches non planifiees : " + this.tachesNonPlanifiees);
        System.out.println("Temps categories : " + this.tempsCategories);
        System.out.println("Nombre minimal de taches par jour : " + this.nbMinimalTachesParJour);
        calendrier.afficher();
        System.out.println("------- Fin affichage utilisateur -------");
    }

}
