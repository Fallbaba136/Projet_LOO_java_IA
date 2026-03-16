package contenus;

public class Muscle_Right extends Contenu{
    private double tauxInfestation;
    public Muscle_Right(String nom, double tauxInfestation){
        super(nom);
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}