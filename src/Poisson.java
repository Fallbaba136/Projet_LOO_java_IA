import java.util.ArrayList;
import java.util.List;
import contenus.Contenu;

/**
 * @Author Fall baba
 * @version 1.0
 * cette Classe a pour but de stocker les differentes 
 * informations concernant une poisson
 * 
 */
public class Poisson {

    //Attributs 
    private String especes;
    private String nom;
    private double longueur;
    private double poids;
    private double taille;
    private Double tauxInfestation;
    List<Contenu> maContenu;

    /**
     * lecture de l'attribut espece 
     * @return
     */
    public String getEspece(){ return especes;}

    /**
     * Lecture de l'attribut Nom 
     * @return
     */
    public String getNom(){ return nom;}

   /**
    * Pour la modification de l'attribut nom 
    * @param nom
    */
    public void setNom(String nom){this.nom = nom;}
   /**
    * lecture de l'attribut longueur
    * @return
    */
    public double getLongueur(){return longueur;}
    /**
     * Modification possible de l'attribut longueur 
     * @param longueur
     */
    public void setLongueur(double longueur){this.longueur = longueur;}

    /**
     * Lecture de l'attribut poids
     * @return
     */
    public double getPoids(){return poids;}
    /**
     * modification possible de longueur
     * @param poids
     */
    public void setPoids(double poids){this.poids = poids;}

    /**
     * lecture de taille
     * @return
     */
    public double getTaille(){return taille;}
    /**
     * Modification de taille 
     * @param taille
     */
    public void setTaille(double taille){this.taille = taille;}

    /**
     * le constructeur
     * @param especes
     * @param nom
     * @param longueur
     * @param poids
     * @param taille
     */

    public Poisson(String nom, String especes, double longueur, double poids, double taille){
        this.nom = nom;
        this.especes = especes;
        this.longueur = longueur;
        this.poids = poids;
        this.taille = taille;
        maContenu   = new ArrayList<>();
    }
    @Override
    /**
     * 
     */
    public String toString(){
        return String.format("[%s] Espece: %s Longueur(cm): %.1f Poids(g): %.1f Taille(cm): %.1f \n",
         getNom(),
        getEspece(),
        getLongueur(),
        getPoids(),
        getTaille());
    }

    public static void main(String[] args) {
        Poisson newPoisson = new Poisson("cissePoisson", "sardine", 10, 20, 174);
        
        System.out.println("\n" + newPoisson);
    }


}