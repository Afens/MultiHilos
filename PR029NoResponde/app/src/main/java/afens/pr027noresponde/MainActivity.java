package afens.pr027noresponde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    Thread hilo;
    private Button btn;
    private TextView lblHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

    }

    private void initview() {
        lblHora = (TextView) findViewById(R.id.lblHora);
        lblHora.setText(format.format(new Date()));
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn.getText().toString()
                        .equals(getString(R.string.iniciar))) {
                    iniciar();
                } else {
                    parar();
                }


            }
        });
    }

    private void parar() {
        hilo.interrupt();
        btn.setText(R.string.iniciar);
    }

    private void iniciar() {
        hilo = new Thread(new Reloj());
        hilo.start();
        btn.setText(R.string.parar);
    }

    private class Reloj implements Runnable {

        @Override
        public void run() {
            while (true) {
                final String cadena = format.format(new Date());
                lblHora.post(new Runnable() {
                    @Override
                    public void run() {
                        lblHora.setText(cadena);
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
