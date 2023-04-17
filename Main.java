import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Le but de ce programme est de créer un système de gestion de projets , qui permets de gerer son temps et de suivre son avancement

        MyDesktopPlanner myDesktopPlanner = new MyDesktopPlanner();
        myDesktopPlanner.ajouterUtilisateur("Sofiane");
        myDesktopPlanner.ajouterUtilisateur("Fares");

        myDesktopPlanner.afficherUtilisateurs();

        Utilisateur sofiane = myDesktopPlanner.authentifierUtilisateur("Sofiane");

        // Exemple d'ajout de creneau
        sofiane.ajouterCreneau(LocalDateTime.of(2023, 12, 1, 10, 0), LocalDateTime.of(2023, 12, 1, 10, 25));
        sofiane.ajouterCreneau(LocalDateTime.of(2023, 12, 1, 10, 0), LocalDateTime.of(2023, 12, 1, 12, 0));

        sofiane.afficher();
    }
}