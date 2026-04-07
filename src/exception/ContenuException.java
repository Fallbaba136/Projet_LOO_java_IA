package exception;

/**
 * @author Fall Babacar
 * Exception levée lorsqu'une erreur liée à la Contenu se produit.
 */
public class ContenuException extends Exception {

     /**
     * Constructeur avec un message d'erreur
     * @param message le message décrivant l'erreur
     */
    public ContenuException(String message){
        super(message);
    }
}