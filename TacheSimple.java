import java.time.Duration;
import java.time.LocalDate;
// Cette tache contiens les informations d'une tache simple
// Cette classe n'est pas encore finie (il manque les méthodes)

public class TacheSimple extends Tache{

    boolean isPeriodique;
    public TacheSimple(String nom, Duration durée, Priorite priorite, LocalDate dateLimite, Categorie categorie, boolean isPeriodique, Etat etat) {
        super(nom, durée, priorite, dateLimite, categorie, etat);
        this.isPeriodique = isPeriodique;
    }

    public boolean isPeriodique() {
        return isPeriodique;
    }

    public void setPeriodique(boolean periodique) {
        isPeriodique = periodique;
    }

    @Override
    boolean isDecomposable() {
        return false;
    }

    public void afficher(){
        super.afficher();
        System.out.println("Is periodique : " + isPeriodique);
    }

}
