package com.baco.empresapolos;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baco.empresapolos.BaseDatos.DatosOpenHelper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.baco.empresapolos.BaseDatos.DatosOpenHelper;

public class ActNuevoProducto extends AppCompatActivity {

    private EditText etNombre;
    private EditText etPrecio;
    private EditText etColor;
    private EditText etTalla;

    private SQLiteDatabase conexion;
    private DatosOpenHelper datosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nuevo_producto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        etColor = (EditText) findViewById(R.id.etColor);
        etTalla = (EditText) findViewById(R.id.etTalla);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_nuevo_producto, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.action_ok:
                if(bCamposCorrectos()){
                    try{
                        datosOpenHelper = new DatosOpenHelper(this);
                        conexion = datosOpenHelper.getWritableDatabase();
                        StringBuilder sql = new StringBuilder();
                        sql.append("INSERT INTO PRODUCTO (ID, MARCA, COLOR, TALLA) VALUES ('");
                        sql.append(etNombre.getText().toString().trim() + "', '");
                        sql.append(etPrecio.getText().toString().trim() + "', '");
                        sql.append(etColor.getText().toString().trim() + "', '");
                        sql.append(etTalla.getText().toString().trim() + "')");

                        conexion.execSQL(sql.toString());
                        conexion.close();

                        finish();
                    }catch (Exception ex){
                        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                        dlg.setTitle("Aviso");
                        dlg.setMessage(ex.getMessage());
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                }
                else{
                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setTitle("Aviso");
                    dlg.setMessage("Existen campos vacios");
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }

            case R.id.action_cancelar:
                Toast.makeText(this, "Boton Ok seleccionado", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean bCamposCorrectos(){
        boolean res = true;
        if(etNombre.getText().toString().trim().isEmpty()){
            etNombre.requestFocus();
            res = false;
        }
        if(etPrecio.getText().toString().trim().isEmpty()){
            etPrecio.requestFocus();
            res = false;
        }
        if(etColor.getText().toString().trim().isEmpty()){
            etColor.requestFocus();
            res = false;
        }
        if(etTalla.getText().toString().trim().isEmpty()){
            etTalla.requestFocus();
            res = false;
        }
        return res;
    }

}
