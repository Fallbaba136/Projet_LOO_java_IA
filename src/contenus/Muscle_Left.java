package contenus;

public class Muscle_Left extends Contenu{
    private double tauxInfestation;
    public Muscle_Left(String nom, double tauxInfestation){
        super(nom);
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}