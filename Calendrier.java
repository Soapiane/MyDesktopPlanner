import java.util.ArrayList;
// Cette classe contiens les informations du calendrier
// Cette classe n'est pas finie , il manque les methodes.

// Don't forget that we need to store the days in a file. So , we have to do some file IO.
public class Calendrier {
    private ArrayList<Jour> jours;
    private ArrayList<Periode> periode;
    // Les jours des periodes doivent etre ajoutés a la array Jour[]

public Calendrier() {
// This constructor is umpty.
}
    // -------------------------------------- Delimitation Setters/Getters --------------------------------------
    public ArrayList<Jour> getJours() {
        return jours;
    }

    public void setJours(ArrayList<Jour> jours) {
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

    public void ajouterJour(Jour jour){
     jours.add(jour);
    }
    public void AjouterTache(Tache tache) {
        //TODO
    }
}



