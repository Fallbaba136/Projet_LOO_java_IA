package exception;

/**
 * @author Fall Babacar
 * Exception levée lorsqu'une erreur liée à la Lecture du fichier se produit.
 */

public class LectureException extends Exception {
     /**
     * Constructeur avec un message d'erreur
     * @param message le message décrivant l'erreur
     */
    public LectureException(String message){
        super(message);
    }
}