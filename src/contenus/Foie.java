package contenus;

public class Foie extends Contenu{
    private double tauxInfestation;
    
    /**
     * Le Constructeur
     * @param tauxInfestation
     */
    public Foie(double tauxInfestation){
        super("Foie");
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    /**
     * Surcharge du taux d'infestation
     * @return
     */
    public double tauxInfestation(){
        return tauxInfestation;
    }

    public static void main(String[] args) {
        Contenu foie = new Foie(10);
        System.out.println(foie + "%");
    }

}