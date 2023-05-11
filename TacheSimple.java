import java.time.Duration;
import java.time.LocalDate;
// Cette tache contiens les informations d'une tache simple
// Cette classe n'est pas encore finie (il manque les méthodes)

public class TacheSimple extends Tache{
    public TacheSimple(String nom, Duration durée, Priorite priorite, LocalDate dateLimite, Categorie categorie, boolean isPeriodique, Etat etat) {
        super(nom, durée, priorite, dateLimite, categorie, isPeriodique, etat);
    }


    @Override
    boolean isDecomposable() {
        return false;
    }
}
