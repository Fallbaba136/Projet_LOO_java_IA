package contenus;

import exception.ContenuException;

/**
 * @author Fall
 */
public class Stomach extends Contenu{
    private double tauxInfestation;

    /**
     * @param tauxInfestation
     */
    public Stomach(double tauxInfestation) throws ContenuException{
        super("Stomach");
        if (tauxInfestation < 0) throw new ContenuException("Le taux d'infestation ne peut pas être négatif");
        this.tauxInfestation = tauxInfestation;
    }
    @Override
    /**
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