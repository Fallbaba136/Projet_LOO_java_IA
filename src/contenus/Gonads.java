package contenus;

public class Gonads extends Contenu{
    private double tauxInfestation;
    public Gonads(String nom, double tauxInfestation){
        super(nom);
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}