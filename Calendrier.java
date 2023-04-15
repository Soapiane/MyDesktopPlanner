import java.util.ArrayList;
// Cette classe contiens les informations du calendrier
// Cette classe n'est pas finie , il manque les methodes.

// Don't forget that we need to store the days in a file. So , we have to do some file IO.
public class Calendrier {
    private Jour[] jours;
    private ArrayList<Periode> periode;

public Calendrier() {
// This constructor is umpty.
}
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public Jour[] getJours() {
        return jours;
    }

    public void setJours(Jour[] jours) {
        this.jours = jours;
    }

    public ArrayList<Periode> getPeriode() {
        return periode;
    }

    public void setPeriode(ArrayList<Periode> periode) {
        this.periode = periode;
    }

    public void ajouterPeriode(Periode periode) {
        this.periode.add(periode);
    }

    public void supprimerPeriode(Periode periode) {
        this.periode.remove(periode);
    }

    // -------------------------------------- Delimitation Setters/Getters --------------------------------------

}



