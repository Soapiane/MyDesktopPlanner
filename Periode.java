import java.util.ArrayList;
// Cette classe concerne les periodes que l'utilisateur pourra spécifier sur son calendrier
public class Periode {
    private ArrayList<Jour> jours;
    private final Utilisateur utilisateur;

    public Periode(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public void ajouterJour(Jour jour) {
        this.jours.add(jour);
    }

    public void suppJour(Jour jour) {
        this.jours.remove(jour);
    }

}
