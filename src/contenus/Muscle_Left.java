package contenus;

import exception.ContenuException;

/**
 * @author Fall
 */
public class Muscle_Left extends Contenu{
    private double tauxInfestation;

    /**
     * @param tauxInfestation
     */
    public Muscle_Left(double tauxInfestation) throws ContenuException{
        super("Muscle_Left");
         if (tauxInfestation < 0) throw new ContenuException("Le taux d'infestation ne peut pas être négatif");
        this.tauxInfestation = tauxInfestation;
    }
   /**
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
         Contenu muscleLeft = new LAV( 30);
        System.out.println(muscleLeft + "%\n");
       } catch (ContenuException e) {
        System.out.println(e);
       }
    }
}