import java.util.HashMap;
// Cette classe est la classe globale du DesktopPlanner
// Cette classe n'est pas finie , il manque les methodes.
public class MyDesktopPlanner {
    private HashMap<String,Utilisateur> utilisateurs;

    public MyDesktopPlanner() {
        // This constructor is umpty.
    }
    public void ajouterUtilisateur(String nom) {
        Utilisateur utilisateur = new Utilisateur(nom);
    }

    public void supprimerUtilisateur(String nom) {
        utilisateurs.remove(nom);
    }

    public Utilisateur authentifierUtilisateur(String nom) {
        return utilisateurs.get(nom);
    }

}
