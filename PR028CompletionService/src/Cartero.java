import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 25/11/2015.
 */
public class Cartero implements Runnable {
    private CompletionService<String> servicio;
    private boolean finalizar;

    public Cartero(CompletionService<String> servicio, boolean finalizar) {
        this.servicio = servicio;
        this.finalizar = finalizar;
    }

    @Override
    public void run() {
        while (!finalizar) {
            try {

                Future<String> resultado = servicio.take();
                String informe = resultado.get();
                System.out.printf("Receptor -> Recibido %s\n", informe);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Receptor -> Finalizando...\n");
    }







}
