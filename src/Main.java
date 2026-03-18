import contenus.*;
public class Main {
    /**
     * @autor Fall
     * @param args
     */

    public static void main(String[] args) {
        Contenu gonads = new LAV( 3);
        System.out.println(gonads + "%\n");

        Contenu Liver = new Liver( 9);
        System.out.println(Liver + "%\n");

        Contenu muscleLeft = new LAV( 30);
        System.out.println(muscleLeft + "%\n");

        Contenu muscleRight = new Muscle_Right( -15);
        System.out.println(muscleRight + "%\n");

        Contenu stomach = new Stomach( 3.2);
        System.out.println(stomach + "%\n");

        Population population = new Population(-12, 5, 3, 17);
        System.out.println(population + "\n");

        Poisson newPoisson = new Poisson("cissePoisson", "sardine", 10, 20, 174);
        System.out.println(newPoisson + "\n");
    }
}