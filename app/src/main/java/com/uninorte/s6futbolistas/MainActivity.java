package com.uninorte.s6futbolistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    ArrayList<Jugador> jugadores;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.convocados);

        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Javier", "Zanneti", "Lateral", true, 42));
        jugadores.add(new Jugador("Teofilo", "Gutierrez", "Delantero", true, 32));
        jugadores.add(new Jugador("Macnelly", "Torres", "Volante", false, 33));
        jugadores.add(new Jugador("Yimmi", "Chará", "Volante", true, 26));

        customAdapter = new CustomAdapter(this, jugadores);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "Click en " + position);
                Intent two = new Intent(view.getContext(), SecondActivity.class);
                two.putExtra("jugador", jugadores.get(position));
                two.putExtra("id", (int) position);
                two.putExtra("editar", 0);
                startActivity(two);
            }
        });
    }

    public void OnClickEditar(View view) {
        Log.d("TAG", "Click en boton" + view.getTag());
        Intent two = new Intent(this, SecondActivity.class);
        two.putExtra("jugador", jugadores.get((int) view.getTag()));
        two.putExtra("id", (int) view.getTag());
        two.putExtra("editar", 1);
        startActivityForResult(two, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                int id = data.getIntExtra("id", 0);
                Jugador returnData = (Jugador) data.getSerializableExtra("jugador");
                jugadores.remove(id);
                jugadores.add(id, returnData);
                customAdapter.setData(jugadores);
                lv.setAdapter(customAdapter);
            }
        }
    }
}
