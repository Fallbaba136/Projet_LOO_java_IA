package contenus;

public class Liver extends Contenu{
    private double tauxInfestation;
    public Liver(String nom, double tauxInfestation){
        super(nom);
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}