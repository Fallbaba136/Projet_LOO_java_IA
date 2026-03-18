package contenus;

public class Gonads extends Contenu{
    private double tauxInfestation;
    public Gonads(double tauxInfestation){
        super("Gonads");
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }
      public static void main(String[] args) {
        Contenu gonads = new Gonads( 00);
        System.out.println(gonads + "%");
    }

}