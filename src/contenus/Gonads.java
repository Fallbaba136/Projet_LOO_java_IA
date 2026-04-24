package contenus;

import exception.ContenuException;

/**
 * Classe représentant les gonades d'un poisson, qui est un type de contenu.
 * @author Fall
 */
public class Gonads extends Contenu{
    private double tauxInfestation;
    /**
     * @param tauxInfestation
     */
    public Gonads(double tauxInfestation) throws ContenuException{
        super("Gonads");
        if (tauxInfestation < 0) throw new ContenuException("Le taux d'infestation ne peut pas être négatif");
        this.tauxInfestation = tauxInfestation;
    }
  
    @Override
    /**
     * return le taux d'infestation du gonads
     * @return
     */
    public double tauxInfestation(){
        return tauxInfestation;
    }
    /**
     * @param args
     */
      public static void main(String[] args) {
        try {
             Contenu gonads = new Gonads( 00);
            System.out.println(gonads + "%");
            
        } catch (ContenuException e) {
           System.out.println(e);
        }
    }

}