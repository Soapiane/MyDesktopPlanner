import java.time.LocalDate;
import java.time.LocalDateTime;

public class TacheDecomposable extends Tache implements Decomposable{

    public TacheDecomposable(String nom, LocalDateTime durée, Priorité priorité, LocalDate dateLimite, Categorie categorie) {
        super(nom, durée, priorité, dateLimite, categorie);
    }

    @Override
    public void decomposer() {
        // TODO
    }
}
