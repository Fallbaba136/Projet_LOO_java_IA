/*
public class Data_A {
    private String id;
    private Double masse;          // Masse(g)
    private int lt;                // LT(mm) - Longueur totale
    private int lf;                // LF(mm) - Longueur à la fourche
    private Double masseEvisceree; // Masse Poissons evisceree(g)
    private int filet;             // Filet

    public Data_A(String id, Double masse, int lt, int lf, Double masseEvisceree, int filet) {
        this.id = id;
        this.masse = masse;
        this.lt = lt;
        this.lf = lf;
        this.masseEvisceree = masseEvisceree;
        this.filet = filet;
    }

    @Override
    public String toString() {
        return String.format("id:%s masse:%.2fg LT:%dmm LF:%dmm masseEv:%.2fg filet:%d",
            this.id, this.masse, this.lt, this.lf, this.masseEvisceree, this.filet);
    }
}




*/


/*
public void readData_A() {
    int cpt = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
        String ligne;

        while ((ligne = br.readLine()) != null) {
            cpt++;
            if (cpt != 1) { // ignorer l'en-tête
                try {
                    //  Séparateur tabulation
                    String[] parts = ligne.split("\t");

                    String id = parts[0].trim(); //  Trim pour éviter les espaces

                    //  Gestion valeurs manquantes + virgule → point
                    Double masse = parseDouble(parts[1]);
                    int lt      = Integer.parseInt(parts[2].trim()); 
                    int lf      = Integer.parseInt(parts[3].trim());
                    Double masseEv = parseDouble(parts[4]);
                    int filet   = Integer.parseInt(parts[5].trim());

                    //  Ignorer les valeurs aberrantes (négatives)
                    if (masse != null && masse < 0) masse = null;
                    if (masseEv != null && masseEv < 0) masseEv = null;

                    data.add(new Data_A(id, masse, lt, lf, masseEv, filet));

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

// ✅ Méthode utilitaire : gère virgule et valeur vide
private Double parseDouble(String val) {
    if (val == null || val.trim().isEmpty()) return null;
    return Double.parseDouble(val.trim().replace(",", "."));
}


*/