package afens.pr030handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private static final int onPreExecute = 0;
    private static final int onProgressUpdate = 1;
    private static final int onPostExecute = 2;
    private Button btnIniciar;
    private ProgressBar prbBarra;
    private TextView lblMensaje;
    private ProgressBar prbCirculo;
    private Manejador manejador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        prbBarra = (ProgressBar) findViewById(R.id.prbBarra);
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        prbCirculo = (ProgressBar) findViewById(R.id.prbCirculo);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });
    }

    private void iniciar() {
        btnIniciar.setEnabled(false);
        manejador = new Manejador(this);
        Thread hiloSecundario = new Thread(new Tarea());
        hiloSecundario.start();
    }


    private class Tarea implements Runnable {
        @Override
        public void run() {
            inicio();
            trabajando();
            fin();
        }

        private void inicio() {
            Message msgInicio = new Message();
            msgInicio.what = onPreExecute;
            manejador.sendMessage(msgInicio);
        }

        private void trabajando() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msgProgreso = new Message();
                msgProgreso.what = onProgressUpdate;
                msgProgreso.arg1 = i + 1;
                manejador.sendMessage(msgProgreso);
            }
        }

        private void fin() {
            Message msgFin = new Message();
            msgFin.what = onPostExecute;
            msgFin.arg1 = 10;
            manejador.sendMessage(msgFin);
        }
    }


    private static class Manejador extends Handler {

        private final WeakReference<MainActivity> mActivityWeakReference;

        public Manejador(MainActivity mainActivity) {
            mActivityWeakReference = new WeakReference<>(mainActivity);
        }
        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivityWeakReference.get();
            if (activity != null) {
                switch (msg.what) {
                    case onPreExecute:
                        activity.mostrarBarras();
                        break;
                    case onProgressUpdate:
                        int progreso = msg.arg1;
                        activity.actualizarBarras(progreso);
                        break;
                    case onPostExecute:
                        int tareas = msg.arg1;
                        activity.mostrarRealizadas(tareas);
                        activity.resetearVistas();
                        break;
                }
            }
        }

    }

    private void mostrarBarras() {
        prbBarra.setVisibility(View.VISIBLE);
        lblMensaje.setText(R.string.trabajando);
        lblMensaje.setVisibility(View.VISIBLE);
        prbCirculo.setVisibility(View.VISIBLE);
    }

    private void actualizarBarras(int progreso) {
        lblMensaje.setText(getString(R.string.trabajando, progreso, 10));
        prbBarra.setProgress(progreso);
    }

    private void mostrarRealizadas(int tareas) {
        lblMensaje.setText(getResources().getQuantityString(
                R.plurals.realizadas, tareas, tareas));
    }

    private void resetearVistas() {
        prbBarra.setVisibility(View.INVISIBLE);
        prbBarra.setProgress(0);
        prbCirculo.setVisibility(View.INVISIBLE);
        prbCirculo.setProgress(0);
        btnIniciar.setEnabled(true);
    }
}
