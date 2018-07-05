package com.baco.empresapolos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_button;
    int attempt_counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        LoginButton();

    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.etUsuario);
        password = (EditText)findViewById(R.id.etPassword);
        login_button = (Button)findViewById(R.id.button2);

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((username.getText().toString().equals("Bruno") && password.getText().toString().equals("Vargas")) || (username.getText().toString().equals("Anibal") && password.getText().toString().equals("Lajo"))){
                            Toast.makeText(Login.this,"Login exitoso",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, ActMain.class);
                            startActivityForResult(intent, 0);

                        }
                        else {https://github.com/Brunounsa/Lab12y13
                            Toast.makeText(Login.this,"Usuario o password incorrectas",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }
}
