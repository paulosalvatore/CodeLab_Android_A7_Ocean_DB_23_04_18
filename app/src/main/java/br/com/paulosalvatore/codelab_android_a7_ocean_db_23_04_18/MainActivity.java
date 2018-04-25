package br.com.paulosalvatore.codelab_android_a7_ocean_db_23_04_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvPosicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPosicoes = findViewById(R.id.tvPosicoes);
    }

    @Override
    protected void onResume() {
        super.onResume();

        exibirPosicoes();
    }

    public void inserirPosicao(View view) {
        Intent i = new Intent(this, InserirPosicaoActivity.class);
        startActivity(i);
    }

    public void exibirPosicoes(View view) {
        exibirPosicoes();
    }

    public void exibirPosicoes() {
        tvPosicoes.setText("");

        DatabaseHelper helper = new DatabaseHelper(this.getApplicationContext());
        DatabaseManager.inicializarInstancia(helper);
        DatabaseManager db = DatabaseManager.getInstancia();

        List<Posicao> posicoes = db.obterPosicoes();

        for (Posicao posicao : posicoes) {
            tvPosicoes.append(String.valueOf(posicao.getId()) + "\n");
            tvPosicoes.append(String.valueOf(posicao.getLatitude()) + "\n");
            tvPosicoes.append(String.valueOf(posicao.getLongitude()) + "\n");
            tvPosicoes.append(String.valueOf(posicao.getData_hora()) + "\n");
            tvPosicoes.append("\n");
        }
    }
}
