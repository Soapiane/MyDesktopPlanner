// Cette exception est lancée lorsque l'utilisateur tente de créer un creneau qui chevauche un autre creneau
public class ExceptionCollisionHorairesCreneau extends Exception{
    ExceptionCollisionHorairesCreneau(String message){
        super(message);
    }
}
