package contenus;

import exception.ContenuException;

/**
 * Classe représentant les LAV d'un poisson, qui est un type de contenu.
 * @author Fall
 */
public class Stomach extends Contenu{
    private double tauxInfestation;

    /**
     * Constructeur de la classe Stomach.
     * @param tauxInfestation
     */
    public Stomach(double tauxInfestation) throws ContenuException{
        super("Stomach");
        if (tauxInfestation < 0) throw new ContenuException("Le taux d'infestation ne peut pas être négatif");
        this.tauxInfestation = tauxInfestation;
    }
    @Override
    /**
     * Retourne le taux d'infestation du ventre.
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
             Contenu stomach = new Stomach( 3.2);
        System.out.println(stomach + "%");
        } catch (ContenuException e) {
            System.out.println(e);
        }
    }

}