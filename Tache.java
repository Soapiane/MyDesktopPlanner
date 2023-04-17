// Cette classe contiens les informations d'une tache
// Cette classe n'est pas encore finie (il manque les méthodes)

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Tache {
    private String nom;
    private LocalDateTime durée;
    private Priorité priorité;
    private LocalDate dateLimite;
    private Categorie categorie;
    private boolean isPeriodique;

    private Etat etat;

    public Tache(String nom, LocalDateTime durée, Priorité priorité, LocalDate dateLimite, Categorie categorie) {
        this.nom = nom;
        this.durée = durée;
        this.priorité = priorité;
        this.dateLimite = dateLimite;
        this.categorie = categorie;
        this.etat = Etat.UNSCHEDULED;
        this.isPeriodique = false;      // La tache par defaut n'est pas periodique (lire l'ennoncé)
    }

    public String getNom() {
        return nom;
    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

    public boolean isPeriodique() {
        return isPeriodique;
    }

    public void setPeriodique(boolean periodique) {
        isPeriodique = periodique;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDurée() {
        return durée;
    }

    public void setDurée(LocalDateTime durée) {
        this.durée = durée;
    }

    public Priorité getPriorité() {
        return priorité;
    }

    public void setPriorité(Priorité priorité) {
        this.priorité = priorité;
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


}
