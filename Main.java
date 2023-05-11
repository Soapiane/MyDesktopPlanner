import java.time.*;

public class Main {
    public static void main(String[] args) {
        // Le but de ce programme est de créer un système de gestion de projets , qui permets de gerer son temps et de suivre son avancement

        MyDesktopPlanner myDesktopPlanner = new MyDesktopPlanner();
        myDesktopPlanner.ajouterUtilisateur("Sofiane");
        myDesktopPlanner.ajouterUtilisateur("Fares");

        myDesktopPlanner.afficherUtilisateurs();

        Utilisateur sofiane = myDesktopPlanner.authentifierUtilisateur("Sofiane");

        Calendrier calendrier = sofiane.getCalendrier();

        // Exemple d'ajout de creneau
        try {
            calendrier.ajouterCreneau(LocalDate.of(2023, 12, 1), LocalTime.of(8, 30),LocalTime.of(10,25));
            calendrier.ajouterCreneau(LocalDate.of(2023, 12, 2), LocalTime.of(10, 30),LocalTime.of(12,25));
            calendrier.ajouterCreneau(LocalDate.of(2023, 12, 3), LocalTime.of(8, 30),LocalTime.of(10,25));
            calendrier.ajouterCreneau(LocalDate.of(2023, 12, 4), LocalTime.of(10, 30),LocalTime.of(12,25));
            calendrier.ajouterCreneau(LocalDate.of(2023, 12, 5), LocalTime.of(8, 30),LocalTime.of(10,25));
            calendrier.ajouterCreneau(LocalDate.of(2023, 12, 6), LocalTime.of(10, 30),LocalTime.of(12,25));

            calendrier.getJoursIntervalle(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 6)).forEach(System.out::println);

        } catch (ExceptionCollisionHorairesCreneau e) {
            throw new RuntimeException(e);
        }


    }
}