package contenus;

public class LAV extends Contenu{
    private double tauxInfestation;
    public LAV(String nom, double tauxInfestation){
        super(nom);
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}