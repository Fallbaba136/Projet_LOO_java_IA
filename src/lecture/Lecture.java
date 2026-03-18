/**
 * @author Souleymane Diallo
 * verssion1.0
*/


package application.lecture;


import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Lecture{


    /**
     * data  attribut ou on stoke les donnes 
    */
    private ArrayList<Data_A> data; 

    /**
     * le nom du fichier a charger
    */
    private String filename;


    //getteurs 
    public ArrayList<Data_A> getData(){ //elle returne  notre arrayliste 
        return this.data;
    }

   
    /**
     * constructeur
    */
    public Lecture(String name){
        this.filename=name;
        this.data=new ArrayList<>();
    }


    //cettte méthode permet de stocker les donnes dans data
    public void readData_A(){
        
       
        int cpt=0;

         try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {

            String ligne;

            while ((ligne = br.readLine()) != null) {
                cpt++;
                if(cpt!=1){
                    try {
                    // Séparer les champs
                    String[] parts = ligne.split(";");

                  

                    String id= parts[0];
                    double size = Double.parseDouble(parts[1]);
                    double tif = Double.parseDouble(parts[2]);
                  

                    // Ajouter à la liste
                    data.add(new Data_A(id, size, tif));

                 } catch (Exception e) {
                    System.out.println("Ligne ignorée : " + ligne);
                    System.out.println("Erreur : " + e.getMessage());
                 }
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur lecture fichier : " + e.getMessage());
        }

    
    }


    public static void main(String args[]){
        
        Lecture lect=new Lecture("application/fichier/merlu2018_75164.csv");
        lect.readData_A();

        ArrayList<Data_A>data=lect.getData();
        
        for(Data_A value :data){
            System.out.println(value);
        }
    }



}


    





