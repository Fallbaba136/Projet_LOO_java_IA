package exception;

/**
 * @author Fall Babacar
 * Exception levée lorsqu'une erreur liée à la regression des données des poissons.
 */
public class RegressionException extends Exception {

     /**
     * Constructeur avec un message d'erreur
     * @param message le message décrivant l'erreur
     */

     public RegressionException(String message){
        super(message);
     }
}