package exception;

/**
 * @author Fall Babacar
 * Exception levée lorsqu'une erreur liée à la population se produit.
 * Exemples : liste de poissons null, liste vide, etc.
 */
public class PopulationException extends Exception {
    
    /**
     * Constructeur avec un message d'erreur
     * @param message le message décrivant l'erreur
     */
    public PopulationException(String message) {
        super(message);  // transmet le message à la classe parente Exception
    }
}