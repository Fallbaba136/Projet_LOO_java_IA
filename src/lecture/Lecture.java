/**
 * @author Souleymane Diallo
 * verssion1.0
*/


package lecture;


import java.io.*;
import java.util.ArrayList;


import exception.LectureException;
/****
 * cette classe a pour but de lire les données d'un fichier CSV
 * et de les stocker dans une liste d'objets Data_A
 * elle contient un constructeur qui prend en paramètre le nom du fichier à lire
 * et une méthode readData_A() qui lit le fichier ligne par ligne, 
 * ignore l'en-tête, crée un objet Data_A pour chaque ligne de données, 
 * et ajoute cet objet à la liste data.
 * la méthode gère également les valeurs manquantes et les valeurs aberrantes (négatives) 
 * en les remplaçant par null ou en les ignorant.
 * l'objectif de cette classe est de fournir une structure pour lire et stocker les données d'un poisson 
 * à partir d'un fichier CSV pour une utilisation ultérieure dans un programme de gestion de poissons ou d'analyse de données sur les poissons.
 */

public class Lecture{


    /**
     * data  attribut ou on stoke les donnes 
     * cette liste contiendra des objets de type Data_A qui representent les données d'un poisson
    */
    private ArrayList<Data_A> data; 

    /**
     * le nom du fichier a charger  
    */
    private String filename;


    /**
     * getter de data
     * @return
     */
    public ArrayList<Data_A> getData(){ //elle returne  notre arrayliste 
        return this.data;
    }

   
    /**
        * le constructeur de la classe Lecture
        * il prend en paramètre le nom du fichier à lire
        * et initialise la liste data
        * Gestion Exception : si le nom du fichier est null ou vide, une exception LectureException est levée
     * @param name
     * @throws LectureException
     */
    public Lecture(String name) throws LectureException{
        if(name == null || name.trim().isEmpty()) throw new LectureException("Le nom du fichier ne peut pas être null");
        this.filename=name;
        this.data=new ArrayList<>();
    }


    /**
     * cette méthode permet de stocker les donnes dans data
     * elle ignorera l'en-tête
     * pour chaque ligne : séparé avec ";"
     * Crée un objet Data_A
     * Ajouter a la liste
     */
   public void readData_A() {
    int cpt = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
        String ligne;

        while ((ligne = br.readLine()) != null) {
            cpt++;
            if (cpt != 1) { // ignorer l'en-tête
            if (ligne.trim().isEmpty()) continue;
                try {
                    //  Séparateur tabulation
                    String[] parts = ligne.split("\t");

                    String id = parts[0].trim(); //  Trim pour éviter les espaces

                    //  Gestion valeurs manquantes + virgule → point
                    Double masse = parseDouble(parts[1]); 
                    int lt      = Integer.parseInt(parts[2].trim()); 
                    int lf      = Integer.parseInt(parts[3].trim()); 
                    Double masseEv = parseDouble(parts[4]);
                    Double filet   = parseDouble(parts[5].trim()); //

                    //  Ignorer les valeurs aberrantes (négatives)
                    if (masse != null && masse < 0) masse = null;
                    if (masseEv != null && masseEv < 0) masseEv = null;

                    data.add(new Data_A(id, masse, lt, lf, masseEv, filet));

                } catch (Exception e) { 
                    System.out.println("Erreur : " + e.getMessage()); //
                }
            }
        }

    } catch (IOException e) {
        System.out.println("Erreur lecture fichier : " + e.getMessage());
    }
}
/**
 * cette méthode parseDouble gère les valeurs manquantes et les virgules dans les nombres décimaux
 * si la valeur est null ou vide, elle retourne null
 * sinon, elle convertit la chaîne en double en remplaçant les virgules par des points
 * @param val
 * @return
 */

private Double parseDouble(String val) {
    if (val == null || val.trim().isEmpty()) return null;
    return Double.parseDouble(val.trim().replace(",", "."));
}


    public static void main(String[] args) {
        try {
            Lecture lecture = new Lecture("src/donnees.csv"); 
            lecture.readData_A(); //
            System.out.println();
            for (Data_A d : lecture.getData()) { 
                System.out.println(d + "\n");
            }
        } catch (LectureException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}


    





