import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 04/12/2015.
 */
public class Empleado {
    //Atiende al cliente
    int numeroEmpleado;
    Random rnd=new Random();
    public Empleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }


    public void realizarGestion() {
        try {
            TimeUnit.SECONDS.sleep(rnd.nextInt(4)+1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
