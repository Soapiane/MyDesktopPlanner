import java.io.Serializable;
import java.util.ArrayList;
// Cette classe contiens les informations d'un projet
// Cette classe n'est pas finie , il manque les methodes.
public class Projet implements Serializable {
    private String nom,description;
    private ArrayList<Tache> taches;

    private final Utilisateur utilisateur;

    public Projet(String nom, String description, ArrayList<Tache> taches,Utilisateur utilisateur) {
        this.nom = nom;
        this.description = description;
        this.taches = taches;
        this.utilisateur = utilisateur;
    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Tache> getTaches() {
        return taches;
    }

    public void setTaches(ArrayList<Tache> taches) {
        this.taches = taches;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public void ajouterTache(Tache tache) {
        taches.add(tache);
    }

}


