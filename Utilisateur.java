import java.time.LocalDateTime;

public class Utilisateur {
    // Cette classe contient les informations d'un utilisateur
    // Cette classe n'est pas encore finie (il manque les méthodes)
    private String pseudo;
    private float rendementJournalier , rendementPeriode;
    private int nbEncouragements;
    private Jour jourRentable;
    private LocalDateTime[] tempsCategories;
    private Calendrier calendrier;
    private int[] badges;
    private Projet[] projets;

    public Utilisateur(String pseudo) {

        this.pseudo = pseudo;
        this.calendrier = new Calendrier();
    }


    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
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
}
