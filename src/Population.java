
public class Population {

    /**
     * @autor Fall
     */
    //Attributs
    private double taille;
    private double prevalence;
    private int abondance;
    private double intensite;
    private double poids;

    //Constructeurs
    /**
     * le Constructeur 
     * @param taille
     * @param prevalence
     * @param abondance
     * @param intensite
     */
    public Population(double taille, double prevalence, int abondance, double intensite){

        this.taille = taille;
        this.prevalence = prevalence;
        this.abondance = abondance;
        this.intensite = intensite;
    }

    // Accesseur

    /**
     * accessibilite de l'attributs tailles
     * @return
     */
    public double getTaille(){return taille;}
    
    /**
     * accessibilite de l'attributs prevalence
     * @return
     */
    public double getPrevalence(){return prevalence;}

    /**
     * accessibilite de l'attributs Abondance
     * @return
     */
    public int getAbondance(){return abondance;}
/**
     * accessibilite de l'attributs Intensite
     * @return
     */
    public double getIntensite(){return intensite;}

    // Surcharge du methode string 
    /**Methode toString pour l'affichage
     * @return
     */

    @Override
    public String toString(){
        return String.format("taille(mm) : %.1f | prevalence : %.1f | abondance : %d | intensite : %.1f",
         getTaille(),
        getPrevalence(),
        getAbondance(),
        getIntensite()
    );
    }
    /**
     * Fontion pour tester
     * @param args
     */

}