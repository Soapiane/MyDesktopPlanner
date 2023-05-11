import java.util.HashMap;
// Cette classe est la classe globale du DesktopPlanner
// Cette classe n'est pas finie , il manque les methodes.
public class MyDesktopPlanner {
    private HashMap<String,Utilisateur> utilisateurs;

    public MyDesktopPlanner() {
        utilisateurs = new HashMap<>();
        // This constructor is umpty.
    }
    public void ajouterUtilisateur(String nom)
    {
        if (utilisateurs.containsKey(nom)) {
            System.out.println("ATTENTION : Utilisateur deja existant");
        }
        else{
            Utilisateur utilisateur = new Utilisateur(nom);
            utilisateurs.put(nom,utilisateur);
        }
    }

    public void supprimerUtilisateur(String nom) {
        utilisateurs.remove(nom);
    }

    public Utilisateur authentifierUtilisateur(String nom) {
        Utilisateur u = utilisateurs.get(nom);
        if (u == null) {
            System.out.println("ATTENTION : Utilisateur inexistant , returned null");
        }
        return u;
    }

    public void afficherUtilisateurs() {
        for (String nom : utilisateurs.keySet()) {
            System.out.println(nom);
        }
    }

    public void SupprimerUtilisateur(String nom) {
        utilisateurs.remove(nom);
    }



}
