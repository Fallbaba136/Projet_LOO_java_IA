package lecture;

/**
 * cette classe représente les données d'un poisson lue à partir d'un fichier CSV
 * elle contient les attributs suivants:
 * - id: l'identifiant du poisson
 * - masse: la masse du poisson en grammes
 * - lt: la longueur totale du poisson en millimètres
 * - lf: la longueur à la fourche du poisson en millimètres
 * - masseEvisceree: la masse du poisson éviscéré en grammes
 * - filet: le nombre de filets du poisson
 * elle contient un constructeur pour initialiser ces attributs
 * et une méthode toString() pour afficher les données du poisson de manière lisible.
 * l'objectif de cette classe est de modéliser les données d'un poisson 
 * pour une utilisation ultérieure dans un programme de gestion de poissons ou d'analyse de données sur les poissons.
 */
public class Data_A {
    private String id;
    private Double masse;          // Masse(g)
    private int lt;                // LT(mm) - Longueur totale
    private int lf;                // LF(mm) - Longueur à la fourche
    private Double masseEvisceree; // Masse Poissons evisceree(g)
    private double filet;             // Filet

    public String getId() {
        return id;
    }

    public Double getMasse() {
        return masse;
    }

    public int getLt() {
        return lt;
    }

    public int getLf() {
        return lf;
    }

    public Double getMasseEvisceree() {
        return masseEvisceree;
    }

    public double getFilet() {
        return filet;
    }

     public void setMasse(Double masse) {
        this.masse = masse;
    }
    
    public void setMasseEvisceree(Double masseEvisceree) {
        this.masseEvisceree = masseEvisceree;
    }
    
    public void setFilet(double filet) {
        this.filet = filet;
    }

    /**
     * Constructeur
     * @param id
     * @param masse
     * @param lt
     * @param lf
     * @param masseEvisceree
     * @param filet
     */

    public Data_A(String id, Double masse, int lt, int lf, Double masseEvisceree, Double filet) {
        this.id = id;
        this.masse = masse;
        this.lt = lt;
        this.lf = lf;
        this.masseEvisceree = masseEvisceree;
        this.filet = filet;
    }

    @Override
    public String toString() {
        return String.format("id:%s masse:%.2fg LT:%dmm LF:%dmm masseEv:%.2fg filet:%f",
            this.id, this.masse, this.lt, this.lf, this.masseEvisceree, this.filet);
    }
}