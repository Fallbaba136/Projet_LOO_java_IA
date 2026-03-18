package contenus;

public class Muscle_Right extends Contenu{
    private double tauxInfestation;
    public Muscle_Right(double tauxInfestation){
        super("Muscle_Right");
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }
}