package contenus;

public class LAV extends Contenu{
    private double tauxInfestation;
    public LAV(double tauxInfestation){
        super("LAV");
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }
}