package afens.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnIniciar;
    private ProgressBar prbBarra;
    private TextView lblMensaje;
    private ProgressBar prbCirculo;
    private TareaSecundaria tarea;

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
        tarea = new TareaSecundaria();
        mostrarBarras(5);
        tarea.execute(5);
    }

    private void mostrarBarras(int max) {
        prbBarra.setVisibility(View.VISIBLE);
        lblMensaje.setText(R.string.trabajando);
        lblMensaje.setVisibility(View.VISIBLE);
        prbCirculo.setVisibility(View.VISIBLE);
        prbBarra.setMax(max);
    }

    private void actualizarBarras(int progreso,int total) {
        lblMensaje.setText(getString(R.string.trabajando, progreso, total));
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
    private class TareaSecundaria extends AsyncTask<Integer, Integer, Integer> {


        @Override
        protected Integer doInBackground(Integer... params) {
            for (int i = 0; i < params[0]; i++) {
                publishProgress(i+1,params[0]);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isCancelled())
                    break;
            }
            return params[0];
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            actualizarBarras(values[0],values[1]);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            mostrarRealizadas(integer);
            resetearVistas();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (tarea != null) {
            tarea.cancel(true);
            tarea = null;
        }
    }

}
