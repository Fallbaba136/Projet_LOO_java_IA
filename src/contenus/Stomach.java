package contenus;

public class Stomach extends Contenu{
    private double tauxInfestation;
    public Stomach(double tauxInfestation){
        super("Stomach");
        this.tauxInfestation = tauxInfestation;
    }
   
    @Override
    public double tauxInfestation(){
        return tauxInfestation;
    }
        public static void main(String[] args) {
        Contenu stomach = new Stomach( 3.2);
        System.out.println(stomach + "%");
    }

}