package contenus;

import exception.ContenuException;

/**
 * Classe représentant les LAV d'un poisson, qui est un type de contenu.
 * @author Fall
 */
public class Muscle_Right extends Contenu{
    private double tauxInfestation;

    /**
     * Constructeur de la classe Muscle_Right.
     * @param tauxInfestation
     */
    public Muscle_Right(double tauxInfestation) throws ContenuException{
        super("Muscle_Right");
        if (tauxInfestation < 0) throw new ContenuException("Le taux d'infestation ne peut pas être négatif");
        this.tauxInfestation = tauxInfestation;
    }
   /**
    * Return le taux d'infestation du muscle droite 
    * @return
    */
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Contenu muscleRight = new Muscle_Right( -15);
        System.out.println(muscleRight + "%\n");
        } catch (ContenuException e) {
           System.out.println(e);
        }
    }
}