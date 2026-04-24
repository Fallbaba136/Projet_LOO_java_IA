import java.util.ArrayList;
import java.util.List;
import contenus.Contenu;
import exception.PoissonException;

/**
 * @Author Fall baba
 * @version 1.0
 * cette Classe a pour but de stocker les differentes 
 * informations concernant une poisson
 * 
 */
public class Poisson {

    //Attributs 
    /**
     * L'espece du poisson
     */
    private String especes;
    /**
     * id du poisson
     */
    private String id;
   
    /**
     * poids du poisson
     */
    private double poids;
    /**
     * longueur du poisson
     */
    private double longueur;
    /**
     * tauxInfestation du poisson
     * idbre de parasite chez un poisson
     */
    private Double tauxInfestation;
    /**
     * Liste contenant les différentes partie ou contenu du poisson
     */
    List<Contenu> maContenu;

    public Double getTauxInfestation(){return tauxInfestation;}
    public void setTauxInfestation(double tauxInfestation){this.tauxInfestation = tauxInfestation;}

    /**
     * lecture de l'attribut espece 
     * @return
     */
    public String getEspece(){ return especes;}

    /**
     * Lecture de l'attribut id 
     * @return
     */
    public String getId(){ return id;}

   /**
    * Pour la modification de l'attribut id 
    * Gestion Exception
    * @param id
    */
    public void setId(String id) throws PoissonException{
        if (this.id == null || this.id.trim().isEmpty()) throw new PoissonException("Le id du poisson ne peut pas être null ou vide");
        this.id = id;
    }


    /**
     * Lecture de l'attribut poids
     * @return
     */
    public double getPoids(){return poids;}
    /**
     * modification possible de longueur
     * Gestion Exception 
     * @param poids
     */
    public void setPoids(double poids){
        this.poids = poids;}

    /**
     * lecture de longueur
     * @return
     */
    public double getLongueur(){return longueur;}
    /**
     * Modification de longueur 
     * Gestion d'erreur avec Exception
     * @param longueur
     */
    public void setLongueur(double longueur) throws PoissonException{
        if(this.longueur < 0) throw new PoissonException("La longueur du poisson doit être supérieur ou égal à 0");
        this.longueur = longueur;}

    /**
     * return la liste de tout les organes (contenus) du poisson 
     * @return
     */
    public List<Contenu> getContenu(){return maContenu;}
    /**
     * Ajoute un organe au poisson
     * Chaque organe avec son propre idbre de parasite 
     * par exemple: poisson.AjouterContenu(new Foie(5)) => 5 correspond au idbre de parasites 
     * @param contenu de l'organe a ajouter 
     */
     public void AjouterContenu(Contenu contenu){
        this.maContenu.add(contenu);
    }

    public void setListContenu(Contenu contenu){this.maContenu.add(contenu);}

    /**
     * le constructeur
     * @param especes
     * @param id
     * @param longueur
     * @param poids
     * @param longueur
     * 
     * On vérifie que les données ne peuvent être négatif 
     */
    
    public Poisson(String id) throws PoissonException{
    
        this.id = id;
        maContenu   = new ArrayList<>();
    }

    /**
    * Calcule le idbre de parasites présents dans cet organe.
    * Le calcul dépend du type d'organe (foie, gonades, etc.)
    * et utilise le taux global du poisson parent.
    * @return le nombre de parasites dans cet organe (>= 0)
    */
    public void calculerTauxInfestation() {
    double total = 0;
    for (Contenu c : maContenu) {
        total += c.tauxInfestation();  // chaque contenu donne son idbre de parasites
    }
    this.tauxInfestation = total;
    }

    @Override
    /**
     * Surcharge de la méthode toString
     */
    public String toString(){
        return String.format("[%s] Espece: %s Poids(g): %.1f longueur(cm): %.1f \n",
        getId(),
        getEspece(),
        getPoids(),
        getLongueur());
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Poisson newPoisson = new Poisson("cissePoisson");
            System.out.println(newPoisson + "\n");
        } catch (PoissonException e) {
            System.out.println(e);
        }
    }

}