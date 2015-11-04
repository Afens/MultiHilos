import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Usuario on 04/11/2015.
 */
public class Equipo implements Runnable {
    // Videoconferencia.
    private Videoconferencia videoconferencia;
    // Nombre del participante.
    private String nombre;
    // Numero de miembros.
    private int miembros;
    // Generador de números aleatorios para simular la conexión.
    Random aleatorio = new Random();

    // Constructor. Recibe la videoconferencia y el nombre del participante.
    public Equipo(Videoconferencia videoconferencia, String nombre, int miembros) {
        this.videoconferencia = videoconferencia;
        this.nombre = nombre;
        this.miembros = miembros;
    }

    @Override
    public void run() {
        // Simulo la conexión al sistema de videoconferencia.
        for (int i = 0; i < miembros; i++) {
            try {
                TimeUnit.SECONDS.sleep(aleatorio.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Me uno a la videoconferencia
            videoconferencia.unirse(nombre+" Miembro "+i);
        }
    }

}
