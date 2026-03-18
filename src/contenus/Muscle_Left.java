package contenus;

public class Muscle_Left extends Contenu{
    private double tauxInfestation;
    public Muscle_Left(double tauxInfestation){
        super("Muscle_Left");
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }

}