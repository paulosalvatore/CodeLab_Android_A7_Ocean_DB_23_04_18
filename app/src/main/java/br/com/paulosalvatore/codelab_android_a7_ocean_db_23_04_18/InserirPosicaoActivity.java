package br.com.paulosalvatore.codelab_android_a7_ocean_db_23_04_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class InserirPosicaoActivity extends AppCompatActivity {

    private EditText etLatitude;
    private EditText etLongitude;
    private EditText etDataHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_posicao);

        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        etDataHora = findViewById(R.id.etDataHora);
    }

    public void inserir(View view) {
        DatabaseHelper helper = new DatabaseHelper(this.getApplicationContext());
        DatabaseManager.inicializarInstancia(helper);
        DatabaseManager db = DatabaseManager.getInstancia();

        double latitude = Double.parseDouble(etLatitude.getText().toString());
        double longitude = Double.parseDouble(etLongitude.getText().toString());
        String data_hora = etDataHora.getText().toString();
        Posicao novaPosicao = new Posicao(latitude, longitude, data_hora);
        db.inserirPosicao(novaPosicao);
        Toast.makeText(this, "Posição inserida com sucesso.", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
