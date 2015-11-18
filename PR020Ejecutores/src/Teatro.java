import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Teatro {
    private ThreadPoolExecutor ejecutor;

    public Teatro() {
        ejecutor= (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    }

    public void sentar(Cliente cliente){
        ejecutor.execute(cliente);
        System.out.printf("Servidor -> Tamaño Grupo: %d\n",
                ejecutor.getPoolSize());
        System.out.printf("Servidor -> Hilos activos: %d\n",
                ejecutor.getActiveCount());
    }

    public void cerrar(){
        ejecutor.shutdown();
    }
}
