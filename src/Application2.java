import java.util.ArrayList;
import java.util.List;

import lecture.Data_A;
import lecture.Data_B;
import lecture.Lecture2;
import exception.LectureException;
import exception.PoissonException;
import exception.PopulationException;



/**
 * @Author Fall baba
 * @version 1.0
 * cette classe a pour but de faire le lien entre la lecture des données
 * et la création des objets Poisson à partir de ces données
 * elle contient une méthode initData() qui lit les données à partir d'un fichier CSV
 * et crée les objets Poisson correspondants
 */
public class Application2 {
    
    //Attributs
    private List<Poisson> poissons;
    private ArrayList<Data_B> data;
    private Population population;

    //Constructeurs
    public void initData(String name) throws PoissonException, LectureException{
    

        Lecture2 lecture = new Lecture2(name);
        lecture.readData_B();
        this.data = lecture.getData();

        completDonneesManquantes();

        poissons = new ArrayList<>();
        for(Data_B d : data){
            Poisson p = new Poisson(String.valueOf(d.getId()));
            p.setLongueur(d.getLt());
            if(d.getTotal() != null && d.getTotal() >= 0){
                p.setTauxInfestation(d.getTotal().doubleValue());
            }else{
                p.setTauxInfestation(0);
            }
            poissons.add(p);
        }
    }

    // Methode pour completer les taux d'infestation manquants par la regression lineaire
     private void completDonneesManquantes() {
        // Calculer les moyennes
        double moyenneAbdomen = calculerMoyenneAbdomen();
        double moyenneFoie = calculerMoyenneFoie();
        double moyenneVisceres = calculerMoyenneVisceres();
        double moyenneAutres = calculerMoyenneAutres();
        double moyenneTotal = calculerMoyenneTotal();
        double moyenLT = calculerMoyenneLT();
        
        System.out.println("=== Moyenne calcule (Niveau 1) ===");
        System.out.println("LT: " + moyenLT);
        System.out.println("Abdomen: " + moyenneAbdomen);
        System.out.println("Foie: " + moyenneFoie);
        System.out.println("Viscères: " + moyenneVisceres);
        System.out.println("Autres: " + moyenneAutres);
        System.out.println("Total: " + moyenneTotal);
        System.out.println();
        
        // On remplace les valeurs manquantes ou negatif 
         for (Data_B d : data) {
            if (d.getAbdomen() == null || d.getAbdomen() < 0) {
                d.setAbdomen(moyenneAbdomen);
                System.out.println("Complétion abdomen ID " + d.getId());
            }
            if (d.getFoie() == null || d.getFoie() < 0) {
                d.setFoie(moyenneFoie);
                System.out.println("Complétion foie ID " + d.getId());
            }
            if (d.getVisceres() == null || d.getVisceres() < 0) {
                d.setVisceres(moyenneVisceres);
                System.out.println("Complétion viscères ID " + d.getId());
            }
            if (d.getAutres() == null || d.getAutres() < 0) {
                d.setAutres(moyenneAutres);
                System.out.println("Complétion autres ID " + d.getId());
            }
            if (d.getTotal() == null || d.getTotal() < 0) {
                d.setTotal(moyenneTotal);
                System.out.println("Complétion total ID " + d.getId());
            }

            if (d.getLt() == null || d.getLt() < 0) {
                d.setLt(moyenLT);
                System.out.println("Completion total ID " + d.getId());
            }
        }
    }

    
    // Méthodes pour calculer la moyen de l'abddomen

    private double calculerMoyenneLT(){
        double somme = 0;
        int compteur = 0;

        for(Data_B d : data){
            Double valeur = d.getLt();
            if (valeur != null && valeur >= 0) {
                somme += valeur;
                compteur += 1;
            }
        }
        return compteur == 0 ? 0 : somme/compteur;
    }


    private double calculerMoyenneAbdomen() {
        double somme = 0;
        int compteur = 0;
        for (Data_B d : data) {
            Double valeur = d.getAbdomen();
            if (valeur != null && valeur >= 0) {
                somme += valeur;
                compteur++;
            }
        }
        return compteur == 0 ? 0 : somme / compteur;
    }
    
    // Methodes pour calculer la moyen Foie
    private double calculerMoyenneFoie() {
        double somme = 0;
        int compteur = 0;
        for (Data_B d : data) {
            Double valeur = d.getFoie();
            if (valeur != null && valeur >= 0) {
                somme += valeur;
                compteur++;
            }
        }
        return compteur == 0 ? 0 : somme / compteur;
    }
    
    //Methode pour calculer la moyenne Visceres
    private double calculerMoyenneVisceres() {
        double somme = 0;
        int compteur = 0;
        for (Data_B d : data) {
            Double valeur = d.getVisceres();
            if (valeur != null && valeur >= 0) {
                somme += valeur;
                compteur++;
            }
        }
        return compteur == 0 ? 0 : somme / compteur;
    }
    
    // Methode pour calculer la moyenne  Autres
    private double calculerMoyenneAutres() {
        double somme = 0;
        int compteur = 0;
        for (Data_B d : data) {
            Double valeur = d.getAutres();
            if (valeur != null && valeur >= 0) {
                somme += valeur;
                compteur++;
            }
        }
        return compteur == 0 ? 0 : somme / compteur;
    }
    
    // Methodes pour calculer la moyenne total
    private double calculerMoyenneTotal() {
        double somme = 0;
        int compteur = 0;
        for (Data_B d : data) {
            Double valeur = d.getTotal();
            if (valeur != null && valeur >= 0) {
                somme += valeur;
                compteur++;
            }
        }
        return compteur == 0 ? 0 : somme / compteur;
    }
    
    public void afficherResultats() {
        System.out.println("\n=== Donnees apres completion ===");
        for (Data_B d : data) {
            System.out.println(d + "\n");
        }
    }
    
    public static void main(String[] args) {
        try {
            Application2 app = new Application2();

           Lecture2 lecture = new Lecture2("src/donnees2.csv"); 
           System.out.println("=== Donnees avant completion === \n");
            lecture.readData_B(); //
            System.out.println();
            for (Data_B d : lecture.getData()) { 
                System.out.println(d + "\n");
            }




            app.initData("src/Donnees2.csv");
            app.afficherResultats();
            
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
