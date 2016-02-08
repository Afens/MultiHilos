package afens.pr039alarmmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private EditText txtMsj;
    private EditText txtTime;
    private SwitchCompat sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();
    }

    private void initView() {
        txtMsj = (EditText) findViewById(R.id.txtMsj);
        txtTime = (EditText) findViewById(R.id.txtTime);
        sw= (SwitchCompat) findViewById(R.id.sw);
        // Se inicializan las vistas en base a los valores de las preferencias.
        SharedPreferences preferencias = getApplicationContext().getSharedPreferences("alarmas", Context.MODE_PRIVATE);
        txtMsj.setText(preferencias.getString(AvisarReceiver.PREF_MENSAJE,getString(R.string.quillo_ponte_ya_a_currar)));
        txtTime.setText(preferencias.getInt(AvisarReceiver.PREF_INTERVALO,AvisarReceiver.DEFAULT_INTERVAL) + "");
        sw.setChecked(AvisarReceiver.isAlarmaOn(getApplicationContext()));
        sw.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Cuando cambia el estado de la vista interruptor.
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // Dependiendo del estado en el que ha quedado
        if (isChecked) {
            // Se programa la alarma con los datos introducidos por el usuario.
            String mensaje = TextUtils.isEmpty(txtMsj.getText().toString()) ?
                    getString(R.string.quillo_ponte_ya_a_currar)
                    : txtMsj.getText().toString();
            int intervalo;
            try {
                intervalo = Integer.parseInt(txtTime.getText().toString());
            } catch (NumberFormatException e) {
                intervalo = AvisarReceiver.DEFAULT_INTERVAL;
            }
            AvisarReceiver.programarAlarma(getApplicationContext(), mensaje,
                    intervalo);
        } else {
            // Se desactiva la alarma.
            AvisarReceiver.cancelarAlarma(getApplicationContext());
        }

    }
}
