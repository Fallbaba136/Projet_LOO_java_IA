package contenus;

import exception.ContenuException;

/**
 * @author Fall
 */
public class Muscle_Right extends Contenu{
    private double tauxInfestation;

    /**
     * @param tauxInfestation
     */
    public Muscle_Right(double tauxInfestation) throws ContenuException{
        super("Muscle_Right");
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
            Contenu muscleRight = new Muscle_Right( -15);
        System.out.println(muscleRight + "%\n");
        } catch (ContenuException e) {
           System.out.println(e);
        }
    }
}