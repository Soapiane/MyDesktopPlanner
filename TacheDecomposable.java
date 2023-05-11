import java.time.Duration;
import java.time.LocalDate;

public class TacheDecomposable extends Tache implements Decomposable{

    public TacheDecomposable(String nom, Duration durée, Priorite priorite, LocalDate dateLimite, Categorie categorie, boolean isPeriodique, Etat etat) {
        super(nom, durée, priorite, dateLimite, categorie, isPeriodique, etat);
    }


    @Override
    boolean isDecomposable() {
        return true;
    }

    @Override
    public void decomposer() {
        // TODO
        // Le nom des sous-taches change.
    }


}
