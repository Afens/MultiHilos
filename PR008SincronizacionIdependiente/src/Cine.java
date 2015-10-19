/**
 * Created by Usuario on 19/10/2015.
 */
public class Cine {
    int[] salas;
    Object[] vigila;

    public Cine(int[] salas) {
        this.salas = salas;
        vigila = new Object[salas.length];
        for (int i = 0; i < salas.length; i++) {
            vigila[i] = new Object();
        }
    }

    public boolean vender(int sala, int cantidad) {
        if (sala < 0 || sala >= salas.length) {
            return false;
        }
        synchronized (vigila[sala]) {
            if (cantidad <= salas[sala]) {
                salas[sala] -= cantidad;
                System.out.printf("Sala %d: %d entradas vendidas\n", sala, cantidad);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return true;
            } else
                return false;
        }
    }

    public boolean devolver(int sala, int cantidad) {
        if (sala < 0 || sala >= salas.length) {
            return false;
        }
        synchronized (vigila[sala]) {
            salas[sala] += cantidad;
            System.out.printf("Sala %d: %d entradas devueltas\n", sala, cantidad);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return true;

        }
    }

    public int getLibres(int sala) {
        return salas[sala];
    }
}
