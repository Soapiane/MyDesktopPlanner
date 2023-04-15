import java.time.LocalDateTime;
import java.util.LinkedList;

// Cette classe contient les informations des jours
// Cette classe n'est pas finie , il manque les methodes

public class Jour {
    private LinkedList<Creneau> creneaux;
    private LocalDateTime date;

    public Jour(LocalDateTime date) {
        this.date = date;
    }


    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public LinkedList<Creneau> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(LinkedList<Creneau> creneaux) {
        this.creneaux = creneaux;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void ajouterCreneau(Creneau creneau) {
        this.creneaux.add(creneau);
    }

    public void suppCreneau(Creneau creneau) {
        this.creneaux.remove(creneau);
    }
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
}
