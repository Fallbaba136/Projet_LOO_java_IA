package contenus;
public abstract class Contenu {
    //Attributs

    private String nom;

   
    public Contenu(String nom){
        this.nom = nom;
    }

    // Methodes 
    public abstract double tauxInfestation();
}