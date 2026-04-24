import java.util.ArrayList;
import java.util.List;
import lecture.Data_A;
import lecture.Lecture;
import exception.LectureException;
import exception.PoissonException;

/**
 * @Author Fall baba
 * @version 1.0
 * cette classe a pour but de faire le lien entre la lecture des données
 * et la création des objets Poisson à partir de ces données
 * elle contient une méthode initData() qui lit les données à partir d'un fichier CSV
 * et crée les objets Poisson correspondants
 * elle contient également une méthode printData_A() pour afficher les données après complétion
 * l'objectif de cette classe est de fournir une structure pour initialiser les données des poissons
 * à partir d'un fichier CSV et de gérer les valeurs manquantes ou aberrantes avant de créer les objets Poisson 
 * pour une utilisation ultérieure dans un programme de gestion de poissons ou d'analyse de données sur les poissons.
 */

public class Application {

    //Attributs
    private List<Poisson> poissons;
    private ArrayList<Data_A> data;

    /**
     * Initialise les données à partir d'un fichier CSV
     * et crée les objets Poisson correspondants.
     * @param name Le nom du fichier CSV à lire
     * @throws PoissonException Si une erreur de données est détectée lors de la création des poissons
     * @throws LectureException Si une erreur survient lors de la lecture du fichier
     */
    public void initData(String name) throws PoissonException, LectureException {
    Lecture lect = new Lecture(name);
    lect.readData_A();
    this.data = lect.getData();
    
    //On complete les données manquantes avant de créer les objets Poisson
    completDonneesManquantes();
    
    // On cree les objets Poisson à partir des données complétées
    poissons = new ArrayList<>();
    for (Data_A d : data) {
        Poisson p = new Poisson(d.getId());
        p.setLongueur(d.getLt());
        
        // On verifie avant d'aopeler le setPoids
        Double masse = d.getMasse();
        
        
        // Vérification de la masse avant de l'assigner au poisson
        if (masse != null && masse > 0) {
            p.setPoids(masse);
        } else {
            System.out.println("ERREUR: Masse invalide pour " + d.getId() + " = " + masse);
        }
        
        poissons.add(p);
    }
}
    

    /**
     * Complète les valeurs manquantes (null ou négatives)
     * par la moyenne de la colonne
     */
    private void completDonneesManquantes() {
        // Calculer les moyennes
        double moyenneMasse = calculerMoyenneMasse();
        double moyenneMasseEv = calculerMoyenneMasseEvisceree();
        
        System.out.println("Moyenne des masses : " + moyenneMasse);
        System.out.println("Moyenne des masses éviscérées : " + moyenneMasseEv);
        System.out.println();
        
        // Remplacer les valeurs manquantes
        for (Data_A d : data) {
            boolean isEdit = false;

            if (d.getMasse() == null || d.getMasse() < 0) {
                d.setMasse(moyenneMasse);
                isEdit = true;
            }
            
            if (d.getMasseEvisceree() == null || d.getMasseEvisceree() < 0) {
                d.setMasseEvisceree(moyenneMasseEv);
                isEdit = true;
            }
            
            if (isEdit) {
                System.out.println("Complétion pour " + d.getId() + " : " + d + "\n");
            }
        }
    }
    
    private double calculerMoyenneMasse() {
        double somme = 0;
        int compteur = 0;
        
        for (Data_A d : data) {
            Double masse = d.getMasse();
            if (masse != null && masse > 0) {
                somme += masse;
                compteur++;
            }
        }
        
        return compteur == 0 ? 0 : somme / compteur;
    }
    
    private double calculerMoyenneMasseEvisceree() {
        double somme = 0;
        int compteur = 0;
        
        for (Data_A d : data) {
            Double masseEv = d.getMasseEvisceree();
            if (masseEv != null && masseEv > 0) {
                somme += masseEv;
                compteur++;
            }
        }
        
        return compteur == 0 ? 0 : somme / compteur;
    }
    
    public void printData_A() {
        System.out.println("\n=== Donnees apres completion ===");
        for (Data_A d : data) {
            System.out.println(d + "\n");
        }
    }
    
    public static void main(String args[]) {
        try {
        Application app = new Application();
        
        // Afficher les données brutes d'abord
        Lecture lect = new Lecture("src/donnees2.csv");
        lect.readData_A();
        System.out.println("=== Donnees avant completion === \n");
        for (Data_A d : lect.getData()) {
            System.out.println(d + "\n");
        }
        
        System.out.println("\n--- Complétion en cours ---\n");
        
        // Puis initialiser avec complétion
        app.initData("src/donnees.csv");
        app.printData_A();
        
    } catch (Exception e) {
        System.out.println("Erreur : " + e.getMessage());
        e.printStackTrace();
    }
    }
}