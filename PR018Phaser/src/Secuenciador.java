import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Phaser;

/**
 * Created by Usuario on 09/11/2015.
 */
public class Secuenciador extends Phaser {
    SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

    public Secuenciador(int parties) {
        super(parties);
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:
                return comienzaExamen();
            case 1: case 2: case 3: case 4:
                return finEjercicio(phase);
            case 5:
                return finExamen();
            default:
                return true;
        }
    }

    private boolean finExamen() {
        System.out.println(formateador.format(new Date())
                + " --> Los estudiantes han finalizado el examen");
        return false;
    }

    private boolean finEjercicio(int phase) {
        System.out.println(formateador.format(new Date())
                + " --> Finalizado ejercicio " + phase + "\nComienza ejercicio "
                + (phase + 1));
        return false;
    }

    private boolean comienzaExamen() {
        System.out.println(formateador.format(new Date())
                + " --> Comienza el examen");
        return false;
    }
}
