package contenus;

public class Foie extends Contenu{
    private double tauxInfestation;
    public Foie(String nom, double tauxInfestation){
        super(nom);
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}