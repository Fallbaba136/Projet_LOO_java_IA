package lecture;

import java.io.*;
import java.util.ArrayList;
import exception.LectureException;

public class Lecture2 {
    private ArrayList<Data_B> data;
    private String filename;
    
    public Lecture2(String name) throws LectureException {
        if (name == null || name.trim().isEmpty()) {
            throw new LectureException("Le nom du fichier ne peut pas être null");
        }
        this.filename = name;
        this.data = new ArrayList<>();
    }
    
    public ArrayList<Data_B> getData() {
        return this.data;
    }
    
    public void readData_B() {
        int cpt = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String ligne;
            
            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;
                
                cpt++;
                if (cpt == 1) continue; 
                
                try {
                    String[] parts = ligne.split(",");  
                    
                    if (parts.length < 8) {
                        System.out.println("Ligne ignorée (colonnes insuffisantes)");
                        continue;
                    }
                    
                    int id = Integer.parseInt(parts[0].trim());
                    String especes = parts[1].trim();
                    int lt = Integer.parseInt(parts[2].trim());
                    
                    // Lecture avec gestion des valeurs vides
                    Double LT = parseDouble(parts[2]);
                    Double abdomen = parseDouble(parts[3]);
                    Double foie = parseDouble(parts[4]);
                    Double visceres = parseDouble(parts[5]);
                    Double autres = parseDouble(parts[6]);
                    Double total = parseDouble(parts[7]);
                    
                    // On remplace les valeurs negatifs par null 
                    if (abdomen != null && abdomen < 0) abdomen = null;
                    if (foie != null && foie < 0) foie = null;
                    if (visceres != null && visceres < 0) visceres = null;
                    if (autres != null && autres < 0) autres = null;
                    if (total != null && total < 0) total = null;
                    if (LT != null && LT < 0) LT = null;
                        
                    
                    
                    data.add(new Data_B(id, especes, lt, abdomen, foie, visceres, autres, total));
                    
                } catch (Exception e) {
                    System.out.println("Ligne ignorée : " + ligne);
                    System.out.println("Erreur : " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lecture fichier : " + e.getMessage());
        }
    }
    
   
private Double parseDouble(String val) {
    if (val == null || val.trim().isEmpty()) return null;
    return Double.parseDouble(val.trim().replace(",", "."));
}


      public static void main(String[] args) {
    try {
        Lecture2 lecture = new Lecture2("src/donnees2.csv"); 
        lecture.readData_B();
        
        System.out.println("=== VÉRIFICATION DES VALEURS NEGATIVES ===");
        for (Data_B d : lecture.getData()) {
            if (d.getId() == 11) {
                System.out.println("ID 11 - LT = " + d.getLt());
                System.out.println("  → Si c'est null, le remplacement a fonctionné !");
                System.out.println("  → Si c'est -200, le remplacement a échoué.");
            }
        }
        
    } catch (LectureException e) {
        System.out.println("Erreur : " + e.getMessage());
    }
}
}