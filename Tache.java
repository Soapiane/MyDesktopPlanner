// Cette classe contiens les informations d'une tache
// Cette classe n'est pas encore finie (il manque les méthodes)

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

public abstract class Tache implements Serializable {
    private String nom;
    private Duration duree;
    private Priorite priorite;
    private LocalDate dateLimite;   // Dans ce projet , la limite est une date et non une heure
    private Categorie categorie;



    private Etat etat;

    public Tache(String nom, Duration duree, Priorite priorite, LocalDate dateLimite, Categorie categorie, Etat etat) {
        this.nom = nom;
        this.duree = duree;
        this.priorite = priorite;
        this.dateLimite = dateLimite;
        this.categorie = categorie;
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------



    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    abstract boolean isDecomposable();  // Retourne vrai si la tache est décomposable , faux sinon

    // Cette méthode affiche les informations d'une tache
    public  void afficher(){
        System.out.println("Nom : "+nom);
        System.out.println("Durée : "+duree);
        System.out.println("Priorité : "+ priorite);
        System.out.println("Date limite : "+dateLimite);
        System.out.println("Catégorie : "+categorie);
        System.out.println("Etat : "+etat);
        System.out.println("Est décomposable : "+isDecomposable());
    };



}
