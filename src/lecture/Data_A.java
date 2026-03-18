/**
 * @author Souleymane Diallo
 * verssion1.0
*/


package application.lecture;


public class Data_A{
    


     /**
     * id du poisson
     */
    private String id;



     /**
     * size du poisson
     */
    private Double size;



     /**
     * taux infestation 
     */
    private Double tif;

    
     /**
     * construteur;
     */
    public Data_A(String id,Double size,Double tif){
        this.id=id;
        this.size=size;
        this.tif=tif;
    }




    //recharger le toString()

    @Override
    public String toString(){

        return String.format("id:%s size:%.2f taux_infestation:%.2f",this.id,this.size,this.tif);

    }

}
