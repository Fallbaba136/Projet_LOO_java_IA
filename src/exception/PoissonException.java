package exception;

/**
 * @author Fall Babacar
 * Exception levée lorsqu'une erreur liée à la population se produit.
 */
public class PoissonException extends Exception {
    /**
     * Constructeur avec un message d'erreur
     * @param message le message d'écrivant l'erreur
     */

    public PoissonException(String message){
        super(message);
    }

}