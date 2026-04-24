/*
import java.util.ArrayList;
import java.util.List;
import lecture.Data_B;
import lecture.Lecture2;
import exception.LectureException;
import exception.PoissonException;
import exception.PopulationException;

public class Application {
    private List<Poisson> poissons;
    private ArrayList<Data_B> data;
    private Population population;

    public void initData(String name) throws PoissonException, LectureException, PopulationException {
        // 1. Lecture du nouveau fichier CSV
        Lecture2 lect = new Lecture2(name);
        lect.readData_B();
        this.data = lect.getData();
        
        // 2. Complétion Niveau 1 : Données manquantes du CSV (Abdomen, Foie, etc.)
        completDonneesManquantesCSV();
        
        // 3. Création des objets Poisson
        poissons = new ArrayList<>();
        for (Data_B d : data) {
            Poisson p = new Poisson(String.valueOf(d.getId()));
            p.setEspece(d.getEspeces());
            p.setLongueur(d.getLt());
            
            // Le total = nombre de parasites = tauxInfestation
            if (d.getTotal() != null && d.getTotal() >= 0) {
                p.setTauxInfestation(d.getTotal().doubleValue());
            } else {
                p.setTauxInfestation(null); // Sera complété par Population
            }
            
            poissons.add(p);
        }
        
        // 4. Complétion Niveau 2 : Population va compléter les tauxInfestation manquants
        //    en utilisant d'abord la moyenne, puis la régression linéaire
        this.population = new Population(poissons);
    }
    
    /**
     * Niveau 1 : Complète les valeurs manquantes du CSV (Abdomen, Foie, Viscères, Autres, Total)
     * par la moyenne de chaque colonne
     */
    private void completDonneesManquantesCSV() {
        // Calculer les moyennes
        Double moyenneAbdomen = calculerMoyenne(getValides(d -> d.getAbdomen()));
        Double moyenneFoie = calculerMoyenne(getValides(d -> d.getFoie()));
        Double moyenneVisceres = calculerMoyenne(getValides(d -> d.getVisceres()));
        Double moyenneAutres = calculerMoyenne(getValides(d -> d.getAutres()));
        Double moyenneTotal = calculerMoyenne(getValides(d -> d.getTotal()));
        
        System.out.println("=== MOYENNES CALCULÉES (Niveau 1) ===");
        System.out.println("Abdomen: " + moyenneAbdomen);
        System.out.println("Foie: " + moyenneFoie);
        System.out.println("Viscères: " + moyenneVisceres);
        System.out.println("Autres: " + moyenneAutres);
        System.out.println("Total: " + moyenneTotal);
        System.out.println();
        
        // Remplacer les valeurs manquantes ou négatives
        for (Data_B d : data) {
            if (d.getAbdomen() == null || d.getAbdomen() < 0) {
                d.setAbdomen(moyenneAbdomen.intValue());
                System.out.println("Complétion abdomen pour ID " + d.getId());
            }
            if (d.getFoie() == null || d.getFoie() < 0) {
                d.setFoie(moyenneFoie.intValue());
                System.out.println("Complétion foie pour ID " + d.getId());
            }
            if (d.getVisceres() == null || d.getVisceres() < 0) {
                d.setVisceres(moyenneVisceres.intValue());
                System.out.println("Complétion viscères pour ID " + d.getId());
            }
            if (d.getAutres() == null || d.getAutres() < 0) {
                d.setAutres(moyenneAutres.intValue());
                System.out.println("Complétion autres pour ID " + d.getId());
            }
            if (d.getTotal() == null || d.getTotal() < 0) {
                d.setTotal(moyenneTotal.intValue());
                System.out.println("Complétion total pour ID " + d.getId());
            }
        }
    }
    
    /**
     * Récupère les valeurs valides (>0) d'une colonne
     */
    private List<Integer> getValides(java.util.function.Function<Data_B, Integer> extractor) {
        List<Integer> valides = new ArrayList<>();
        for (Data_B d : data) {
            Integer valeur = extractor.apply(d);
            if (valeur != null && valeur >= 0) {
                valides.add(valeur);
            }
        }
        return valides;
    }
    
    private Double calculerMoyenne(List<Integer> valeurs) {
        if (valeurs.isEmpty()) return 0.0;
        double somme = 0;
        for (Integer v : valeurs) {
            somme += v;
        }
        return somme / valeurs.size();
    }
    
    public void afficherResultats() {
        System.out.println("\n=== DONNÉES APRÈS COMPLÉTION (Niveau 1) ===");
        for (Data_B d : data) {
            System.out.println(d);
        }
        
        System.out.println("\n=== STATISTIQUES POPULATION (Niveau 2) ===");
        System.out.println(population);
        
        System.out.println("\n=== DÉTAIL DES POISSONS APRÈS COMPLÉTION POPULATION ===");
        for (Poisson p : poissons) {
            System.out.printf("ID: %s | Longueur: %.1f mm | Taux infestation: %.2f parasites\n",
                p.getId(), p.getLongueur(), p.getTauxInfestation());
        }
    }
    
    public static void main(String[] args) {
        try {
            Application app = new Application();
            app.initData("src/nouveau_fichier.csv");
            app.afficherResultats();
            
        } catch (Exception e) {
        //    System.out.println("Erreur : " + e.getMessage());
      //      e.printStackTrace();
    //    }
  //  }
//}

*/