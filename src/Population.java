import java.util.ArrayList;
import java.util.List;

import exception.PoissonException;
import exception.PopulationException;


/**
 * Classe représentant une population de poissons.
 * 
 * Une population est un ensemble de poissons (objets Poisson) sur lequel
 * on calcule des statistiques pour analyser l'infestation parasitaire.
 * 
 * Les statistiques calculées sont :
 * - Taille moyenne : taille moyenne des poissons du groupe
 * - Prévalence : pourcentage de poissons infectés
 * - Abondance : nombre moyen de parasites par poisson (tous poissons confondus)
 * - Intensité : nombre moyen de parasites chez les poissons infectés uniquement
 * 
 * @author Fall
 * @version 1.0
 */
public class Population {

    /**
     * @autor Fall
     */
 
    //Attributs
    /**
     * Taille du poisson
     */
    private double taille;
    /**
     * Pourcentage de poisson infectée dans un groupe
     */
    private double prevalence;
    /**
     * nombre moyen de parasites par poisson tout poisson confondu 
     * infecté ou non 
     */
    private int abondance;

    /**
     * nombre moyen de parasites chez les poissons infectés uniquement  
     */
    private double intensite;

    List<Poisson> maPoissons;



    //Constructeurs
/**
 * Constructeur qui crée une population à partir d'une liste de poissons.
 * Les statistiques (taille moyenne, prévalence, abondance, intensité)
 * sont automatiquement calculées à partir des données.
 * 
 * @param poissons La liste des poissons qui composent la population
 */
public Population(List<Poisson> poissons) throws PopulationException {
          if (poissons == null) {
        throw new NullPointerException("La liste de poissons ne peut pas être null");
    }
    // Stocke la liste des poissons
    this.maPoissons = poissons;

    
    // Calcule les statistiques à partir des données
    this.taille = calculerTailleMoyenne();      // taille moyenne du groupe
    this.prevalence = calculerPrevalence();     // pourcentage de poissons infectés
    this.abondance = calculerAbondance();       // parasites par poisson (tous)
    this.intensite = calculerIntensite();       // parasites par poisson infecté
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

    /**
    * Calcule la prévalence de l'infestation dans la population.
    * La prévalence est le pourcentage de poissons infectés par des parasites.
    * 
    * Étapes du calcul :
    * 1. Parcourir tous les poissons de la liste
    * 2. Compter ceux qui ont un taux d'infestation > 0 (donc infectés)
    * 3. Diviser le nombre d'infectés par le nombre total de poissons
    * 4. Multiplier par 100 pour obtenir un pourcentage
    * 
    * @return le pourcentage de poissons infectés dans la population (entre 0 et 100)
    */
    private double calculerPrevalence() {
    int infectes = 0;
    
    for (Poisson p : maPoissons) {
        // Vérifie si le poisson est infecté (taux > 0)
        if (p.getTauxInfestation() != null && p.getTauxInfestation() > 0) {
            infectes++;
        }
    }
        // Calcul du pourcentage
        return (double) infectes / maPoissons.size() * 100;
    }

    /**
    * Calcule la taille moyenne des poissons dans la population.
    * Étapes du calcul :
    * 1. Parcourir tous les poissons de la liste
    * 2. Additionner leurs tailles
    * 3. Diviser la somme par le nombre total de poissons
    * 
    * @return la taille moyenne des poissons (en mm)
    */

    private double calculerTailleMoyenne() {    
        double somme = 0;
        //On parcours le tableau de poisson
        for (Poisson p : maPoissons) {
            //on recupere la taille et on fait la somme de leur taille
        somme += p.getTaille();  // ou getLongueur()
    }
    // on divise la somme par le nombre total de poisson pour avoir la moyenne 
         return somme / maPoissons.size();
    }

    /**
    * Calcule l'abondance parasitaire dans la population.
    * L'abondance est le nombre moyen de parasites par poisson,
    * tous poissons confondus (infectés ou non).
    * C'est le moyen general de tout les especes
    * Étapes du calcul :
    * 1. Parcourir tous les poissons de la liste
    * 2. Additionner les taux d'infestation de chaque poisson
    * 3. Diviser le total par le nombre de poissons
    * 
    * @return le nombre moyen de parasites par poisson
    */
    private int calculerAbondance() {
    
        int totalParasites = 0;
        for (Poisson p : maPoissons) {
        if (p.getTauxInfestation() != null) {
            totalParasites += p.getTauxInfestation();
        }
    }
        return (int) totalParasites / maPoissons.size();
    }
    /**
    * Calcule l'intensité parasitaire dans la population.
    * L'intensité est le nombre moyen de parasites chez les poissons infectés uniquement.
    * Les poissons sains ne sont pas comptés dans ce calcul.
    * 
    * Étapes du calcul :
    * 1. Parcourir tous les poissons de la liste
    * 2. Pour chaque poisson infecté (taux > 0) :
    *    - Additionner son nombre de parasites
    *    - Compter le poisson comme infecté
    * 3. Diviser le total des parasites par le nombre de poissons infectés
    * 
    * @return le nombre moyen de parasites par poisson infecté
    */
    private double calculerIntensite() {
        int totalParasites = 0;
        int nbInfectes = 0;
    
        for (Poisson p : maPoissons) {
        if (p.getTauxInfestation() != null && p.getTauxInfestation() > 0) {
            totalParasites += p.getTauxInfestation();
            nbInfectes++;
        }
    }
        if (nbInfectes == 0) return 0;
        return (double) totalParasites / nbInfectes;
    }

    /**
    * Calcule la moyenne des taux d'infestation pour une espèce donnée
    * en ignorant les poissons dont le taux d'infestation est manquant (null).
    * Cette méthode est utilisée pour la complétion des données manquantes 
    * en remplaçant les valeurs null par la moyenne de l'espèce correspondante.
    * @param espece le nom de l'espèce pour laquelle calculer la moyenne
    * @return la moyenne des taux connus de cette espèce
    */
    private double calculerMoyenneParEspece(String espece) {
        double somme = 0;
        int compteur = 0;
        for (Poisson p : maPoissons) {
            if (p.getEspece().equals(espece) && p.getTauxInfestation() != null) {
            somme += p.getTauxInfestation();
            compteur++;
            }
        }
        return compteur == 0 ? 0 : somme / compteur;
    }

   /**
    * Nettoie les données en remplaçant les valeurs manquantes (null)
    * par la moyenne de l'espèce correspondante.
    * (Niveau 1 du sujet)
    */
    public void completionDonnees() {
        for (Poisson p : maPoissons) {
            if (p.getTauxInfestation() == null) {
            double moyenne = calculerMoyenneParEspece(p.getEspece());
            p.setTauxInfestation(moyenne);
            }
        }
    }

    


    // Surcharge du methode string 
    /**Methode toString pour l'affichage
     * @return
     */

    @Override
        public String toString() {
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
    public static void main(String[] args) {
        List<Poisson> poissons = new ArrayList<>();

        try {
            Poisson p1 = new Poisson("Merlu1", "Merlu", 500, 300);
            Poisson p2 = new Poisson("Merlu2", "Merlu", 550, 320);
            Poisson p3 = new Poisson("Merlu3", "Merlu", 450, 280);
            Poisson p4 = new Poisson("Merlu4", "Merlu", 520, 310);

            p1.setTauxInfestation(10.0);
            p2.setTauxInfestation(25.0);
            p3.setTauxInfestation(15.0);
            p4.setTauxInfestation(0.0); 

            poissons.add(p1);
            poissons.add(p2);
            poissons.add(p3);
            poissons.add(p4);
            Population population = new Population(poissons);
        
            System.out.println(population);
            
        } catch (PoissonException e) {
            System.out.println("Erreur " + e.getMessage());
        } catch(PopulationException f){
            System.out.println("Erreur " + f.getMessage());
        }   

    }

}