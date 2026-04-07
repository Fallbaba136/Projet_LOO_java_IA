package contenus;

import exception.ContenuException;

/**
 * @author Fall
 */
public abstract class Contenu {
    //Attributs

    private String nom;

   /**
    * @param nom
    */
    public Contenu(String nom) throws ContenuException{
        if (this.nom == null || this.nom.trim().isEmpty()) throw new ContenuException("Le nom ne du contenu ne peut pas être null ou vide");
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
        return String.format("%s taux d'infestaton est de : %.1f ", this.nom, tauxInfestation());
    }


}