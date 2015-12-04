/**
 * Created by Usuario on 04/12/2015.
 */
public class Cliente implements Runnable {
    Caja caja;
    String nombre;

    public Cliente(Caja caja, String nombre) {
        this.caja = caja;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        caja.realizarGestion(nombre);
    }
}
