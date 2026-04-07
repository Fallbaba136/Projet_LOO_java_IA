package contenus;

import exception.ContenuException;

/**
 * @author Fall
 */
public class Liver extends Contenu{
    private double tauxInfestation;

    /**
     * @param tauxInfestation
     */
    public Liver(double tauxInfestation) throws ContenuException{
        super("Liver");
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
         Contenu Liver = new Liver( 9);
        System.out.println(Liver + "%\n");
       } catch (ContenuException e) {
        System.out.println(e);
       }
    }
}