/**
 * Created by Usuario on 26/10/2015.
 */
public class Main {
    public static void main(String[] args) {

        Palillo palillos[] = new Palillo[5];
        Thread hilos[] = new Thread[5];

        for (int i = 0; i < 5; i++) {
            palillos[i] = new Palillo(i + 1);
        }
        for (int i = 0; i < 5; i++) {
            if (i == 0)
                hilos[i] =new Thread( new Comensal(i + 1, palillos[4], palillos[i]));
            else
                hilos[i] =new Thread( new Comensal(i + 1, palillos[i-1], palillos[i]));
        }

        for (int i = 0; i < 5; i++) {
            hilos[i].start();
        }
    }

}
