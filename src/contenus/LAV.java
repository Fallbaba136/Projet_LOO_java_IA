package contenus;

import exception.ContenuException;

/**
 * Classe représentant les LAV d'un poisson, qui est un type de contenu.
 * @author Fall
 */
public class LAV extends Contenu{
    private double tauxInfestation;

    /**
     * @param tauxInfestation
     */
    public LAV(double tauxInfestation) throws ContenuException{
        super("LAV");
        if (tauxInfestation < 0) throw new ContenuException("Le taux d'infestation ne peut pas être négatif");
        this.tauxInfestation = tauxInfestation;
    }
   
    /**
     * return le taux d'infestation du LAV
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
            Contenu lav = new LAV( 3);
        System.out.println(lav + "%\n");
         } catch (ContenuException e) {
            System.out.println(e);
         }
    }
}