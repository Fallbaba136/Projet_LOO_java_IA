package contenus;

public class Liver extends Contenu{
    private double tauxInfestation;
    public Liver(double tauxInfestation){
        super("Liver");
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}