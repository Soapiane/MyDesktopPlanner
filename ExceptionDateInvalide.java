// C'est l'exception qui est lancée quand la date d'une tâche est invalide.
public class ExceptionDateInvalide extends Exception{
    public ExceptionDateInvalide() {
        super("Exception : Cette date est invalide");
    }

    public ExceptionDateInvalide(String message) {
        super(message);
    }
}
