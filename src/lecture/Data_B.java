package lecture;

public class Data_B {
    private int id;
    private String especes;
    private Double lt;           // Longueur totale
    private Double abdomen;   // Peut être null
    private Double foie;       // Peut être null
    private Double visceres;   // Peut être null
    private Double autres;     // Peut être null
    private Double total;      // Total parasites (peut être null)
    
    // Constructeur
    /**
     * Constructeur de la classe Data_B
     * @param id L'identifiant du poisson
     * @param especes L'espèce du poisson   
     * @param lt La longueur totale du poisson
     * @param abdomen Le nombre de parasites dans l'abdomen (peut être null)
     * @param foie Le nombre de parasites dans le foie (peut être null)
     * @param visceres Le nombre de parasites dans les viscères (peut être null)
     * @param autres Le nombre de parasites dans d'autres parties (peut être null)
     * @param total Le nombre total de parasites (peut être null)
     */
    public Data_B(int id, String especes, double lt, Double abdomen, Double foie, 
                  Double visceres, Double autres, Double total) {
        this.id = id;
        this.especes = especes;
        this.lt = lt;
        this.abdomen = abdomen;
        this.foie = foie;
        this.visceres = visceres;
        this.autres = autres;
        this.total = total;
    }
    
    // Getters
    public int getId() { return id; }

    public String getEspeces() { return especes; }

    public Double getLt() { return lt; }

    public Double getAbdomen() { return abdomen; }

    public Double getFoie() { return foie; }

    public Double getVisceres() { return visceres; }

    public Double getAutres() { return autres; }

    public Double getTotal() { return total; }
    
    // Setters pour la complétion
    public void setAbdomen(Double abdomen) { this.abdomen = abdomen; }

    public void setFoie(Double foie) { this.foie = foie; }

    public void setVisceres(Double visceres) { this.visceres = visceres; }

    public void setAutres(Double autres) { this.autres = autres; }
    
    public void setTotal(Double total) { this.total = total; }

    public void setLt(Double lt){this.lt = lt;}
    
    @Override
    public String toString() {
        return String.format("id:%d espece:%s LT:%.2fmm abdomen:%s foie:%s visceres:%s autres:%s total:%s",
            id, especes, lt, abdomen, foie, visceres, autres, total);
    }
}

