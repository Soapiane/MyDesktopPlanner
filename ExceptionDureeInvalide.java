// C'est l'exception qui est lancée quand la durée d'une tâche est invalide.
public class ExceptionDureeInvalide extends Exception{
    public ExceptionDureeInvalide() {
        super("Exception : Cette durée est invalide");
    }

    public ExceptionDureeInvalide(String message) {
        super(message);
    }
}
