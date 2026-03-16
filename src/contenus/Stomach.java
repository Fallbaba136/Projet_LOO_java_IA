package contenus;

public class Stomach extends Contenu{
    private double tauxInfestation;
    public Stomach(String nom, double tauxInfestation){
        super(nom);
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}