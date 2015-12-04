import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Usuario on 04/12/2015.
 */
public class Caja {
    private Semaphore guardia;
    private Empleado[] empleados;
    private boolean[] disponibles;
    private Lock lock = new ReentrantLock(true);
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    public Caja(int numEmpleados) {
        guardia = new Semaphore(numEmpleados, true);
        crearEmpleados(numEmpleados);
    }

    private void crearEmpleados(int numEmpleados) {
        empleados = new Empleado[numEmpleados];
        disponibles = new boolean[numEmpleados];
        for (int i = 0; i < numEmpleados; i++) {
            empleados[i] = new Empleado(i+1);
            disponibles[i] = true;
        }

    }

    public void realizarGestion(String nombreCliente) {
        try {
            System.out.printf("%s --> %s Ha entrado en BaldoCaja\n",format.format(new Date()),nombreCliente);
            guardia.acquire();
            Empleado empleado = adquirirEmpleado();
            System.out.printf("%s --> %s Esta siendo atendido por el Empleado %d\n"
                    ,format.format(new Date()),nombreCliente,empleado.getNumeroEmpleado());
            empleado.realizarGestion();
            terminar(empleado);
            System.out.printf("%s --> %s Ha salido de BaldoCaja\n",format.format(new Date()),nombreCliente);
            guardia.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void terminar(Empleado empleado) {
        lock.lock();
        disponibles[empleado.getNumeroEmpleado() - 1] = true;
        lock.unlock();
    }

    private Empleado adquirirEmpleado() {
        int i = -1;
        lock.lock();
        for (int j = 0; j < disponibles.length; j++) {
            if (disponibles[j]){
                i=j;
                disponibles[j]=false;
                break;
            }
        }
        lock.unlock();
        return empleados[i];
    }
}
