package contenus;

import exception.ContenuException;

/**
 * Classe abstraite représentant le contenu d'un poisson.
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

    /**
     * methode qui sera herite par les classes filles
     * @return
     */
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