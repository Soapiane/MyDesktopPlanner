// Cette exception est lancée quand on crée un utilisateur qui existe deja.
public class ExceptionUserAlreadyExists extends Exception{
    public ExceptionUserAlreadyExists() {
        super("Exception : Cet utilisateur existe deja !");
    }

    public ExceptionUserAlreadyExists(String message) {
        super(message);
    }
}
