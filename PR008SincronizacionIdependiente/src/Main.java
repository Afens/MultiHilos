/**
 * Created by Usuario on 19/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        int [] salas={20,20};
        Cine cine=new Cine(salas);

        Thread hTaquilla1=new Thread(new Taquilla1(cine));
        Thread hTaquilla2=new Thread(new Taquilla2(cine));

        hTaquilla1.start();
        hTaquilla2.start();

        try{
            hTaquilla1.join();
            hTaquilla2.join();
        }catch (InterruptedException e){

        }
        System.out.println();
        int numSalas = salas.length;
        for (int i = 0; i < numSalas; i++) {
            System.out.printf("Sala %d: %d butacas libres\n", i + 1,
                    cine.getLibres(i));
        }
    }
}
