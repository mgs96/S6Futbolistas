package com.uninorte.s6futbolistas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etApellido;
    EditText etPosicion;
    Button btOn;
    Button btOff;
    EditText etEdad;
    Button btSave;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etPosicion = findViewById(R.id.etPosicion);
        btOn = findViewById(R.id.btOn);
        btOff = findViewById(R.id.btOff);
        etEdad = findViewById(R.id.etEdad);
        btSave = findViewById(R.id.btSave);

        Intent intent = getIntent();
        Jugador j = (Jugador) intent.getSerializableExtra("jugador");
        int editar = intent.getIntExtra("editar", 0);
        id = intent.getIntExtra("id", 0);
        if (editar == 1) {
            etNombre.setEnabled(true);
            etApellido.setEnabled(true);
            etPosicion.setEnabled(true);
            btOn.setEnabled(true);
            btOff.setEnabled(true);
            etEdad.setEnabled(true);
            btSave.setEnabled(true);
        } else {
            etNombre.setEnabled(false);
            etApellido.setEnabled(false);
            etPosicion.setEnabled(false);
            btOn.setEnabled(false);
            btOff.setEnabled(false);
            etEdad.setEnabled(false);
            btSave.setEnabled(false);
        }
    }

    public void OnClickSave(View view) {
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String posicion = etPosicion.getText().toString();
        boolean onof = true;
        String edad = etEdad.getText().toString();
        Jugador editado = new Jugador(nombre, apellido, posicion, onof, Integer.valueOf(edad));
        Intent returnIntent = new Intent();
        returnIntent.putExtra("jugador", editado);
        returnIntent.putExtra("id", id);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
