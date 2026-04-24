package contenus;

import exception.ContenuException;
/**
 * Classe représentant le foie d'un poisson, qui est un type de contenu.
 * @author Fall
 */
public class Foie extends Contenu{
    private double tauxInfestation;
    
    /**
     * Le Constructeur
     * @param tauxInfestation
     */
    public Foie(double tauxInfestation) throws ContenuException{
        super("Foie");
        if (tauxInfestation < 0) {
            throw new ContenuException("Le taux d'infestation ne peux pas être négatifs");
        }
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    /**
     * Surcharge du taux d'infestation
     * return le taux d'infestation du Foie
     * @return
     */
    public double tauxInfestation(){
        return tauxInfestation;
    }
    /**
     * @param
     */

    public static void main(String[] args) {
        try {
            Contenu foie = new Foie(10);
            System.out.println(foie + "%");
        } catch (ContenuException e) {
            System.out.println(e);
        }
    }

}