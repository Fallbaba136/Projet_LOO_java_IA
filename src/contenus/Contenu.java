package contenus;
public abstract class Contenu {
    //Attributs

    private String nom;

   
    public Contenu(String nom){
        this.nom = nom;
    }

    // Methodes 
    public abstract double tauxInfestation();

    @Override
    /**
     * Surcharge de de notre methode toString
     * @return 
     */
    public String toString(){
        return String.format("%s %.1f", this.nom, tauxInfestation());
    }
}