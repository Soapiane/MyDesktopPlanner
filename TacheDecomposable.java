import java.time.Duration;
import java.time.LocalDate;

public class TacheDecomposable extends Tache implements Decomposable{

    private int numeroSousTache;
    public TacheDecomposable(String nom, Duration durée, Priorite priorite, LocalDate dateLimite, Categorie categorie, Etat etat,int numeroSousTache) {
        super(nom, durée, priorite, dateLimite, categorie, etat);
        this.numeroSousTache = numeroSousTache;
    }

    // Constructeur qui permets de générer une tache décomposable avec un numéro de sous tache par défaut à 1 et UNSCHEDULED
    public TacheDecomposable(String nom, Duration durée, Priorite priorite, LocalDate dateLimite, Categorie categorie) {
        super(nom, durée, priorite, dateLimite, categorie,Etat.UNSCHEDULED);
        this.numeroSousTache = 1;
    }


    // --------------- Getters/Setters ---------------
    public int getNumeroSousTache() {
        return numeroSousTache;
    }

    public void setNumeroSousTache(int numeroSousTache) {
        this.numeroSousTache = numeroSousTache;
    }


    // --------------- Getters/Setters ---------------
    @Override
    boolean isDecomposable() {
        return true;
    }


    public int incNumeroSousTache(){
        return numeroSousTache+1;
    }
    public void decomposer() {
        this.setNom(this.getNom() + Integer.toString(getNumeroSousTache()));
    }


}
