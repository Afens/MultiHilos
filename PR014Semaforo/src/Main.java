/**
 * Created by Usuario on 04/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        // Creo la cola de impresión.
        ColaImpresion colaImpresion = new ColaImpresion(1);
        // Creo doce hilos para los trabajos de impresión.
        Thread hilos[] = new Thread[5];
        for (int i = 0; i < hilos.length; i++){
            hilos[i] = new Thread(new Trabajo(colaImpresion), "Trabajo " + i);
        }
        // Inicio los hilos.
        for (int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}
