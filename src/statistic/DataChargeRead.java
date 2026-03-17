package statistic;
import java.io.*;
import java.util.*;

public class DataChargeRead {

public static void main(String[] args) {

    
ArrayList<String> releves = new ArrayList<>();

try {
BufferedReader br = new BufferedReader(new FileReader("releves.csv"));
String ligne;

while ((ligne = br.readLine()) != null) {

String[] parties = ligne.split(",");

String nom = parties[0];
double note = Double.parseDouble(parties[1]);

releves.add(nom + " : " + note);
}

br.close();

} catch (IOException e) {
System.out.println("Erreur de lecture du fichier");
}

System.out.println(releves);
}
}



