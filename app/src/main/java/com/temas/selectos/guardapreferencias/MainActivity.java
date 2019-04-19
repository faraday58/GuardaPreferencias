package com.temas.selectos.guardapreferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsuario;
    EditText edtContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario = findViewById(R.id.edtUusario);
        edtContra = findViewById(R.id.edtContra);
        cargarPreferencias();

    }

    private void cargarPreferencias() {
        SharedPreferences preferences= getSharedPreferences("credencial", Context.MODE_PRIVATE);
        String Usuario = preferences.getString("usuario","No existe información");
        String Contraseña= preferences.getString("contraseña","No existe Informacion");
        edtUsuario.setText(Usuario);
        edtContra.setText(Contraseña);

    }

    public void conClick(View v){
        guardarPreferencias();
    }

    private void guardarPreferencias() {
        SharedPreferences preferences= getSharedPreferences("credencial", Context.MODE_PRIVATE);
        String Usuario = edtUsuario.getText().toString();
        String Contraseña= edtContra.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("usuario",Usuario);
        editor.putString("contraseña",Contraseña);
        Toast.makeText(this,"Datos guardados \n " +Usuario +"\n" + Contraseña,Toast.LENGTH_LONG ).show();
        editor.commit();



    }


}
